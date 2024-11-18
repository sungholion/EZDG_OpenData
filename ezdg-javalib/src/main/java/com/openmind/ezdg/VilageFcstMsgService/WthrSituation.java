package com.openmind.ezdg.VilageFcstMsgService;

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

public class WthrSituation {
    private static final String BASE_URL = "http://apis.data.go.kr/1360000/VilageFcstMsgService/getWthrSituation";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
        "pageNo",
        "numOfRows",
        "stnId",
    };

    public WthrSituation (String serviceKey) {
        queryParams.append("?ServiceKey=").append(Encoder.encode(serviceKey));
    }

    /**
    * 페이지번호
    */
    public WthrSituation pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(Encoder.encode(pageNo));
        return this;
    }

    /**
    * 한 페이지 결과 수
    */
    public WthrSituation numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(Encoder.encode(numOfRows));
        return this;
    }

    /**
    * 요청자료형식(XML/JSON)Default: XML
    */
    public WthrSituation dataType(String dataType) {
        queryParams.append("&dataType=").append(Encoder.encode(dataType));
        return this;
    }

    /**
    * 108 기상청, 109 수도권(서울)..등 별첨 엑셀자료 참조(‘개황’ 구분 값 참고)
    */
    public WthrSituation stnId(String stnId) {
        queryParams.append("&stnId=").append(Encoder.encode(stnId));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public WthrSituationResponse fetch() {
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

            return objectMapper.readValue(content.toString(), WthrSituationResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("API 요청 또는 JSON 파싱 실패", e);
        }
    }
}
