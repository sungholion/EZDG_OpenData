package com.openmind.ezdg.RoadWthrInfoService;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class CctvStnRoadWthr {
    private static final String BASE_URL = "http://apis.data.go.kr/1360000/RoadWthrInfoService/getCctvStnRoadWthr";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
        "pageNo",
        "numOfRows",
        "eqmtId",
    };

    public CctvStnRoadWthr (String serviceKey) {
        queryParams.append("?ServiceKey=").append(encode(serviceKey));
    }

    /**
    * 페이지번호
    */
    public CctvStnRoadWthr pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(encode(pageNo));
        return this;
    }

    /**
    * 한 페이지 결과 수
    */
    public CctvStnRoadWthr numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(encode(numOfRows));
        return this;
    }

    /**
    * 요청자료형식(XML/JSON)
    */
    public CctvStnRoadWthr dataType(String dataType) {
        queryParams.append("&dataType=").append(encode(dataType));
        return this;
    }

    /**
    * CCTV 아이디
    */
    public CctvStnRoadWthr eqmtId(String eqmtId) {
        queryParams.append("&eqmtId=").append(encode(eqmtId));
        return this;
    }

    /**
    * 최근 결과 시간
    */
    public CctvStnRoadWthr hhCode(String hhCode) {
        queryParams.append("&hhCode=").append(encode(hhCode));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public CctvStnRoadWthrResponse fetch() {
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

            return objectMapper.readValue(content.toString(), CctvStnRoadWthrResponse.class);
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
