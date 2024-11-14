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

public class StdOrganInfo {
    private static final String BASE_URL = "http://apis.data.go.kr/1430000/StdPatInfoService/getStdOrganInfo";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
    };

    /**
    * 한 페이지 결과 수
    */
    public StdOrganInfo numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(encode(numOfRows));
        return this;
    }

    /**
    * 페이지번호
    */
    public StdOrganInfo pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(encode(pageNo));
        return this;
    }

    /**
    * 결과형식 ( XML/JSON, 기본 값 : xml )
    */
    public StdOrganInfo resultType(String resultType) {
        queryParams.append("&resultType=").append(encode(resultType));
        return this;
    }

    /**
    * 표준기구코드
    */
    public StdOrganInfo stdorgancd(String stdorgancd) {
        queryParams.append("&stdorgancd=").append(encode(stdorgancd));
        return this;
    }

    /**
    * 연구반정보_분류
    */
    public StdOrganInfo sginfoclass(String sginfoclass) {
        queryParams.append("&sginfoclass=").append(encode(sginfoclass));
        return this;
    }

    /**
    * 연구반정보_분류1
    */
    public StdOrganInfo sginfoclass1(String sginfoclass1) {
        queryParams.append("&sginfoclass1=").append(encode(sginfoclass1));
        return this;
    }

    /**
    * 연구반정보_분류2
    */
    public StdOrganInfo sginfoclass2(String sginfoclass2) {
        queryParams.append("&sginfoclass2=").append(encode(sginfoclass2));
        return this;
    }

    /**
    * 연구반정보_분류3
    */
    public StdOrganInfo sginfoclass3(String sginfoclass3) {
        queryParams.append("&sginfoclass3=").append(encode(sginfoclass3));
        return this;
    }

    /**
    * 연구반정보 표준분야_영문
    */
    public StdOrganInfo stdfield_eng(String stdfield_eng) {
        queryParams.append("&stdfield_eng=").append(encode(stdfield_eng));
        return this;
    }

    /**
    * 연구반정보 표준분야_한글
    */
    public StdOrganInfo stdfield_kor(String stdfield_kor) {
        queryParams.append("&stdfield_kor=").append(encode(stdfield_kor));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public StdOrganInfoResponse fetch() {
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

            return objectMapper.readValue(content.toString(), StdOrganInfoResponse.class);
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
