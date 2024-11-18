package com.openmind.ezdg.ArpltnStatsSvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class CtprvnMesureLIst {
    private static final String BASE_URL = "http://apis.data.go.kr/B552584/ArpltnStatsSvc/getCtprvnMesureLIst";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
    };

    public CtprvnMesureLIst (String serviceKey) {
        queryParams.append("?serviceKey=").append(encode(serviceKey));
    }

    /**
    * xml 또는 json
    */
    public CtprvnMesureLIst returnType(String returnType) {
        queryParams.append("&returnType=").append(encode(returnType));
        return this;
    }

    /**
    * 한 페이지 결과 수
    */
    public CtprvnMesureLIst numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(encode(numOfRows));
        return this;
    }

    /**
    * 페이지번호
    */
    public CtprvnMesureLIst pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(encode(pageNo));
        return this;
    }

    /**
    * 측정항목 구분(SO2, CO, O3, NO2, PM10, PM2.5)
    */
    public CtprvnMesureLIst itemCode(String itemCode) {
        queryParams.append("&itemCode=").append(encode(itemCode));
        return this;
    }

    /**
    * 요청 자료 구분(시간평균: HOUR, 일평균: DAILY)
    */
    public CtprvnMesureLIst dataGubun(String dataGubun) {
        queryParams.append("&dataGubun=").append(encode(dataGubun));
        return this;
    }

    /**
    * 요청 데이터 기간(일주일: WEEK, 한달: MONTH)
    */
    public CtprvnMesureLIst searchCondition(String searchCondition) {
        queryParams.append("&searchCondition=").append(encode(searchCondition));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public CtprvnMesureLIstResponse fetch() {
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

            return objectMapper.readValue(content.toString(), CtprvnMesureLIstResponse.class);
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
