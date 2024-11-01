package com.openmind.ezdg.generate.library.openapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@Service
public class FastApiCallService implements ExternalApiCallService {

    //@Value("${fast-api.url}")
    private String baseUrl = "http://192.168.100.149:8000";

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private RestTemplate restTemplate;

    public FastApiCallService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    public void printLogBaseUrl() {
        log.info("----------FastAPI URL={}----------", baseUrl);
    }

    @Override
    public String tableFormApi(String s) {
        String url = baseUrl + "/table";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestJson = "{\"url\":\"" + s + "\"}";
        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);

        try {
            log.debug("Sent request to FastAPI server, URL={}", url);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            log.debug("Received response from FastAPI server, response={}", response);

            String responseBody = response.getBody();
            if (responseBody != null) {
                // JSON 파일로 저장할 경로와 파일 이름 설정
                String packagePath = this.getClass().getPackage().getName().replace('.', '/');
                String filePath = "src/main/resources/" + "api_spec_generated.json";

                // 경로가 존재하지 않으면 생성
//                Path path = Path.of("path/to/your/directory");
//                if (!Files.exists(path)) {
//                    Files.createDirectories(path);
//                }

                // JSON 응답을 파일에 쓰기
                try (FileWriter fileWriter = new FileWriter(filePath)) {
                    fileWriter.write(responseBody);
                    log.info("Response saved as JSON file at {}", filePath);
                } catch (IOException e) {
                    log.error("Error writing JSON to file: {}", e.getMessage());
                }

                return filePath; // 저장된 파일 경로를 반환하거나 필요시 null 반환
            } else {
                log.warn("Empty response body received from FastAPI server.");
                return null;
            }
        } catch (ResourceAccessException e) {
            log.error("ResourceAccessException: {}", e.getMessage());
            return null;
        } catch (Exception e) {
            log.error("Exception while calling FastAPI: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}



