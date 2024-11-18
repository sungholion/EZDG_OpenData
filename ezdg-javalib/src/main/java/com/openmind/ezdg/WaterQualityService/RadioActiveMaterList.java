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

public class RadioActiveMaterList {
    private static final String BASE_URL = "http://apis.data.go.kr/1480523/WaterQualityService/getRadioActiveMaterList";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
    };

    public RadioActiveMaterList (String serviceKey) {
        queryParams.append("?ServiceKey=").append(encode(serviceKey));
    }

    /**
    * 페이지 번호 (기본 값 : 1)
    */
    public RadioActiveMaterList pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(encode(pageNo));
        return this;
    }

    /**
    * 한 페이지 결과 수 (기본 값 : 10)
    */
    public RadioActiveMaterList numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(encode(numOfRows));
        return this;
    }

    /**
    * 결과형식(XML/JSON)
    */
    public RadioActiveMaterList resultType(String resultType) {
        queryParams.append("&resultType=").append(encode(resultType));
        return this;
    }

    /**
    * 측정소 다건 검색시 콤마(,) 로 구분 (예시 : ptNoList=1003A05,1003A74 ) 물환경_코드_코드명 엑셀 파일 참조
    */
    public RadioActiveMaterList ptNoList(String ptNoList) {
        queryParams.append("&ptNoList=").append(encode(ptNoList));
        return this;
    }

    /**
    * 검색조건 시작연도
    */
    public RadioActiveMaterList from_wmyr(String from_wmyr) {
        queryParams.append("&from_wmyr=").append(encode(from_wmyr));
        return this;
    }

    /**
    * 검색조건 종료연도
    */
    public RadioActiveMaterList to_wmyr(String to_wmyr) {
        queryParams.append("&to_wmyr=").append(encode(to_wmyr));
        return this;
    }

    /**
    * 검색조건 시작회차
    */
    public RadioActiveMaterList from_wmwk(String from_wmwk) {
        queryParams.append("&from_wmwk=").append(encode(from_wmwk));
        return this;
    }

    /**
    * 검색조건 종료회차
    */
    public RadioActiveMaterList to_wmwk(String to_wmwk) {
        queryParams.append("&to_wmwk=").append(encode(to_wmwk));
        return this;
    }

    /**
    * 측정년도 다건 검색시 콤마(,)로 구분 (예시 : wmyrList=2014,2015)
    */
    public RadioActiveMaterList wmyrList(String wmyrList) {
        queryParams.append("&wmyrList=").append(encode(wmyrList));
        return this;
    }

    /**
    * 측정회차 다건 검색시 콤마(,)로 구분 (예시 : wmwkList=1,2)
    */
    public RadioActiveMaterList wmwkList(String wmwkList) {
        queryParams.append("&wmwkList=").append(encode(wmwkList));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public RadioActiveMaterListResponse fetch() {
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

            return objectMapper.readValue(content.toString(), RadioActiveMaterListResponse.class);
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
