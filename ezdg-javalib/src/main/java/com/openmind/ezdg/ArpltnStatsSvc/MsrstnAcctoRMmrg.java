package com.openmind.ezdg.ArpltnStatsSvc;

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

public class MsrstnAcctoRMmrg {
    private static final String BASE_URL = "http://apis.data.go.kr/B552584/ArpltnStatsSvc/getMsrstnAcctoRMmrg";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
        "inqBginMm",
        "inqEndMm",
    };

    public MsrstnAcctoRMmrg (String serviceKey) {
        queryParams.append("?serviceKey=").append(Encoder.encode(serviceKey));
    }

    /**
    * xml 또는 json
    */
    public MsrstnAcctoRMmrg returnType(String returnType) {
        queryParams.append("&returnType=").append(Encoder.encode(returnType));
        return this;
    }

    /**
    * 한 페이지 결과 수
    */
    public MsrstnAcctoRMmrg numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(Encoder.encode(numOfRows));
        return this;
    }

    /**
    * 페이지번호
    */
    public MsrstnAcctoRMmrg pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(Encoder.encode(pageNo));
        return this;
    }

    /**
    * 조회시작월
    */
    public MsrstnAcctoRMmrg inqBginMm(String inqBginMm) {
        queryParams.append("&inqBginMm=").append(Encoder.encode(inqBginMm));
        return this;
    }

    /**
    * 조회종료월
    */
    public MsrstnAcctoRMmrg inqEndMm(String inqEndMm) {
        queryParams.append("&inqEndMm=").append(Encoder.encode(inqEndMm));
        return this;
    }

    /**
    * 측정소명
    */
    public MsrstnAcctoRMmrg msrstnName(String msrstnName) {
        queryParams.append("&msrstnName=").append(Encoder.encode(msrstnName));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public MsrstnAcctoRMmrgResponse fetch() {
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

            return objectMapper.readValue(content.toString(), MsrstnAcctoRMmrgResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("API 요청 또는 JSON 파싱 실패", e);
        }
    }
}
