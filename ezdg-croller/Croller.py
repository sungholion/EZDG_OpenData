from bs4 import BeautifulSoup
import requests
from TableResponseMaker import make_response
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
    global response_data
    driver = webdriver.Chrome()

    try:
        # 웹페이지 URL(기상청_단기예보 ((구)_동네예보) 조회서비스)
        # url = "https://www.data.go.kr/data/15056912/openapi.do#"

        # 웹페이지 열기
        driver.get(url)

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
            # print(swagger_data)
            # paths에서 각 endpoint의 parameters 추출
            request_parameters = {}
            for path, methods in swagger_data.get("paths", {}).items():
                for method, details in methods.items():
                    if "parameters" in method:
                        extract_details = {}
                        for a in details:
                            print(a)
                            extract_details[a.get("name")] = a.get("type")
                            # extract_details.append({b : c})
                        request_parameters[path] = extract_details
            # 추출된 parameters 출력
            print("REQUEST 출력할게~~!!~!!~!~!!")
            print(request_parameters)
        else:
            print("swaggerJson을 찾을 수 없습니다.")

        # ----------------------------RESPONSE--------------------------------------#
        # 버튼을 클릭하기 위해 aria-label 속성값을 사용해 요소를 찾음
        buttons = driver.find_elements(By.CLASS_NAME, 'opblock-summary-control')
        for button in buttons:

            button.click()
            # 버튼 클릭 후 새로운 페이지로 이동하는 경우 약간의 대기 추가
            time.sleep(3)  # 필요에 따라 대기 시간 조정
            response_data = {}
            # highlight-code 블럭을 모두 찾습니다.
            highlight_code_blocks = driver.find_elements(By.CSS_SELECTOR, "code.language-json")

            for idx, block in enumerate(highlight_code_blocks, start=1):
                code_text = block.text

                # JSON 형식의 텍스트에서 줄바꿈을 제거
                try:
                    # JSON 문자열을 Python 딕셔너리로 변환
                    json_data = json.loads(code_text)
                    # JSON 데이터를 줄바꿈 없이 문자열로 변환하여 저장
                    response_data[f"code_block_{idx}"] = json.dumps(json_data, ensure_ascii=False, separators=(",", ":"))
                except json.JSONDecodeError:
                    # JSON 파싱에 실패할 경우 원본 텍스트를 그대로 저장
                    response_data[f"code_block_{idx}"] = code_text

        # 크롤링한 내용을 출력
        # print("RESPONSE 출력할게~~!!~!!~!~!!")
        # print(response_data)
        response_list = []


    finally:
        # 드라이버 종료
        driver.quit()