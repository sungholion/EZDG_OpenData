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

public class detailPetTour {
    private static final String BASE_URL = "https://apis.data.go.kr/B551011/KorService1/detailPetTour1";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
        "serviceKey",
        "MobileOS",
        "MobileApp",
    };

    public detailPetTour (String serviceKey) {
        queryParams.append("?serviceKey=").append(encode(serviceKey));
    }

    /**
    * 페이지번호
    */
    public detailPetTour pageNo(Number pageNo) {
        queryParams.append("&pageNo=").append(encode(pageNo));
        return this;
    }

    /**
    * 한 페이지 결과 수
    */
    public detailPetTour numOfRows(Number numOfRows) {
        queryParams.append("&numOfRows=").append(encode(numOfRows));
        return this;
    }

    /**
    * OS 구분(IOS (아이폰), AND (안드로이드), WIN (윈도우폰), ETC)
    */
    public detailPetTour MobileOS(String MobileOS) {
        queryParams.append("&MobileOS=").append(encode(MobileOS));
        return this;
    }

    /**
    * 서비스명
    */
    public detailPetTour MobileApp(String MobileApp) {
        queryParams.append("&MobileApp=").append(encode(MobileApp));
        return this;
    }

    /**
    * 콘텐츠ID(옵션,미기입시 전체목록조회)
    */
    public detailPetTour contentId(String contentId) {
        queryParams.append("&contentId=").append(encode(contentId));
        return this;
    }

    /**
    * 응답메세지 형식 : REST방식의 URL호출 시 json값 추가(디폴트 응답메세지 형식은XML)
    */
    public detailPetTour _type(String _type) {
        queryParams.append("&_type=").append(encode(_type));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public detailPetTourResponse fetch() {
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

            return objectMapper.readValue(content.toString(), detailPetTourResponse.class);
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
