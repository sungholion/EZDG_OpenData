package com.openmind.ezdg.generate.library.openapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class FastApiCallService implements ExternalApiCallService {
    private final String baseUrl = "http://192.168.100.149:8000";
    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;
    private final CodeGenerator codeGenerator;

    @Autowired
    public FastApiCallService(RestTemplate restTemplate, ObjectMapper objectMapper, CodeGenerator codeGenerator) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.codeGenerator = codeGenerator;
    }

    @Override
    public List<FastApiResponseDto> tableFormApi(String s) {
        String url = baseUrl + "/table";
        return callApi(url, s);
    }

    @Override
    public List<FastApiResponseDto> swaggerFormApi(String s) {
        String url = baseUrl + "/swagger";
        return callApi(url, s);
    }

    private List<FastApiResponseDto> callApi(String url, String s) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestJson = "{\"url\":\"" + s + "\"}";
        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);

        try {
            log.debug("Sent request to FastAPI server, URL={}", url);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            String responseBody = response.getBody();

            if (responseBody != null) {
                // FastAPI 응답을 DTO 리스트로 변환
                JsonNode rootNode = objectMapper.readTree(responseBody);
                JsonNode apiList = rootNode.get("apiList");
                List<FastApiResponseDto> apiSpecs = objectMapper.readValue(
                        apiList.toString(),
                        objectMapper.getTypeFactory().constructCollectionType(List.class, FastApiResponseDto.class)
                );

                // 각 API 스펙에 대해 코드 생성
                for (FastApiResponseDto apiSpec : apiSpecs) {
                    try {
                        codeGenerator.generateCode(apiSpec);
                        log.info("Code generation completed for {}", apiSpec.getClassName());
                    } catch (Exception e) {
                        log.error("Failed to generate code for {}: {}", apiSpec.getClassName(), e.getMessage());
                    }
                }
                return apiSpecs;
            }
            return new ArrayList<>();
        } catch (Exception e) {
            log.error("Error occurred while processing API call", e);
            throw new RuntimeException("Failed to process API call", e);
        }
    }
}