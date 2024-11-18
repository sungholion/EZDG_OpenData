package com.openmind.ezdg.ArpltnInforInqireSvc;

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

public class MinuDustWeekFrcstDspth {
    private static final String BASE_URL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustWeekFrcstDspth";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
    };

    public MinuDustWeekFrcstDspth (String serviceKey) {
        queryParams.append("?serviceKey=").append(Encoder.encode(serviceKey));
    }

    /**
    * xml 또는 json
    */
    public MinuDustWeekFrcstDspth returnType(String returnType) {
        queryParams.append("&returnType=").append(Encoder.encode(returnType));
        return this;
    }

    /**
    * 한 페이지 결과 수
    */
    public MinuDustWeekFrcstDspth numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(Encoder.encode(numOfRows));
        return this;
    }

    /**
    * 페이지번호
    */
    public MinuDustWeekFrcstDspth pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(Encoder.encode(pageNo));
        return this;
    }

    /**
    * 통보시간 검색(조회 날짜 입력이 없을 경우 호출 당일 날짜를 기준으로 주간예보 리스트 확인)
    */
    public MinuDustWeekFrcstDspth searchDate(String searchDate) {
        queryParams.append("&searchDate=").append(Encoder.encode(searchDate));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public MinuDustWeekFrcstDspthResponse fetch() {
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

            return objectMapper.readValue(content.toString(), MinuDustWeekFrcstDspthResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("API 요청 또는 JSON 파싱 실패", e);
        }
    }
}
