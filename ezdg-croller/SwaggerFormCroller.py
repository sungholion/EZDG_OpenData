from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import re
import json
import time

# Chrome WebDriver 경로 설정
driver = webdriver.Chrome()

try:
    # 웹페이지 URL(기상청_단기예보 ((구)_동네예보) 조회서비스)
    url = "https://www.data.go.kr/data/15056912/openapi.do#"

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
        # paths에서 각 endpoint의 parameters 추출
        request_parameters = {}
        for path, methods in swagger_data.get("paths", {}).items():
            for method, details in methods.items():
                if "parameters" in method:
                    request_parameters[path] = details
        # 추출된 parameters 출력
        print("REQUEST 출력할게~~!!~!!~!~!!")
        print(request_parameters)
        #print(json.dumps(request_parameters, indent=4, ensure_ascii=False))
    else:
        print("swaggerJson을 찾을 수 없습니다.")

    #----------------------------RESPONSE--------------------------------------#

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
    print("RESPONSE 출력할게~~!!~!!~!~!!")
    print(response_data)


finally:
    # 드라이버 종료
    driver.quit()
