package GetCorpBasicInfoService;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetCorpOutline_V2Api {
    private static final String BASE_URL = "https://apis.data.go.kr/1160100/service/GetCorpBasicInfoService_V2/getCorpOutline_V2";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
    * 공공데이터포털에서 받은 인증키
    */
    public GetCorpOutline_V2Api ServiceKey(String ServiceKey) {
        if(queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("ServiceKey=").append(ServiceKey);
        return this;
    }

    /**
    * 페이지번호
    */
    public GetCorpOutline_V2Api pageNo(String pageNo) {
        if(queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("pageNo=").append(pageNo);
        return this;
    }

    /**
    * 한 페이지 결과 수
    */
    public GetCorpOutline_V2Api numOfRows(String numOfRows) {
        if(queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("numOfRows=").append(numOfRows);
        return this;
    }

    /**
    * 결과형식(xml/json)
    */
    public GetCorpOutline_V2Api resultType(String resultType) {
        if(queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("resultType=").append(resultType);
        return this;
    }

    /**
    * 법인등록번호
    */
    public GetCorpOutline_V2Api crno(String crno) {
        if(queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("crno=").append(crno);
        return this;
    }

    /**
    * 법인(法人)의 명칭
    */
    public GetCorpOutline_V2Api corpNm(String corpNm) {
        if(queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("corpNm=").append(corpNm);
        return this;
    }

public GetCorpOutline_V2ApiResponse fetch() throws Exception {
    // API 호출
    URL url = new URL(BASE_URL + queryParams.toString());
    System.out.println("url:" + url);
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

System.out.println(content);

in.close();
conn.disconnect();


// JSON 파싱
try {
    return objectMapper.readValue(content.toString(), GetCorpOutline_V2ApiResponse.class);
    } catch (Exception e) {
    e.printStackTrace();
    throw new RuntimeException("Failed to parse JSON response", e);
    }
}
}