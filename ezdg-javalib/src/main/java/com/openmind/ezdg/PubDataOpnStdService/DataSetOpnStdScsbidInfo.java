package com.openmind.ezdg.PubDataOpnStdService;

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

public class DataSetOpnStdScsbidInfo {
    private static final String BASE_URL = "http://apis.data.go.kr/1230000/PubDataOpnStdService/getDataSetOpnStdScsbidInfo";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
        "bsnsDivCd",
    };

    public DataSetOpnStdScsbidInfo (String serviceKey) {
        queryParams.append("?ServiceKey=").append(Encoder.encode(serviceKey));
    }

    /**
    * 페이지번호
    */
    public DataSetOpnStdScsbidInfo pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(Encoder.encode(pageNo));
        return this;
    }

    /**
    * 한 페이지 결과 수
    */
    public DataSetOpnStdScsbidInfo numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(Encoder.encode(numOfRows));
        return this;
    }

    /**
    * 오픈API 리턴 타입을 JSON으로 받고 싶을 경우 'json' 으로 지정
    */
    public DataSetOpnStdScsbidInfo type(String type) {
        queryParams.append("&type=").append(Encoder.encode(type));
        return this;
    }

    /**
    * 업무구분코드가 1이면 물품, 2면 외자, 3이면 공사, 5면 용역
    */
    public DataSetOpnStdScsbidInfo bsnsDivCd(String bsnsDivCd) {
        queryParams.append("&bsnsDivCd=").append(Encoder.encode(bsnsDivCd));
        return this;
    }

    /**
    * 검색하고자하는 개찰일시범위 시작 'YYYYMMDDHHMM' (개찰일시 범위는 1주일로 제한)
    */
    public DataSetOpnStdScsbidInfo opengBgnDt(String opengBgnDt) {
        queryParams.append("&opengBgnDt=").append(Encoder.encode(opengBgnDt));
        return this;
    }

    /**
    * 검색하고자하는 개찰일시범위 종료 'YYYYMMDDHHMM' (개찰일시 범위는 1주일로 제한)
    */
    public DataSetOpnStdScsbidInfo opengEndDt(String opengEndDt) {
        queryParams.append("&opengEndDt=").append(Encoder.encode(opengEndDt));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public DataSetOpnStdScsbidInfoResponse fetch() {
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

            return objectMapper.readValue(content.toString(), DataSetOpnStdScsbidInfoResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("API 요청 또는 JSON 파싱 실패", e);
        }
    }
}
