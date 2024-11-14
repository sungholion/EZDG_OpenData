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

public class TechFieldRecordPatInfo {
    private static final String BASE_URL = "http://apis.data.go.kr/1430000/StdPatInfoService/getTechFieldRecordPatInfo";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
    };

    /**
    * 한 페이지 결과 수기본 값 : 10, 최대 값 : 1000)
    */
    public TechFieldRecordPatInfo numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(encode(numOfRows));
        return this;
    }

    /**
    * 페이지번호 기본 값 : 1 )
    */
    public TechFieldRecordPatInfo pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(encode(pageNo));
        return this;
    }

    /**
    * XML/JSON, 기본 값 : xml
    */
    public TechFieldRecordPatInfo resultType(String resultType) {
        queryParams.append("&resultType=").append(encode(resultType));
        return this;
    }

    /**
    * Kipris IPC목록
    */
    public TechFieldRecordPatInfo ipc(String ipc) {
        queryParams.append("&ipc=").append(encode(ipc));
        return this;
    }

    /**
    * Kipris IPC명칭
    */
    public TechFieldRecordPatInfo ipctitle(String ipctitle) {
        queryParams.append("&ipctitle=").append(encode(ipctitle));
        return this;
    }

    /**
    * 시작 선언일자(8자리)
    */
    public TechFieldRecordPatInfo startdeclaredate(String startdeclaredate) {
        queryParams.append("&startdeclaredate=").append(encode(startdeclaredate));
        return this;
    }

    /**
    * 종료 선언일자(8자리)
    */
    public TechFieldRecordPatInfo enddeclaredate(String enddeclaredate) {
        queryParams.append("&enddeclaredate=").append(encode(enddeclaredate));
        return this;
    }

    /**
    * Kipris IPC(IPC1st)
    */
    public TechFieldRecordPatInfo ipclist(String ipclist) {
        queryParams.append("&ipclist=").append(encode(ipclist));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public TechFieldRecordPatInfoResponse fetch() {
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

            return objectMapper.readValue(content.toString(), TechFieldRecordPatInfoResponse.class);
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
