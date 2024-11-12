package com.openmind.ezdg.api.service;

import com.openmind.ezdg.datalist.dto.ApiDataDto;
import com.openmind.ezdg.generate.library.openapi.CodeGenerator;
import com.openmind.ezdg.generate.library.openapi.FastApiResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class OpenApiService {

    @Value("${external.api.fastApi}")
    private String fastApiUrl;

    private final CodeGenerator codeGenerator;

    public ApiDataDto callFastApiCroller(String url, String crollerOption) {
        String param = "/table";
        if("Swagger".equals(crollerOption)) {
            param = "/swagger";
        }

        String requestUrl = fastApiUrl + param;

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("url", url);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<ApiDataDto> response = restTemplate.exchange(
                requestUrl,
                HttpMethod.POST,
                entity,
                ApiDataDto.class
        );

        if(response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("크롤링에 오류가 발생했습니다.");
        }
    }

    public void generateLibraryCode(List<FastApiResponseDto> apiList) {
        for (FastApiResponseDto api : apiList) {
            codeGenerator.generateCode(api);
        }
    }
}
