package com.openmind.ezdg.AsosHourlyInfoService;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class WthrDataList {
    private static final String BASE_URL = "http://apis.data.go.kr/1360000/AsosHourlyInfoService/getWthrDataList";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
        "dataCd",
        "dateCd",
        "startDt",
        "startHh",
        "endDt",
        "endHh",
        "stnIds",
    };

    public WthrDataList (String serviceKey) {
        queryParams.append("?ServiceKey=").append(encode(serviceKey));
    }

    /**
    * 페이지번호 Default : 10
    */
    public WthrDataList pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(encode(pageNo));
        return this;
    }

    /**
    * 한 페이지 결과 수 Default : 1
    */
    public WthrDataList numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(encode(numOfRows));
        return this;
    }

    /**
    * 요청자료형식(XML/JSON) Default : XML
    */
    public WthrDataList dataType(String dataType) {
        queryParams.append("&dataType=").append(encode(dataType));
        return this;
    }

    /**
    * 자료 분류 코드(ASOS)
    */
    public WthrDataList dataCd(String dataCd) {
        queryParams.append("&dataCd=").append(encode(dataCd));
        return this;
    }

    /**
    * 날짜 분류 코드(HR)
    */
    public WthrDataList dateCd(String dateCd) {
        queryParams.append("&dateCd=").append(encode(dateCd));
        return this;
    }

    /**
    * 조회 기간 시작일(YYYYMMDD)
    */
    public WthrDataList startDt(String startDt) {
        queryParams.append("&startDt=").append(encode(startDt));
        return this;
    }

    /**
    * 조회 기간 시작시(HH)
    */
    public WthrDataList startHh(String startHh) {
        queryParams.append("&startHh=").append(encode(startHh));
        return this;
    }

    /**
    * 조회 기간 종료일(YYYYMMDD) (전일(D-1) 까지 제공)
    */
    public WthrDataList endDt(String endDt) {
        queryParams.append("&endDt=").append(encode(endDt));
        return this;
    }

    /**
    * 조회 기간 종료시(HH)
    */
    public WthrDataList endHh(String endHh) {
        queryParams.append("&endHh=").append(encode(endHh));
        return this;
    }

    /**
    * 종관기상관측 지점 번호 (활용가이드 하단 첨부 참조)
    */
    public WthrDataList stnIds(String stnIds) {
        queryParams.append("&stnIds=").append(encode(stnIds));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public WthrDataListResponse fetch() {
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

            return objectMapper.readValue(content.toString(), WthrDataListResponse.class);
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
