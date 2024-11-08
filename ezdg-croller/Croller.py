from bs4 import BeautifulSoup
import requests
from ResponseMaker import make_response, make_swagger_response
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import Select
global sample_data_type
import json
import time
import re

global response_data

def find_main_title(url):
    # URL에서 HTML 가져오기
    response = requests.get(url)
    if response.status_code == 200:
        html_content = response.text
        soup = BeautifulSoup(html_content, 'html.parser')

        # 제목 부분 추출
        title = soup.find('p', class_='tit open-api-title').get_text(strip=True)
        # print("제목:", title)

        # 설명 부분 추출
        description = soup.find('div', class_='cont').find('span').get_text(strip=True)
        # print("설명:", description)

        return title, description

def table_crawler(title, html_content):
    soup = BeautifulSoup(html_content, 'html.parser')

    # '서비스URL' 항목을 찾아서 URL을 가져옴
    service_url = None
    for item in soup.find_all('li'):
        if item.find('strong') and item.find('strong').text.strip() == '요청주소':
            service_url = item.get_text(strip=True).replace('요청주소', '').strip()
            break

    # class가 'tit'인 <h4> 태그 찾기(description임)
    description = soup.find('h4', class_='tit').get_text(strip=True)
    print(description)

    # 'REQUEST' 크롤링
    request_parameters = []
    request_table = soup.find('h4', string='요청변수(Request Parameter)').find_next('table')
    for row in request_table.find_all('tr')[1:]:  # 첫 번째 행(헤더)은 건너뛰기
        columns = row.find_all('td')
        if columns:
            data = {
                'type': "String",
                'name': columns[1].text.strip(),
                'description': columns[5].text.strip(),
                'required': columns[3].text.strip(),
                'sampleData': columns[4].text.strip(),
            }
            request_parameters.append(data)

    # 'RESPONSE' 크롤링
    response_elements = []
    response_table = soup.find('h4', string='출력결과(Response Element)').find_next('table')
    for row in response_table.find_all('tr')[1:]:  # 첫 번째 행(헤더)은 건너뛰기
        columns = row.find_all('td')
        if columns:
            api_name = columns[1].text.strip()
            sample_data_type = "String" if any(
                term in api_name.lower() for term in ["date", "time", "obsr"]) else "Integer"
            data = {
                'type': sample_data_type,
                'name': api_name,
                'description': columns[5].text.strip(),
            }
            response_elements.append(data)

    return make_response(title, description, service_url, request_parameters, response_elements)


def main_crawler(url):
    # Selenium WebDriver 설정
    driver = webdriver.Chrome()  # ChromeDriver 경로 설정
    driver.get(url)
    main_title, main_description = find_main_title(url)
    response = {"mainTitle" : main_title, "mainDescription" : main_description}
    apiList = []
    try:
        # 목록에서 옵션을 선택하고, 조회 버튼 클릭
        select_element = WebDriverWait(driver, 10).until(
            EC.presence_of_element_located((By.ID, "open_api_detail_select"))
        )
        select = Select(select_element)
        for option in select.options:
            #print(option.get_attribute('value'))
            title = option.text.strip()
            print(f" 제목: {title}")
            # 각 옵션 선택
            select.select_by_value(option.get_attribute('value'))

            # 조회 버튼 클릭
            driver.find_element(By.XPATH, "//button[contains(text(), '조회')]").click()

            # 2초 대기
            time.sleep(2)

            # 페이지가 새로 로드되거나 업데이트될 시간을 기다림
            WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.ID, "open-api-detail-result")))

            # 페이지의 HTML 가져오기
            html_content = driver.page_source

            # 크롤링 함수 호출
            apiList.append(table_crawler(title, html_content))

        response["apiList"] = apiList
        return response

    finally:
        driver.quit()

