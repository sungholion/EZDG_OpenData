package com.openmind.ezdg.GetFinaStatInfoService;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class IncoStat {
    private static final String BASE_URL = "https://apis.data.go.kr/1160100/service/GetFinaStatInfoService_V2/getIncoStat_V2";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
        "serviceKey",
        "numOfRows",
        "pageNo",
        "resultType",
        "bizYear",
    };

    public IncoStat (String serviceKey) {
        queryParams.append("?serviceKey=").append(encode(serviceKey));
    }

    /**
    * 한 페이지 결과 수
    */
    public IncoStat numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(encode(numOfRows));
        return this;
    }

    /**
    * 페이지번호
    */
    public IncoStat pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(encode(pageNo));
        return this;
    }

    /**
    * 결과형식(xml/json)
    */
    public IncoStat resultType(String resultType) {
        queryParams.append("&resultType=").append(encode(resultType));
        return this;
    }

    /**
    * 법인등록번호
    */
    public IncoStat crno(String crno) {
        queryParams.append("&crno=").append(encode(crno));
        return this;
    }

    /**
    * 법인에 대해 법령이 규정한 1회계기간으로서 법인세의 과세기간
    */
    public IncoStat bizYear(String bizYear) {
        queryParams.append("&bizYear=").append(encode(bizYear));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public IncoStatResponse fetch() {
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

            return objectMapper.readValue(content.toString(), IncoStatResponse.class);
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
