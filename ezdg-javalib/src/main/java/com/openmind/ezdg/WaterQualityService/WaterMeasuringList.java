package com.openmind.ezdg.WaterQualityService;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class WaterMeasuringList {
    private static final String BASE_URL = "http://apis.data.go.kr/1480523/WaterQualityService/getWaterMeasuringList";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
    };

    public WaterMeasuringList (String serviceKey) {
        queryParams.append("?ServiceKey=").append(encode(serviceKey));
    }

    /**
    * 페이지 번호 (기본 값 : 1)
    */
    public WaterMeasuringList pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(encode(pageNo));
        return this;
    }

    /**
    * 페이지 크기 (기본 값 : 10)
    */
    public WaterMeasuringList numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(encode(numOfRows));
        return this;
    }

    /**
    * 결과형식(XML/JSON)
    */
    public WaterMeasuringList resultType(String resultType) {
        queryParams.append("&resultType=").append(encode(resultType));
        return this;
    }

    /**
    * 측정소 다건 검색시 콤마(,) 로 구분 (예시 : ptNoList=3008A40,2012F50 ) 물환경_코드_코드명 엑셀 파일 참조
    */
    public WaterMeasuringList ptNoList(String ptNoList) {
        queryParams.append("&ptNoList=").append(encode(ptNoList));
        return this;
    }

    /**
    * 측정년도 다건 검색시 콤마(,)로 구분 (예시 : wmyrList=2012,2013)
    */
    public WaterMeasuringList wmyrList(String wmyrList) {
        queryParams.append("&wmyrList=").append(encode(wmyrList));
        return this;
    }

    /**
    * 측정월 다건 검색시 콤마(,)로 구분 (예시 : wmodList=01,02,03) (1~9월까지는 ‘01’~’09’로 표시).
    */
    public WaterMeasuringList wmodList(String wmodList) {
        queryParams.append("&wmodList=").append(encode(wmodList));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public WaterMeasuringListResponse fetch() {
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
            System.out.println("Generated URL: " + url);
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

            return objectMapper.readValue(content.toString(), WaterMeasuringListResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("API 요청 또는 JSON 파싱 실패", e);
        }
    }


    private String encode(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (Exception e) {
            throw new RuntimeException("Encoding error", e);
        }
    }
}
