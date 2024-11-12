package ${packageName};

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ${className} {
    private static final String BASE_URL = "${baseUrl}${endpoint}";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();

<#list requestFields as field>
    /**
    * ${field.description}
    */
    public ${className} ${field.name}(${field.type} ${field.name}) {
        if (queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("${field.name}=").append(${field.name});
        return this;
    }

</#list>

    /**
    * API 호출 및 응답 파싱
    */
    public ${className}Response fetch() {
        try {
            URL url = new URL(BASE_URL + queryParams.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder content = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
            }
            in.close();
            conn.disconnect();

            return objectMapper.readValue(content.toString(), ${className}Response.class);
            } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("API 요청 또는 JSON 파싱 실패", e);
            }
        }
}
