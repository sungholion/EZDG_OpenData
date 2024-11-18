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

public class detailCommon1 {
    private static final String BASE_URL = "https://apis.data.go.kr/B551011/KorService1/detailCommon1";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
        "MobileOS",
        "MobileApp",
        "contentId",
        "serviceKey",
    };

    /**
    * OS 구분 : IOS (아이폰), AND (안드로이드), WIN (윈도우폰), ETC(기타)
    */
    public detailCommon1 MobileOS(String MobileOS) {
        queryParams.append("&MobileOS=").append(encode(MobileOS));
        return this;
    }

    /**
    * 서비스명(어플명)
    */
    public detailCommon1 MobileApp(String MobileApp) {
        queryParams.append("&MobileApp=").append(encode(MobileApp));
        return this;
    }

    /**
    * 응답메세지 형식 : REST방식의 URL호출 시 json값 추가(디폴트 응답메세지 형식은XML)
    */
    public detailCommon1 _type(String _type) {
        queryParams.append("&_type=").append(encode(_type));
        return this;
    }

    /**
    * 콘텐츠ID
    */
    public detailCommon1 contentId(String contentId) {
        queryParams.append("&contentId=").append(encode(contentId));
        return this;
    }

    /**
    * 관광타입(12:관광지, 14:문화시설, 15:축제공연행사, 25:여행코스, 28:레포츠, 32:숙박, 38:쇼핑, 39:음식점) ID
    */
    public detailCommon1 contentTypeId(String contentTypeId) {
        queryParams.append("&contentTypeId=").append(encode(contentTypeId));
        return this;
    }

    /**
    * 기본정보조회여부( Y,N )
    */
    public detailCommon1 defaultYN(String defaultYN) {
        queryParams.append("&defaultYN=").append(encode(defaultYN));
        return this;
    }

    /**
    * 원본, 썸네일대표 이미지, 이미지 공공누리유형정보 조회여부( Y,N )
    */
    public detailCommon1 firstImageYN(String firstImageYN) {
        queryParams.append("&firstImageYN=").append(encode(firstImageYN));
        return this;
    }

    /**
    * 지역코드, 시군구코드조회여부( Y,N )
    */
    public detailCommon1 areacodeYN(String areacodeYN) {
        queryParams.append("&areacodeYN=").append(encode(areacodeYN));
        return this;
    }

    /**
    * 대,중,소분류코드조회여부( Y,N )
    */
    public detailCommon1 catcodeYN(String catcodeYN) {
        queryParams.append("&catcodeYN=").append(encode(catcodeYN));
        return this;
    }

    /**
    * 주소, 상세주소조회여부( Y,N )
    */
    public detailCommon1 addrinfoYN(String addrinfoYN) {
        queryParams.append("&addrinfoYN=").append(encode(addrinfoYN));
        return this;
    }

    /**
    * 좌표X, Y 조회여부( Y,N )
    */
    public detailCommon1 mapinfoYN(String mapinfoYN) {
        queryParams.append("&mapinfoYN=").append(encode(mapinfoYN));
        return this;
    }

    /**
    * 콘텐츠개요조회여부( Y,N )
    */
    public detailCommon1 overviewYN(String overviewYN) {
        queryParams.append("&overviewYN=").append(encode(overviewYN));
        return this;
    }

    /**
    * 한페이지결과수
    */
    public detailCommon1 numOfRows(Number numOfRows) {
        queryParams.append("&numOfRows=").append(encode(numOfRows));
        return this;
    }

    /**
    * 페이지번호
    */
    public detailCommon1 pageNo(Number pageNo) {
        queryParams.append("&pageNo=").append(encode(pageNo));
        return this;
    }

    public detailCommon1 (String serviceKey) {
        queryParams.append("?serviceKey=").append(encode(serviceKey));
    }

    /**
    * API 호출 및 응답 파싱
    */
    public detailCommon1Response fetch() {
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

            return objectMapper.readValue(content.toString(), detailCommon1Response.class);
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
