package com.openmind.ezdg.BeachInfoservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class SunInfoBeach {
    private static final String BASE_URL = "https://apis.data.go.kr/1360000/BeachInfoservice/getSunInfoBeach";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
        "serviceKey",
        "Base_date",
        "beach_num",
    };

    public SunInfoBeach (String serviceKey) {
        queryParams.append("?serviceKey=").append(encode(serviceKey));
    }

    /**
    * 페이지번호한 페이지 결과 수
    */
    public SunInfoBeach numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(encode(numOfRows));
        return this;
    }

    /**
    * 한 페이지 결과 수
    */
    public SunInfoBeach pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(encode(pageNo));
        return this;
    }

    /**
    * 응답자료형식
    */
    public SunInfoBeach dataType(String dataType) {
        queryParams.append("&dataType=").append(encode(dataType));
        return this;
    }

    /**
    * 발표일자
    */
    public SunInfoBeach Base_date(String Base_date) {
        queryParams.append("&Base_date=").append(encode(Base_date));
        return this;
    }

    /**
    * 해변코드
    */
    public SunInfoBeach beach_num(String beach_num) {
        queryParams.append("&beach_num=").append(encode(beach_num));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public SunInfoBeachResponse fetch() {
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

            return objectMapper.readValue(content.toString(), SunInfoBeachResponse.class);
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
