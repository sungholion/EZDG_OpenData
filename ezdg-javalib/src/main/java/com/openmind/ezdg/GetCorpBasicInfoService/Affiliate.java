package com.openmind.ezdg.GetCorpBasicInfoService;

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

public class Affiliate {
    private static final String BASE_URL = "https://apis.data.go.kr/1160100/service/GetCorpBasicInfoService_V2/getAffiliate_V2";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
        "ServiceKey",
        "pageNo",
        "numOfRows",
        "resultType",
    };

    public Affiliate (String serviceKey) {
        queryParams.append("?ServiceKey=").append(Encoder.encode(serviceKey));
    }

    /**
    * 페이지번호
    */
    public Affiliate pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(Encoder.encode(pageNo));
        return this;
    }

    /**
    * 한 페이지 결과 수
    */
    public Affiliate numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(Encoder.encode(numOfRows));
        return this;
    }

    /**
    * 결과형식(xml/json)
    */
    public Affiliate resultType(String resultType) {
        queryParams.append("&resultType=").append(Encoder.encode(resultType));
        return this;
    }

    /**
    * 작업 또는 거래의 기준이 되는 일자(년월일)
    */
    public Affiliate basDt(String basDt) {
        queryParams.append("&basDt=").append(Encoder.encode(basDt));
        return this;
    }

    /**
    * 법인등록번호
    */
    public Affiliate crno(String crno) {
        queryParams.append("&crno=").append(Encoder.encode(crno));
        return this;
    }

    /**
    * 계열 회사의 이름
    */
    public Affiliate afilCmpyNm(String afilCmpyNm) {
        queryParams.append("&afilCmpyNm=").append(Encoder.encode(afilCmpyNm));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public AffiliateResponse fetch() {
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

            return objectMapper.readValue(content.toString(), AffiliateResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("API 요청 또는 JSON 파싱 실패", e);
        }
    }
}
