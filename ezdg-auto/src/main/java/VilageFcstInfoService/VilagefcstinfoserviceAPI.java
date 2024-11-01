package VilageFcstInfoService;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class VilagefcstinfoserviceAPI {

private static final String BASE_URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst";
private StringBuilder queryParams = new StringBuilder();

    /**
    * 공공데이터포털에서 받은 인증키
    */
    public VilagefcstinfoserviceAPI ServiceKey(String ServiceKey) {
    if(queryParams.length() == 0) queryParams.append("?");
    else queryParams.append("&");
    queryParams.append("ServiceKey=").append(ServiceKey);
    return this;
    }
    /**
    * 페이지번호
    */
    public VilagefcstinfoserviceAPI pageNo(Integer pageNo) {
    if(queryParams.length() == 0) queryParams.append("?");
    else queryParams.append("&");
    queryParams.append("pageNo=").append(pageNo);
    return this;
    }
    /**
    * 한 페이지 결과 수
    */
    public VilagefcstinfoserviceAPI numOfRows(Integer numOfRows) {
    if(queryParams.length() == 0) queryParams.append("?");
    else queryParams.append("&");
    queryParams.append("numOfRows=").append(numOfRows);
    return this;
    }
    /**
    * 요청자료형식(XML/JSON) Default: XML
    */
    public VilagefcstinfoserviceAPI dataType(String dataType) {
    if(queryParams.length() == 0) queryParams.append("?");
    else queryParams.append("&");
    queryParams.append("dataType=").append(dataType);
    return this;
    }
    /**
    * ‘21년 6월 28일 발표
    */
    public VilagefcstinfoserviceAPI base_date(Integer base_date) {
    if(queryParams.length() == 0) queryParams.append("?");
    else queryParams.append("&");
    queryParams.append("base_date=").append(base_date);
    return this;
    }
    /**
    * 06시 발표(정시단위)
    */
    public VilagefcstinfoserviceAPI base_time(String base_time) {
    if(queryParams.length() == 0) queryParams.append("?");
    else queryParams.append("&");
    queryParams.append("base_time=").append(base_time);
    return this;
    }
    /**
    * 예보지점의 X 좌표값
    */
    public VilagefcstinfoserviceAPI nx(Integer nx) {
    if(queryParams.length() == 0) queryParams.append("?");
    else queryParams.append("&");
    queryParams.append("nx=").append(nx);
    return this;
    }
    /**
    * 예보지점의 Y 좌표값
    */
    public VilagefcstinfoserviceAPI ny(Integer ny) {
    if(queryParams.length() == 0) queryParams.append("?");
    else queryParams.append("&");
    queryParams.append("ny=").append(ny);
    return this;
    }

    public VilagefcstinfoserviceResponse fetch() throws Exception {
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
        System.out.println("Response: " + content.toString());

        // JSON 파싱
        ObjectMapper mapper = new ObjectMapper();
        VilagefcstinfoserviceResponse response;
        try {
            response = mapper.readValue(content.toString(), VilagefcstinfoserviceResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to parse JSON response", e);
        }
        return response;
    }
}
