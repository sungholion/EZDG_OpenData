package com.openmind.ezdg.generate.library.openapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.utils.URIBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAPI<T> {
    protected URIBuilder uriBuilder;
    private final ObjectMapper mapper = new ObjectMapper();

    public AbstractAPI(String endpoint) {
        // 공공데이터포털 API 엔드포인트 설정
        uriBuilder = new URIBuilder()
                .setScheme("http")
                .setHost("apis.data.go.kr")
                .setPath("/1360000/VilageFcstInfoService_2.0" + endpoint); // 경로 수정
    }


    public List<T> fetch() {
        try {
            URL url = uriBuilder.build().toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");

            // 응답 코드가 200(정상)일 때 JSON 응답을 처리
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    JsonNode rootNode = mapper.readTree(reader);
                    return mapper.convertValue(rootNode, new TypeReference<List<T>>() {});
                }
            } else {
                System.err.println("Failed to fetch data. HTTP response code: " + conn.getResponseCode());
                return new ArrayList<>(); // 빈 리스트 반환
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // 예외 발생 시 빈 리스트 반환
        }
    }
}
