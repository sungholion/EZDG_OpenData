package ${packageName};

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class ${className} {
    private static final String BASE_URL = "${baseUrl}${endpoint}";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
<#list requestFields as field>
    <#if (field.name != "serviceKey" && field.name != "ServiceKey") && field.required == "필수" || field.required == "true">
        "${field.name}",
    </#if>
</#list>
    };

<#list requestFields as field>
    <#if field.name == "serviceKey" || field.name == "ServiceKey">
    public ${className} (String serviceKey) {
        queryParams.append("${field.name}=").append(serviceKey);
    }
    <#else>
    /**
    * ${field.description}
    */
    public ${className} ${field.name}(${field.type} ${field.name}) {
        queryParams.append("&${field.name}=").append(${field.name});
        return this;
    }
    </#if>

</#list>
    /**
    * API 호출 및 응답 파싱
    */
    public ${className}Response fetch() {
        String queryParamStr = queryParams.toString();
        List<String> exceptedParams = new ArrayList<>();
        for (String requiredParam : requiredParams) {
            if(!queryParamStr.contains(requiredParam)) {
            exceptedParams.add(requiredParam);
            }
        }
        if(exceptedParams.size() > 0) {
            throw new RuntimeException(exceptedParams.toString() + " 파라미터는 필수입니다.");
        }
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
