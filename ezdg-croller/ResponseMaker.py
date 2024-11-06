import re

def make_response(url, requests, responses):
    # URL 파싱 및 필요한 부분 추출
    global endpoint_name, service_name

    pattern = r"/([^/]+)_\d+\.\d+/([^/]+)$"
    match = re.search(pattern, url)

    if match:
        service_name = match.group(1)  # 'VilageFcstInfoService'
        endpoint_name = match.group(2)  # 'getUltraSrtFcst'

        print("Service Name:", service_name)
        print("Endpoint Name:", endpoint_name)
    else:
        print("URL에서 정보를 추출할 수 없습니다.")

    response = {
        'packageName' : service_name,
        'className' : service_name.title(),
        'baseUrl' : url.rsplit('/', 1)[0],
        'endpoint' : "/" + endpoint_name,
        'requestFields' : requests,
        'responseFields' : responses
    }

    return response


def make_responselist(url, requestlist, responselist):
    service_name = url.split('/')[-1]  # 'VilageFcstInfoService'
    response_item = []
    #endpoint_list = requestlist.keys()
    for (k, v), response in zip(requestlist.items(), responselist):
        response_item.append(
            {
                'packageName': service_name,
                'className': k.lstrip("/get"),
                'baseUrl': url,
                'endpoint': k,
                'requestFields': v,
                'responseFields': response
            }
        )

    return response_item



