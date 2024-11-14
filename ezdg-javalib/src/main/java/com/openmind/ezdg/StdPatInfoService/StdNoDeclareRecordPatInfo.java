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

public class StdNoDeclareRecordPatInfo {
    private static final String BASE_URL = "http://apis.data.go.kr/1430000/StdPatInfoService/getStdNoDeclareRecordPatInfo";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
    };

    /**
    * 한 페이지 결과 수(기본 값 : 10, 최대 값 : 1000)
    */
    public StdNoDeclareRecordPatInfo numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(encode(numOfRows));
        return this;
    }

    /**
    * 페이지 번호 ( 기본 값 : 1 )
    */
    public StdNoDeclareRecordPatInfo pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(encode(pageNo));
        return this;
    }

    /**
    * 결과형식 ( XML/JSON, 기본 값 : xml )
    */
    public StdNoDeclareRecordPatInfo resultType(String resultType) {
        queryParams.append("&resultType=").append(encode(resultType));
        return this;
    }

    /**
    * 표준기구코드
    */
    public StdNoDeclareRecordPatInfo stdorgancd(String stdorgancd) {
        queryParams.append("&stdorgancd=").append(encode(stdorgancd));
        return this;
    }

    /**
    * 선언자국가_정비
    */
    public StdNoDeclareRecordPatInfo declarercountry_adjust(String declarercountry_adjust) {
        queryParams.append("&declarercountry_adjust=").append(encode(declarercountry_adjust));
        return this;
    }

    /**
    * 표준번호
    */
    public StdNoDeclareRecordPatInfo stdno(String stdno) {
        queryParams.append("&stdno=").append(encode(stdno));
        return this;
    }

    /**
    * 검색시작_선언일자
    */
    public StdNoDeclareRecordPatInfo startdeclaredate(String startdeclaredate) {
        queryParams.append("&startdeclaredate=").append(encode(startdeclaredate));
        return this;
    }

    /**
    * 검색종료_선언일자
    */
    public StdNoDeclareRecordPatInfo enddeclaredate(String enddeclaredate) {
        queryParams.append("&enddeclaredate=").append(encode(enddeclaredate));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public StdNoDeclareRecordPatInfoResponse fetch() {
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

            return objectMapper.readValue(content.toString(), StdNoDeclareRecordPatInfoResponse.class);
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
