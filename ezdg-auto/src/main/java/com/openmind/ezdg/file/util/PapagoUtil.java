package com.openmind.ezdg.file.util;

import com.openmind.ezdg.file.dto.externalApi.naver.PapagoResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class PapagoUtil {

    @Value("${external.api.naver.papago.id}")
    private String id;

    @Value("${external.api.naver.papago.key}")
    private String key;

    @Value("${external.api.naver.papago.glossarykey}")
    private String glossaryKey;

    private static final String url = "https://naveropenapi.apigw.ntruss.com/nmt/v1/translation";

    /**
     * Papago API를 활욯하여 파일 이름 한<->영 번역
     * @param originFileName
     * @return 번역된 파일 이름
     */
    public String translateFileName(String originFileName) {
        return callRestApi(originFileName);
    }

    /**
     * Papago API를 활욯하여 칼럼 이름 한<->영 번역
     * @param columns
     * @return 번역된 칼럼 이름
     */
    public String translateColumns(String[] columns) {
        String column = String.join(",", columns);
        return callRestApi(column);
    }

    /**
     * papago API 호출 후 번역된 텍스트만 반환
     * @param text
     * @return 번역된 텍스트
     */
    private String callRestApi(String text) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-ncp-apigw-api-key-id", id);
        headers.set("x-ncp-apigw-api-key", key);

        // json
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("source", "ko");
        requestBody.put("target", "en");
        requestBody.put("text", text);
        requestBody.put("glossaryKey", glossaryKey);
        requestBody.put("replaceInfo", "");
        requestBody.put("honorific", false);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<PapagoResponseDto> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                PapagoResponseDto.class
        );

        if(response.getStatusCode().is2xxSuccessful()) {
            return response.getBody().getMessage().getTranslatedText();
        } else {
            throw new RuntimeException("파일 칼럼 네이버 파파고 API 호출 실패");
        }
    }

}
