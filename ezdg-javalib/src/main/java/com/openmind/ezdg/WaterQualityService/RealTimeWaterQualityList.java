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

public class RealTimeWaterQualityList {
    private static final String BASE_URL = "http://apis.data.go.kr/1480523/WaterQualityService/getRealTimeWaterQualityList";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
        "pageNo",
        "numOfRows",
    };

    public RealTimeWaterQualityList (String serviceKey) {
        queryParams.append("?ServiceKey=").append(encode(serviceKey));
    }

    /**
    * 페이지번호 (기본 값 : 1)
    */
    public RealTimeWaterQualityList pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(encode(pageNo));
        return this;
    }

    /**
    * 한 페이지 결과 수 (기본 값 : 10)
    */
    public RealTimeWaterQualityList numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(encode(numOfRows));
        return this;
    }

    /**
    * 결과형식 ( XML/JSON )
    */
    public RealTimeWaterQualityList resultType(String resultType) {
        queryParams.append("&resultType=").append(encode(resultType));
        return this;
    }

    /**
    * 측정소 다건 조회 가능. 측정소 코드는 실시간수질_코드-코드명 엑셀파일 참조
    */
    public RealTimeWaterQualityList siteId(String siteId) {
        queryParams.append("&siteId=").append(encode(siteId));
        return this;
    }

    /**
    * yyyyMMddHHmmss 형식으로 14자리가 들어가며 시는 24시형태로 표시 (startDate와 endDate는 같이 쓰여야 함)
    */
    public RealTimeWaterQualityList startDate(String startDate) {
        queryParams.append("&startDate=").append(encode(startDate));
        return this;
    }

    /**
    * yyyyMMddHHmmss 형식으로 14자리가 들어가며 시는 24시형태로 표시 (startDate와 endDate는 같이 쓰여야 함)
    */
    public RealTimeWaterQualityList endDate(String endDate) {
        queryParams.append("&endDate=").append(encode(endDate));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public RealTimeWaterQualityListResponse fetch() {
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

            return objectMapper.readValue(content.toString(), RealTimeWaterQualityListResponse.class);
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
