package VilageFcstInfoService;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Vilagefcstinfoservice12API {
private static final String BASE_URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst";
private StringBuilder queryParams = new StringBuilder();
private final ObjectMapper objectMapper = new ObjectMapper();

    /**
    * 공공데이터포털에서 받은 인증키
    */
    public Vilagefcstinfoservice12API serviceKey(String serviceKey) {
    if(queryParams.length() == 0) queryParams.append("?");
    else queryParams.append("&");
    queryParams.append("serviceKey=").append(serviceKey);
    return this;
    }

    /**
    * 페이지번호
    */
    public Vilagefcstinfoservice12API pageNo(Integer pageNo) {
    if(queryParams.length() == 0) queryParams.append("?");
    else queryParams.append("&");
    queryParams.append("pageNo=").append(pageNo);
    return this;
    }

    /**
    * 한 페이지 결과 수
    */
    public Vilagefcstinfoservice12API numOfRows(Integer numOfRows) {
    if(queryParams.length() == 0) queryParams.append("?");
    else queryParams.append("&");
    queryParams.append("numOfRows=").append(numOfRows);
    return this;
    }

    /**
    * 요청자료형식(XML/JSON) Default: XML
    */
    public Vilagefcstinfoservice12API dataType(String dataType) {
    if(queryParams.length() == 0) queryParams.append("?");
    else queryParams.append("&");
    queryParams.append("dataType=").append(dataType);
    return this;
    }

    /**
    * ‘21년 6월 28일 발표
    */
    public Vilagefcstinfoservice12API base_date(Integer base_date) {
    if(queryParams.length() == 0) queryParams.append("?");
    else queryParams.append("&");
    queryParams.append("base_date=").append(base_date);
    return this;
    }

    /**
    * 06시 발표(정시단위)
    */
    public Vilagefcstinfoservice12API base_time(Integer base_time) {
    if(queryParams.length() == 0) queryParams.append("?");
    else queryParams.append("&");
    queryParams.append("base_time=").append(base_time);
    return this;
    }

    /**
    * 예보지점의 X 좌표값
    */
    public Vilagefcstinfoservice12API nx(Integer nx) {
    if(queryParams.length() == 0) queryParams.append("?");
    else queryParams.append("&");
    queryParams.append("nx=").append(nx);
    return this;
    }

    /**
    * 예보지점의 Y 좌표값
    */
    public Vilagefcstinfoservice12API ny(Integer ny) {
    if(queryParams.length() == 0) queryParams.append("?");
    else queryParams.append("&");
    queryParams.append("ny=").append(ny);
    return this;
    }

public Vilagefcstinfoservice12Response fetch() throws Exception {
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
return objectMapper.readValue(content.toString(), Vilagefcstinfoservice12Response.class);
} catch (Exception e) {
e.printStackTrace();
throw new RuntimeException("Failed to parse JSON response", e);
}
}
}