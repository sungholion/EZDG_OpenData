package com.openmind.ezdg.VilageFcstInfoService;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class FcstVersion {
    private static final String BASE_URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getFcstVersion";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
        "pageNo",
        "numOfRows",
        "ftype",
        "basedatetime",
    };

    public FcstVersion (String serviceKey) {
        queryParams.append("?ServiceKey=").append(serviceKey);
    }

    /**
    * 페이지번호
    */
    public FcstVersion pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(pageNo);
        return this;
    }

    /**
    * 한 페이지 결과 수
    */
    public FcstVersion numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(numOfRows);
        return this;
    }

    /**
    * 요청자료형식(XML/JSON) Default: XML
    */
    public FcstVersion dataType(String dataType) {
        queryParams.append("&dataType=").append(dataType);
        return this;
    }

    /**
    * 파일구분 -ODAM: 동네예보실황 -VSRT: 동네예보초단기 -SHRT: 동네예보단기
    */
    public FcstVersion ftype(String ftype) {
        queryParams.append("&ftype=").append(ftype);
        return this;
    }

    /**
    * 각각의 base_time 로 검색
    */
    public FcstVersion basedatetime(String basedatetime) {
        queryParams.append("&basedatetime=").append(basedatetime);
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public FcstVersionResponse fetch() {
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
