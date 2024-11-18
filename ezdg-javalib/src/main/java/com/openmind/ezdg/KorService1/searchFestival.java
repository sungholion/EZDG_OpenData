package com.openmind.ezdg.KorService1;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class searchFestival {
    private static final String BASE_URL = "https://apis.data.go.kr/B551011/KorService1/searchFestival1";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
        "MobileOS",
        "MobileApp",
        "eventStartDate",
        "serviceKey",
    };

    /**
    * 한페이지결과수
    */
    public searchFestival numOfRows(Number numOfRows) {
        queryParams.append("&numOfRows=").append(encode(numOfRows));
        return this;
    }

    /**
    * 페이지번호
    */
    public searchFestival pageNo(Number pageNo) {
        queryParams.append("&pageNo=").append(encode(pageNo));
        return this;
    }

    /**
    * OS 구분 : IOS (아이폰), AND (안드로이드), WIN (윈도우폰), ETC(기타)
    */
    public searchFestival MobileOS(String MobileOS) {
        queryParams.append("&MobileOS=").append(encode(MobileOS));
        return this;
    }

    /**
    * 서비스명(어플명)
    */
    public searchFestival MobileApp(String MobileApp) {
        queryParams.append("&MobileApp=").append(encode(MobileApp));
        return this;
    }

    /**
    * 응답메세지 형식 : REST방식의 URL호출 시 json값 추가(디폴트 응답메세지 형식은XML)
    */
    public searchFestival _type(String _type) {
        queryParams.append("&_type=").append(encode(_type));
        return this;
    }

    /**
    * 목록구분(Y=목록, N=개수)
    */
    public searchFestival listYN(String listYN) {
        queryParams.append("&listYN=").append(encode(listYN));
        return this;
    }

    /**
    * 정렬구분 (A=제목순, C=수정일순, D=생성일순) 대표이미지가반드시있는정렬(O=제목순, Q=수정일순, R=생성일순)
    */
    public searchFestival arrange(String arrange) {
        queryParams.append("&arrange=").append(encode(arrange));
        return this;
    }

    /**
    * 행사시작일(형식 :YYYYMMDD)
    */
    public searchFestival eventStartDate(String eventStartDate) {
        queryParams.append("&eventStartDate=").append(encode(eventStartDate));
        return this;
    }

    /**
    * 행사종료일(형식 :YYYYMMDD)
    */
    public searchFestival eventEndDate(String eventEndDate) {
        queryParams.append("&eventEndDate=").append(encode(eventEndDate));
        return this;
    }

    /**
    * 지역코드(지역코드조회 참고)
    */
    public searchFestival areaCode(String areaCode) {
        queryParams.append("&areaCode=").append(encode(areaCode));
        return this;
    }

    /**
    * 시군구코드(지역코드조회 참고)
    */
    public searchFestival sigunguCode(String sigunguCode) {
        queryParams.append("&sigunguCode=").append(encode(sigunguCode));
        return this;
    }

    /**
    * 수정일(형식 :YYYYMMDD)
    */
    public searchFestival modifiedtime(String modifiedtime) {
        queryParams.append("&modifiedtime=").append(encode(modifiedtime));
        return this;
    }

    public searchFestival (String serviceKey) {
        queryParams.append("?serviceKey=").append(encode(serviceKey));
    }

    /**
    * API 호출 및 응답 파싱
    */
    public searchFestivalResponse fetch() {
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

            return objectMapper.readValue(content.toString(), searchFestivalResponse.class);
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
