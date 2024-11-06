from bs4 import BeautifulSoup
import requests
from ResponseMaker import make_response, make_responselist
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
global sample_data_type
import json
import time
import re

global response_data

def table_croller(url):
    # HTTP GET 요청
    global sample_data_type
    response = requests.get(url)
    # 요청이 성공했는지 확인
    if response.status_code == 200:
        soup = BeautifulSoup(response.text, 'html.parser')
        # '서비스URL' 항목을 찾아서 URL을 가져옴
        service_url = None

        for item in soup.find_all('li'):
            if item.find('strong') and item.find('strong').text.strip() == '요청주소':
                service_url = item.get_text(strip=True).replace('요청주소', '').strip()
                break
        print("서비스 URL:", service_url)

        request_parameters = []
        request_table = soup.find('h4', string='요청변수(Request Parameter)').find_next('table')
        for row in request_table.find_all('tr')[1:]:  # 첫 번째 행(헤더)은 건너뛰기

            columns = row.find_all('td')
            sample_data = columns[4].text.strip()
            if columns:
                sample_data_type = "String"
                data = {
                    'type': sample_data_type,
                    'name': columns[1].text.strip(),
                    'description': columns[5].text.strip(),
                    'required' : columns[3].text.strip(),
                    'sampleData' : columns[4].text.strip(),
                }
                request_parameters.append(data)

        # 출력결과 데이터 추출
        response_elements = []
        response_table = soup.find('h4', string='출력결과(Response Element)').find_next('table')
        for row in response_table.find_all('tr')[1:]:  # 첫 번째 행(헤더)은 건너뛰기
            columns = row.find_all('td')
            if columns:
                sample_data = columns[4].text.strip()
                api_name = columns[1].text.strip()
                if columns:
                    try:
                        if ("date" in api_name.lower()) or ("time" in api_name.lower()) or ("obsr" in api_name.lower()):
                            sample_data_type = "String"
                        else:
                            int(sample_data)  # 정수 변환 시도
                            sample_data_type = "Integer"
                    except ValueError:
                         sample_data_type = "String"

                data = {
                    'type': sample_data_type,
                    'name': columns[1].text.strip(),
                    'description': columns[5].text.strip(),
                }
                response_elements.append(data)

        # 결과 출력
        print("요청변수(Request Parameter):")
        for param in request_parameters:
            print(param)

        print("\n출력결과(Response Element):")
        for element in response_elements:
            print(element)
        return make_response(service_url, request_parameters, response_elements)

    else:
        print("웹사이트에 접근할 수 없습니다.", response.status_code)

def swagger_controller(url):
    # Chrome WebDriver 경로 설정
    global response_data, request_parameters
    driver = webdriver.Chrome()

    try:
        # 웹페이지 열기
        driver.get(url)

        # <pre> 태그에서 class가 'base-url'인 요소 찾기
        base_url_element = driver.find_element(By.CLASS_NAME, 'base-url')

        # Base URL 텍스트 추출
        base_url_text = base_url_element.text
        base_url = "https://" + base_url_text.split('Base URL:')[-1].strip(" ]")
        #print("Extracted Base URL:", base_url)

        # 페이지가 완전히 로드될 때까지 대기
        WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.TAG_NAME, 'body')))

        # 모든 <script> 태그에서 swaggerJson 찾기
        scripts = driver.find_elements(By.TAG_NAME, 'script')

        swagger_json = None
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
                    item_list = [{"name": key, "type": value.title(), "description": None} for key, value in item_data.items()]

                    response_data.append(item_list)
                    #print(item_list)
                except json.JSONDecodeError:
                    # JSON 파싱에 실패할 경우 원본 텍스트를 그대로 저장
                    response_data[f"code_block_{idx}"] = code_text

        # 크롤링한 내용을 출력
        print("Base URL 출력할게~~!!~!!~!~!!")
        print(base_url)
        print("REQUEST 출력할게~~!!~!!~!~!!")
        print(request_parameters)
        print("RESPONSE 출력할게~~!!~!!~!~!!")
        print(response_data)
        return make_responselist(base_url, request_parameters, response_data)


    finally:
        # 드라이버 종료
        driver.quit()