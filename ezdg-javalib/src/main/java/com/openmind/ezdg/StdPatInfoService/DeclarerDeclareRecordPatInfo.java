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

public class DeclarerDeclareRecordPatInfo {
    private static final String BASE_URL = "http://apis.data.go.kr/1430000/StdPatInfoService/getDeclarerDeclareRecordPatInfo";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
    };

    /**
    * 한 페이지 결과 수
    */
    public DeclarerDeclareRecordPatInfo numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(encode(numOfRows));
        return this;
    }

    /**
    * 페이지번호( 기본 값 : 1 )
    */
    public DeclarerDeclareRecordPatInfo pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(encode(pageNo));
        return this;
    }

    /**
    * XML/JSON기본 값 : xml
    */
    public DeclarerDeclareRecordPatInfo resultType(String resultType) {
        queryParams.append("&resultType=").append(encode(resultType));
        return this;
    }

    /**
    * 선언자국가_정비
    */
    public DeclarerDeclareRecordPatInfo declarercountry_adjust(String declarercountry_adjust) {
        queryParams.append("&declarercountry_adjust=").append(encode(declarercountry_adjust));
        return this;
    }

    /**
    * 시작 선언일자(8자리)
    */
    public DeclarerDeclareRecordPatInfo startdeclaredate(String startdeclaredate) {
        queryParams.append("&startdeclaredate=").append(encode(startdeclaredate));
        return this;
    }

    /**
    * 종료 선언일자(8자리)
    */
    public DeclarerDeclareRecordPatInfo enddeclaredate(String enddeclaredate) {
        queryParams.append("&enddeclaredate=").append(encode(enddeclaredate));
        return this;
    }

    /**
    * OECD여부(Y/N)
    */
    public DeclarerDeclareRecordPatInfo oecdyn(String oecdyn) {
        queryParams.append("&oecdyn=").append(encode(oecdyn));
        return this;
    }

    /**
    * 클럽2050여부(Y/N)
    */
    public DeclarerDeclareRecordPatInfo club2050yn(String club2050yn) {
        queryParams.append("&club2050yn=").append(encode(club2050yn));
        return this;
    }

    /**
    * Kipris 출원인
    */
    public DeclarerDeclareRecordPatInfo applicant(String applicant) {
        queryParams.append("&applicant=").append(encode(applicant));
        return this;
    }

    /**
    * Kipris 발명인
    */
    public DeclarerDeclareRecordPatInfo inventor(String inventor) {
        queryParams.append("&inventor=").append(encode(inventor));
        return this;
    }

    /**
    * Kipris 발명명칭
    */
    public DeclarerDeclareRecordPatInfo inventtitle(String inventtitle) {
        queryParams.append("&inventtitle=").append(encode(inventtitle));
        return this;
    }

    /**
    * 선언자_정비
    */
    public DeclarerDeclareRecordPatInfo declarer_adjust(String declarer_adjust) {
        queryParams.append("&declarer_adjust=").append(encode(declarer_adjust));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public DeclarerDeclareRecordPatInfoResponse fetch() {
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

            return objectMapper.readValue(content.toString(), DeclarerDeclareRecordPatInfoResponse.class);
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
