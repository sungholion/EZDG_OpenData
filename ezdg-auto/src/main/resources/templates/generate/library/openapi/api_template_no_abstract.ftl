package ${packageName};

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ${className}API {

private static final String BASE_URL = "${baseUrl}${endpoint}";
private StringBuilder queryParams = new StringBuilder();

<#list requestFields as field>
    /**
    * ${field.description}
    */
    public ${className}API ${field.name}(${field.type} ${field.name}) {
    if(queryParams.length() == 0) queryParams.append("?");
    else queryParams.append("&");
    queryParams.append("${field.name}=").append(${field.name});
    return this;
    }
</#list>

public List<${className}Response> fetch() throws Exception {
    URL url = new URL(BASE_URL + queryParams.toString());
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.setRequestProperty("Content-Type", "application/json");

    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    String inputLine;
    StringBuilder content = new StringBuilder();
    while ((inputLine = in.readLine()) != null) {
    content.append(inputLine);
    }

    in.close();
    conn.disconnect();

<#--    // 예시로 응답을 간단히 출력하고 목록에 추가 (실제 사용 시 JSON 파싱하여 객체화)-->
    List<${className}Response> responseList = new ArrayList<>();
        System.out.println("Response: " + content.toString());

<#--        // TODO: 실제 JSON 응답을 ${className}Response 객체로 변환하는 로직 추가 필요-->
        return responseList;
        }
        }
