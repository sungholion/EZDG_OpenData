package com.openmind.ezdg.KorService1;

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

public class areaBasedSyncList1 {
    private static final String BASE_URL = "https://apis.data.go.kr/B551011/KorService1/areaBasedSyncList1";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
        "MobileOS",
        "MobileApp",
        "serviceKey",
    };

    /**
    * 한페이지결과수
    */
    public areaBasedSyncList1 numOfRows(Number numOfRows) {
        queryParams.append("&numOfRows=").append(Encoder.encode(numOfRows));
        return this;
    }

    /**
    * 페이지번호
    */
    public areaBasedSyncList1 pageNo(Number pageNo) {
        queryParams.append("&pageNo=").append(Encoder.encode(pageNo));
        return this;
    }

    /**
    * OS 구분 : IOS (아이폰), AND (안드로이드), WIN (윈도우폰), ETC(기타)
    */
    public areaBasedSyncList1 MobileOS(String MobileOS) {
        queryParams.append("&MobileOS=").append(Encoder.encode(MobileOS));
        return this;
    }

    /**
    * 서비스명(어플명)
    */
    public areaBasedSyncList1 MobileApp(String MobileApp) {
        queryParams.append("&MobileApp=").append(Encoder.encode(MobileApp));
        return this;
    }

    public areaBasedSyncList1 (String serviceKey) {
        queryParams.append("?serviceKey=").append(Encoder.encode(serviceKey));
    }

    /**
    * 응답메세지 형식 : REST방식의 URL호출 시 json값 추가(디폴트 응답메세지 형식은XML)
    */
    public areaBasedSyncList1 _type(String _type) {
        queryParams.append("&_type=").append(Encoder.encode(_type));
        return this;
    }

    /**
    * 컨텐츠표출여부(1=표출, 0=비표출)
    */
    public areaBasedSyncList1 showflag(String showflag) {
        queryParams.append("&showflag=").append(Encoder.encode(showflag));
        return this;
    }

    /**
    * 컨텐츠변경일자 (수정년도,수정년월,수정년월일 입력,YYYYMMDD)
    */
    public areaBasedSyncList1 modifiedtime(String modifiedtime) {
        queryParams.append("&modifiedtime=").append(Encoder.encode(modifiedtime));
        return this;
    }

    /**
    * 목록 구분 (Y=목록, N=개수)
    */
    public areaBasedSyncList1 listYN(String listYN) {
        queryParams.append("&listYN=").append(Encoder.encode(listYN));
        return this;
    }

    /**
    * 정렬 구분 (A=제목순, C=수정일순, D=생성일순) 대표이미지가 반드시 있는 정렬 (O=제목순, Q=수정일순, R=생성일순)
    */
    public areaBasedSyncList1 arrange(String arrange) {
        queryParams.append("&arrange=").append(Encoder.encode(arrange));
        return this;
    }

    /**
    * 관광타입(12:관광지, 14:문화시설, 15:축제공연행사, 25:여행코스, 28:레포츠, 32:숙박, 38:쇼핑, 39:음식점) ID
    */
    public areaBasedSyncList1 contentTypeId(String contentTypeId) {
        queryParams.append("&contentTypeId=").append(Encoder.encode(contentTypeId));
        return this;
    }

    /**
    * 지역코드(지역코드조회 참고)
    */
    public areaBasedSyncList1 areaCode(String areaCode) {
        queryParams.append("&areaCode=").append(Encoder.encode(areaCode));
        return this;
    }

    /**
    * 시군구코드(지역코드조회 참고)
    */
    public areaBasedSyncList1 sigunguCode(String sigunguCode) {
        queryParams.append("&sigunguCode=").append(Encoder.encode(sigunguCode));
        return this;
    }

    /**
    * 대분류 코드(서비스분류코드조회 참고)
    */
    public areaBasedSyncList1 cat1(String cat1) {
        queryParams.append("&cat1=").append(Encoder.encode(cat1));
        return this;
    }

    /**
    * 중분류 코드(서비스분류코드조회 참고)
    */
    public areaBasedSyncList1 cat2(String cat2) {
        queryParams.append("&cat2=").append(Encoder.encode(cat2));
        return this;
    }

    /**
    * 소분류 코드(서비스분류코드조회 참고)
    */
    public areaBasedSyncList1 cat3(String cat3) {
        queryParams.append("&cat3=").append(Encoder.encode(cat3));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public areaBasedSyncList1Response fetch() {
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

            return objectMapper.readValue(content.toString(), areaBasedSyncList1Response.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("API 요청 또는 JSON 파싱 실패", e);
        }
    }
}
