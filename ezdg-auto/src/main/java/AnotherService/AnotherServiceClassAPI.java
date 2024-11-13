package AnotherService;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AnotherServiceClassAPI {
    private static final String BASE_URL = "http://example.com/api/anotherEndpoint";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
    * 인증키
    */
    public AnotherServiceClassAPI apiKey(String apiKey) {
        if(queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("apiKey=").append(apiKey);
        return this;
    }

    public AnotherServiceClassResponse fetch() throws Exception {
        // API 호출
        URL url = new URL(BASE_URL + queryParams.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");

        // 응답 읽기
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        conn.disconnect();


        // JSON 파싱
        try {
            return objectMapper.readValue(content.toString(), AnotherServiceClassResponse.class);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to parse JSON response", e);
        }
    }
}