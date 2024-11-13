package com.openmind.ezdg.VilageFcstInfoService;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FcstVersion {
    private static final String BASE_URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getFcstVersion";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
    * 공공데이터포털에서 받은 인증키
    */
    public FcstVersion ServiceKey(String ServiceKey) {
        if (queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("ServiceKey=").append(ServiceKey);
        return this;
    }

    /**
    * 페이지번호
    */
    public FcstVersion pageNo(String pageNo) {
        if (queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("pageNo=").append(pageNo);
        return this;
    }

    /**
    * 한 페이지 결과 수
    */
    public FcstVersion numOfRows(String numOfRows) {
        if (queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("numOfRows=").append(numOfRows);
        return this;
    }

    /**
    * 요청자료형식(XML/JSON) Default: XML
    */
    public FcstVersion dataType(String dataType) {
        if (queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("dataType=").append(dataType);
        return this;
    }

    /**
    * 파일구분 -ODAM: 동네예보실황 -VSRT: 동네예보초단기 -SHRT: 동네예보단기
    */
    public FcstVersion ftype(String ftype) {
        if (queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("ftype=").append(ftype);
        return this;
    }

    /**
    * 각각의 base_time 로 검색
    */
    public FcstVersion basedatetime(String basedatetime) {
        if (queryParams.length() == 0) queryParams.append("?");
        else queryParams.append("&");
        queryParams.append("basedatetime=").append(basedatetime);
        return this;
    }


    /**
    * API 호출 및 응답 파싱
    */
    public FcstVersionResponse fetch() {
        try {
            URL url = new URL(BASE_URL + queryParams.toString());
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

            return objectMapper.readValue(content.toString(), FcstVersionResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("API 요청 또는 JSON 파싱 실패", e);
        }
    }
}
