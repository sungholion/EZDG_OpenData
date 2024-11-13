package GetFinaStatInfoService;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetBs_V2Api {
    private static final String BASE_URL = "https://apis.data.go.kr/1160100/service/GetFinaStatInfoService_V2/getBs_V2";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
    * 한 페이지 결과 수
    */
    public GetBs_V2Api numOfRows(String numOfRows) {
        if(queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("numOfRows=").append(numOfRows);
        return this;
    }

    /**
    * 페이지 번호
    */
    public GetBs_V2Api pageNo(String pageNo) {
        if(queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("pageNo=").append(pageNo);
        return this;
    }

    /**
    * 결과형식(xml/json)
    */
    public GetBs_V2Api resultType(String resultType) {
        if(queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("resultType=").append(resultType);
        return this;
    }

    /**
    * 공공데이터포털에서 받은 인증키
    */
    public GetBs_V2Api serviceKey(String serviceKey) {
        if(queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("serviceKey=").append(serviceKey);
        return this;
    }

    /**
    * 법인등록번호
    */
    public GetBs_V2Api crno(String crno) {
        if(queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("crno=").append(crno);
        return this;
    }

    /**
    * 법인에 대해 법령이 규정한 1회계기간으로서 법인세의 과세기간
    */
    public GetBs_V2Api bizYear(String bizYear) {
        if(queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("bizYear=").append(bizYear);
        return this;
    }

public GetBs_V2ApiResponse fetch() throws Exception {
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
    return objectMapper.readValue(content.toString(), GetBs_V2ApiResponse.class);
    } catch (Exception e) {
    e.printStackTrace();
    throw new RuntimeException("Failed to parse JSON response", e);
    }
}
}