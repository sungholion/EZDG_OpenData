package com.openmind.ezdg.StdPatInfoService;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class IndustryPolicyConnectInfo {
    private static final String BASE_URL = "http://apis.data.go.kr/1430000/StdPatInfoService/getIndustryPolicyConnectInfo";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
    };

    /**
    * 한 페이지 결과 수
    */
    public IndustryPolicyConnectInfo numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(encode(numOfRows));
        return this;
    }

    /**
    * 페이지번호
    */
    public IndustryPolicyConnectInfo pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(encode(pageNo));
        return this;
    }

    /**
    * XML/JSON
    */
    public IndustryPolicyConnectInfo resultType(String resultType) {
        queryParams.append("&resultType=").append(encode(resultType));
        return this;
    }

    /**
    * 시작 선언일자(8자리)
    */
    public IndustryPolicyConnectInfo startdeclaredate(String startdeclaredate) {
        queryParams.append("&startdeclaredate=").append(encode(startdeclaredate));
        return this;
    }

    /**
    * 종료 선언일자(8자리)
    */
    public IndustryPolicyConnectInfo enddeclaredate(String enddeclaredate) {
        queryParams.append("&enddeclaredate=").append(encode(enddeclaredate));
        return this;
    }

    /**
    * Kipris 제품분류
    */
    public IndustryPolicyConnectInfo productclass(String productclass) {
        queryParams.append("&productclass=").append(encode(productclass));
        return this;
    }

    /**
    * Kipris 제품명칭
    */
    public IndustryPolicyConnectInfo producttitle(String producttitle) {
        queryParams.append("&producttitle=").append(encode(producttitle));
        return this;
    }

    /**
    * Kipris KSIC산업분류
    */
    public IndustryPolicyConnectInfo industryclass(String industryclass) {
        queryParams.append("&industryclass=").append(encode(industryclass));
        return this;
    }

    /**
    * KSIC산업분류명칭
    */
    public IndustryPolicyConnectInfo industrytitle(String industrytitle) {
        queryParams.append("&industrytitle=").append(encode(industrytitle));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public IndustryPolicyConnectInfoResponse fetch() {
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

            return objectMapper.readValue(content.toString(), IndustryPolicyConnectInfoResponse.class);
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
