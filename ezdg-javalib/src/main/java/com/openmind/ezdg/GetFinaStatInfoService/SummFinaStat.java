package com.openmind.ezdg.GetFinaStatInfoService;

import com.openmind.ezdg.common.Encoder;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class SummFinaStat {
    private static final String BASE_URL = "https://apis.data.go.kr/1160100/service/GetFinaStatInfoService_V2/getSummFinaStat_V2";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
        "numOfRows",
        "pageNo",
        "resultType",
        "serviceKey",
    };

    /**
    * 한 페이지 결과 수
    */
    public SummFinaStat numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(Encoder.encode(numOfRows));
        return this;
    }

    /**
    * 페이지 번호
    */
    public SummFinaStat pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(Encoder.encode(pageNo));
        return this;
    }

    /**
    * 결과형식(xml/json)
    */
    public SummFinaStat resultType(String resultType) {
        queryParams.append("&resultType=").append(Encoder.encode(resultType));
        return this;
    }

    public SummFinaStat (String serviceKey) {
        queryParams.append("?serviceKey=").append(Encoder.encode(serviceKey));
    }

    /**
    * 법인등록번호
    */
    public SummFinaStat crno(String crno) {
        queryParams.append("&crno=").append(Encoder.encode(crno));
        return this;
    }

    /**
    * 법인에 대해 법령이 규정한 1회계기간으로서 법인세의 과세기간
    */
    public SummFinaStat bizYear(String bizYear) {
        queryParams.append("&bizYear=").append(Encoder.encode(bizYear));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public SummFinaStatResponse fetch() {
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

            return objectMapper.readValue(content.toString(), SummFinaStatResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("API 요청 또는 JSON 파싱 실패", e);
        }
    }
}
