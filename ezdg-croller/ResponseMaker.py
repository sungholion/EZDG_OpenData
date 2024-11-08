import re

def make_response(url, requests, responses):
    # URL 파싱 및 필요한 부분 추출
    global endpoint_name, service_name

    parts = url.split('/')
    service_name = parts[-2]  # 'VilageFcstInfoService'
    endpoint_name = parts[-1]  # 'getUltraSrtFcst'

    api = {
        'packageName' : service_name,
        'className' : service_name.title(),
        'baseUrl' : url.rsplit('/', 1)[0],
        'endpoint' : "/" + endpoint_name,
        'requestFields' : requests,
        'responseFields' : responses
    }

    return api


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



