package com.openmind.ezdg.VilageFcstInfoService;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class VilageFcst {
    private static final String BASE_URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
    * 공공데이터포털에서 받은 인증키
    */
    public VilageFcst ServiceKey(String ServiceKey) {
        if (queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("ServiceKey=").append(ServiceKey);
        return this;
    }

    /**
    * 페이지번호
    */
    public VilageFcst pageNo(String pageNo) {
        if (queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("pageNo=").append(pageNo);
        return this;
    }

    /**
    * 한 페이지 결과 수
    */
    public VilageFcst numOfRows(String numOfRows) {
        if (queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("numOfRows=").append(numOfRows);
        return this;
    }

    /**
    * 요청자료형식(XML/JSON) Default: XML
    */
    public VilageFcst dataType(String dataType) {
        if (queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("dataType=").append(dataType);
        return this;
    }

    /**
    * ‘21년 6월 28일발표
    */
    public VilageFcst base_date(String base_date) {
        if (queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("base_date=").append(base_date);
        return this;
    }

    /**
    * 05시 발표
    */
    public VilageFcst base_time(String base_time) {
        if (queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("base_time=").append(base_time);
        return this;
    }

    /**
    * 예보지점의 X 좌표값
    */
    public VilageFcst nx(String nx) {
        if (queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("nx=").append(nx);
        return this;
    }

    /**
    * 예보지점의 Y 좌표값
    */
    public VilageFcst ny(String ny) {
        if (queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("ny=").append(ny);
        return this;
    }


    /**
    * API 호출 및 응답 파싱
    */
    public VilageFcstResponse fetch() {
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

            return objectMapper.readValue(content.toString(), VilageFcstResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("API 요청 또는 JSON 파싱 실패", e);
        }
    }
}
