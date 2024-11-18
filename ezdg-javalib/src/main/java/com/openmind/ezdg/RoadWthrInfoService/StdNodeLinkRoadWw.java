package com.openmind.ezdg.RoadWthrInfoService;

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

public class StdNodeLinkRoadWw {
    private static final String BASE_URL = "http://apis.data.go.kr/1360000/RoadWthrInfoService/getStdNodeLinkRoadWw";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
        "pageNo",
        "numOfRows",
        "stdLinkId",
    };

    public StdNodeLinkRoadWw (String serviceKey) {
        queryParams.append("?ServiceKey=").append(Encoder.encode(serviceKey));
    }

    /**
    * 페이지번호
    */
    public StdNodeLinkRoadWw pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(Encoder.encode(pageNo));
        return this;
    }

    /**
    * 한 페이지 결과 수
    */
    public StdNodeLinkRoadWw numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(Encoder.encode(numOfRows));
        return this;
    }

    /**
    * 요청자료형식(XML/JSON)
    */
    public StdNodeLinkRoadWw dataType(String dataType) {
        queryParams.append("&dataType=").append(Encoder.encode(dataType));
        return this;
    }

    /**
    * 표준노드링크 ID
    */
    public StdNodeLinkRoadWw stdLinkId(String stdLinkId) {
        queryParams.append("&stdLinkId=").append(Encoder.encode(stdLinkId));
        return this;
    }

    /**
    * 최근 결과 시간
    */
    public StdNodeLinkRoadWw hhCode(String hhCode) {
        queryParams.append("&hhCode=").append(Encoder.encode(hhCode));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public StdNodeLinkRoadWwResponse fetch() {
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

            return objectMapper.readValue(content.toString(), StdNodeLinkRoadWwResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("API 요청 또는 JSON 파싱 실패", e);
        }
    }
}
