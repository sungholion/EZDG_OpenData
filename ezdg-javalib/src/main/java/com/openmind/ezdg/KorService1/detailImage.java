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

public class detailImage {
    private static final String BASE_URL = "https://apis.data.go.kr/B551011/KorService1/detailImage1";
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
    public detailImage MobileOS(String MobileOS) {
        queryParams.append("&MobileOS=").append(encode(MobileOS));
        return this;
    }

    /**
    * 서비스명(어플명)
    */
    public detailImage MobileApp(String MobileApp) {
        queryParams.append("&MobileApp=").append(encode(MobileApp));
        return this;
    }

    /**
    * 응답메세지 형식 : REST방식의 URL호출 시 json값 추가(디폴트 응답메세지 형식은XML)
    */
    public detailImage _type(String _type) {
        queryParams.append("&_type=").append(encode(_type));
        return this;
    }

    /**
    * 콘텐츠ID
    */
    public detailImage contentId(String contentId) {
        queryParams.append("&contentId=").append(encode(contentId));
        return this;
    }

    /**
    * 이미지조회1 : Y=콘텐츠이미지조회 N=”음식점”타입의음식메뉴이미지
    */
    public detailImage imageYN(String imageYN) {
        queryParams.append("&imageYN=").append(encode(imageYN));
        return this;
    }

    /**
    * 이미지조회2 : Y=원본,썸네일이미지조회,공공누리 저작권유형정보조회 N=Null
    */
    public detailImage subImageYN(String subImageYN) {
        queryParams.append("&subImageYN=").append(encode(subImageYN));
        return this;
    }

    /**
    * 한페이지결과수
    */
    public detailImage numOfRows(Number numOfRows) {
        queryParams.append("&numOfRows=").append(encode(numOfRows));
        return this;
    }

    /**
    * 페이지번호
    */
    public detailImage pageNo(Number pageNo) {
        queryParams.append("&pageNo=").append(encode(pageNo));
        return this;
    }

    public detailImage (String serviceKey) {
        queryParams.append("?serviceKey=").append(encode(serviceKey));
    }

    /**
    * API 호출 및 응답 파싱
    */
    public detailImageResponse fetch() {
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

            return objectMapper.readValue(content.toString(), detailImageResponse.class);
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
