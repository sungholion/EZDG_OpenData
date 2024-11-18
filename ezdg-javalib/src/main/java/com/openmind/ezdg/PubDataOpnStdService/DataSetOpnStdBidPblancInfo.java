package com.openmind.ezdg.PubDataOpnStdService;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class DataSetOpnStdBidPblancInfo {
    private static final String BASE_URL = "http://apis.data.go.kr/1230000/PubDataOpnStdService/getDataSetOpnStdBidPblancInfo";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
    };

    public DataSetOpnStdBidPblancInfo (String serviceKey) {
        queryParams.append("?ServiceKey=").append(encode(serviceKey));
    }

    /**
    * 페이지번호
    */
    public DataSetOpnStdBidPblancInfo pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(encode(pageNo));
        return this;
    }

    /**
    * 한 페이지 결과 수
    */
    public DataSetOpnStdBidPblancInfo numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(encode(numOfRows));
        return this;
    }

    /**
    * 오픈API 리턴 타입을 JSON으로 받고 싶을 경우 'json' 으로 지정함
    */
    public DataSetOpnStdBidPblancInfo type(String type) {
        queryParams.append("&type=").append(encode(type));
        return this;
    }

    /**
    * 검색하고자하는 입찰공고일시범위 시작 'YYYYMMDDHHMM' (입찰공고일시 범위는 1개월 로 제한)
    */
    public DataSetOpnStdBidPblancInfo bidNtceBgnDt(String bidNtceBgnDt) {
        queryParams.append("&bidNtceBgnDt=").append(encode(bidNtceBgnDt));
        return this;
    }

    /**
    * 검색하고자하는 입찰공고일시범위 종료 'YYYYMMDDHHMM'  (입찰공고일시 범위는 1개월 로 제한)
    */
    public DataSetOpnStdBidPblancInfo bidNtceEndDt(String bidNtceEndDt) {
        queryParams.append("&bidNtceEndDt=").append(encode(bidNtceEndDt));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public DataSetOpnStdBidPblancInfoResponse fetch() {
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

            return objectMapper.readValue(content.toString(), DataSetOpnStdBidPblancInfoResponse.class);
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