def swagger_crawler(url):
    # Chrome WebDriver 경로 설정
    global response_data, request_parameters
    driver = webdriver.Chrome()
    main_title, main_description = find_main_title(url)

    try:
        # 웹페이지 열기
        driver.get(url)

        # <pre> 태그에서 class가 'base-url'인 요소 찾기
        base_url_element = driver.find_element(By.CLASS_NAME, 'base-url')

        # Base URL 텍스트 추출
        base_url_text = base_url_element.text
        base_url = "https://" + base_url_text.split('Base URL:')[-1].strip(" ]")

        # 페이지가 완전히 로드될 때까지 대기
        WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.TAG_NAME, 'body')))

        # 'opblock-summary-description' 클래스를 가진 요소들 찾기
        description_elements = driver.find_elements(By.CLASS_NAME, "opblock-summary-description")
        title_list = [element.text for element in description_elements]
        print(title_list)

        # 모든 <script> 태그에서 swaggerJson 찾기
        scripts = driver.find_elements(By.TAG_NAME, 'script')
        swagger_json = None

        description_list = []

        for script in scripts:
            script_content = script.get_attribute('innerHTML')
            # JavaScript 변수 swaggerJson이 포함된 코드 찾기
            if 'var swaggerJson' in script_content:
                # swaggerJson의 내용을 정규 표현식으로 추출
                match = re.search(r'var swaggerJson = (.*?);', script_content, re.DOTALL)
                if match:
                    swagger_json = match.group(1).replace('`', '"')
                    break

        if swagger_json:
            swagger_json = swagger_json.strip('"')
            # JSON 문자열을 Python 객체로 변환
            swagger_data = json.loads(swagger_json)
            # paths에서 각 endpoint의 parameters 추출
            request_parameters = {}
            for path, methods in swagger_data.get("paths", {}).items():
                param_after = []
                for method, details in methods.items():
                    if "parameters" in method:
                        for a in details:
                            del a['in']
                            if 'type' in a:
                                a['type'] = a['type'].title()
                            param_after.append(a)
                        request_parameters[path] = param_after

        else:
            print("swaggerJson을 찾을 수 없습니다.")

        # ----------------------------RESPONSE--------------------------------------#
        # 버튼을 클릭하기 위해 aria-label 속성값을 사용해 요소를 찾음
        buttons = driver.find_elements(By.CLASS_NAME, 'opblock-summary-control')
        for button in buttons:
            button.click()
            # 버튼 클릭 후 새로운 페이지로 이동하는 경우 약간의 대기 추가
            time.sleep(3)  # 필요에 따라 대기 시간 조정

            # 'opblock-description' 클래스를 가진 요소 찾기
            description_elements = driver.find_elements(By.CLASS_NAME, "opblock-description")
            description_text = [element.text for element in description_elements]
            print(description_text)

            response_data = []
            # highlight-code 블럭을 모두 찾습니다.
            highlight_code_blocks = driver.find_elements(By.CSS_SELECTOR, "code.language-json")


            for idx, block in enumerate(highlight_code_blocks, start=1):
                code_text = block.text
                # JSON 형식의 텍스트에서 줄바꿈을 제거
                try:
                    # JSON 문자열을 Python 딕셔너리로 변환
                    json_data = json.loads(code_text)
                    # item에 접근하여 원하는 형식으로 변환
                    item_data = json_data['body']['items']['item']
                    #item_data = json_data['response']['body']['items']['item']
                    item_list = [{"name": key, "type": value.title(), "description": None} for key, value in item_data.items()]

                    response_data.append(item_list)
                    #print(item_list)
                except json.JSONDecodeError:
                    # JSON 파싱에 실패할 경우 원본 텍스트를 그대로 저장
                    response_data[f"code_block_{idx}"] = code_text

        # 크롤링한 내용을 출력
        # print("Base URL 출력할게~~!!~!!~!~!!")
        # print(base_url)
        # print("REQUEST 출력할게~~!!~!!~!~!!")
        # print(request_parameters)
        # print("RESPONSE 출력할게~~!!~!!~!~!!")
        # print(response_data)
        # print("DSL 출력할게~~!!~!!~!~!!")
        # print(description_list)


        return {"mainTitle":main_title, "mainDescription": main_description, "apiList" : make_swagger_response(title_list, base_url, request_parameters, response_data, description_text)}


    finally:
        # 드라이버 종료
        driver.quit()