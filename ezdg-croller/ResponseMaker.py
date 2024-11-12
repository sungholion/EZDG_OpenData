import re

def make_response(title, description, url, requests, responses):
    # URL 파싱 및 필요한 부분 추출
    global endpoint_name, service_name

    parts = url.split('/')
    service_name = parts[-2]  # 'VilageFcstInfoService_2.0'
    service_name = service_name.split('_')[0]
    endpoint_name = parts[-1]  # 'getUltraSrtFcst'
    class_name = endpoint_name.split('get')[-1].title()

    api = {
        'title': title,
        'description': description,
        'packageName' : service_name,
        'className' : class_name,
        'baseUrl' : url.rsplit('/', 1)[0],
        'endpoint' : "/" + endpoint_name,
        'requestFields' : requests,
        'responseFields' : responses
    }

    return api


def make_swagger_response(title_list, url, requestlist, responselist, description_text):
    service_name = url.split('/')[-1]  # 'VilageFcstInfoService'

    response_item = []
    #endpoint_list = requestlist.keys()
    for (k, v), response, title, description in zip(requestlist.items(), responselist, title_list, description_text):
        response_item.append(
            {
                'title': title,
                'description': description,
                'packageName': service_name,
                'className': k.lstrip("/get"),
                'baseUrl': url,
                'endpoint': k,
                'requestFields': v,
                'responseFields': response
            }
        )

    return response_item



