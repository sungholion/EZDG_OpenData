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

public class SgisDrinkWaterList {
    private static final String BASE_URL = "http://apis.data.go.kr/1480523/WaterQualityService/getSgisDrinkWaterList";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
    };

    public SgisDrinkWaterList (String serviceKey) {
        queryParams.append("?ServiceKey=").append(encode(serviceKey));
    }

    /**
    * 페이지번호
    */
    public SgisDrinkWaterList pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(encode(pageNo));
        return this;
    }

    /**
    * 한 페이지 결과 수
    */
    public SgisDrinkWaterList numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(encode(numOfRows));
        return this;
    }

    /**
    * 결과형식(XML/JSON)
    */
    public SgisDrinkWaterList resultType(String resultType) {
        queryParams.append("&resultType=").append(encode(resultType));
        return this;
    }

    /**
    * 복수년도 검색시 콤마(,)로 구분 (예시 : yyyy=2012,2013)
    */
    public SgisDrinkWaterList yyyy(String yyyy) {
        queryParams.append("&yyyy=").append(encode(yyyy));
        return this;
    }

    /**
    * 시도 명칭
    */
    public SgisDrinkWaterList sido(String sido) {
        queryParams.append("&sido=").append(encode(sido));
        return this;
    }

    /**
    * 1/4 , 2/4 , 3/4 , 4/4
    */
    public SgisDrinkWaterList period(String period) {
        queryParams.append("&period=").append(encode(period));
        return this;
    }

    /**
    * 시군구 명칭
    */
    public SgisDrinkWaterList sgg(String sgg) {
        queryParams.append("&sgg=").append(encode(sgg));
        return this;
    }

    /**
    * 복수지점코드 검색시 콤마(,)로 구분(예시 : legacyCodeNo=PUB_2969,PUB_2970) 먹는물_코드-코드명 엑셀 파일 참조
    */
    public SgisDrinkWaterList legacyCodeNo(String legacyCodeNo) {
        queryParams.append("&legacyCodeNo=").append(encode(legacyCodeNo));
        return this;
    }

    /**
    * 지점명
    */
    public SgisDrinkWaterList spotNm(String spotNm) {
        queryParams.append("&spotNm=").append(encode(spotNm));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public SgisDrinkWaterListResponse fetch() {
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

            return objectMapper.readValue(content.toString(), SgisDrinkWaterListResponse.class);
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
