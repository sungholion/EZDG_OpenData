package com.openmind.ezdg.DrbEasyDrugInfoService;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class DrbEasyDrugList {
    private static final String BASE_URL = "http://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
    };

    public DrbEasyDrugList (String serviceKey) {
        queryParams.append("?ServiceKey=").append(encode(serviceKey));
    }

    /**
    * 페이지번호
    */
    public DrbEasyDrugList pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(encode(pageNo));
        return this;
    }

    /**
    * 한 페이지 결과 수
    */
    public DrbEasyDrugList numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(encode(numOfRows));
        return this;
    }

    /**
    * 업체명
    */
    public DrbEasyDrugList entpName(String entpName) {
        queryParams.append("&entpName=").append(encode(entpName));
        return this;
    }

    /**
    * 제품명
    */
    public DrbEasyDrugList itemName(String itemName) {
        queryParams.append("&itemName=").append(encode(itemName));
        return this;
    }

    /**
    * 품목기준코드
    */
    public DrbEasyDrugList itemSeq(String itemSeq) {
        queryParams.append("&itemSeq=").append(encode(itemSeq));
        return this;
    }

    /**
    * 이 약의 효능은 무엇입니까?
    */
    public DrbEasyDrugList efcyQesitm(String efcyQesitm) {
        queryParams.append("&efcyQesitm=").append(encode(efcyQesitm));
        return this;
    }

    /**
    * 이 약은 어떻게 사용합니까?
    */
    public DrbEasyDrugList useMethodQesitm(String useMethodQesitm) {
        queryParams.append("&useMethodQesitm=").append(encode(useMethodQesitm));
        return this;
    }

    /**
    * 이 약을 사용하기 전에 반드시 알아야 할 내용은 무엇입니까?
    */
    public DrbEasyDrugList atpnWarnQesitm(String atpnWarnQesitm) {
        queryParams.append("&atpnWarnQesitm=").append(encode(atpnWarnQesitm));
        return this;
    }

    /**
    * 이 약의 사용상 주의사항은 무엇입니까?
    */
    public DrbEasyDrugList atpnQesitm(String atpnQesitm) {
        queryParams.append("&atpnQesitm=").append(encode(atpnQesitm));
        return this;
    }

    /**
    * 이 약을 사용하는 동안 주의해야 할 약 또는 음식은 무엇입니까?
    */
    public DrbEasyDrugList intrcQesitm(String intrcQesitm) {
        queryParams.append("&intrcQesitm=").append(encode(intrcQesitm));
        return this;
    }

    /**
    * 이 약은 어떤 이상반응이 나타날 수 있습니까?
    */
    public DrbEasyDrugList seQesitm(String seQesitm) {
        queryParams.append("&seQesitm=").append(encode(seQesitm));
        return this;
    }

    /**
    * 이 약은 어떻게 보관해야 합니까?
    */
    public DrbEasyDrugList depositMethodQesitm(String depositMethodQesitm) {
        queryParams.append("&depositMethodQesitm=").append(encode(depositMethodQesitm));
        return this;
    }

    /**
    * 공개일자
    */
    public DrbEasyDrugList openDe(String openDe) {
        queryParams.append("&openDe=").append(encode(openDe));
        return this;
    }

    /**
    * 수정일자
    */
    public DrbEasyDrugList updateDe(String updateDe) {
        queryParams.append("&updateDe=").append(encode(updateDe));
        return this;
    }

    /**
    * 응답데이터 형식(xml/json) Default:xml
    */
    public DrbEasyDrugList type(String type) {
        queryParams.append("&type=").append(encode(type));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public DrbEasyDrugListResponse fetch() {
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

            return objectMapper.readValue(content.toString(), DrbEasyDrugListResponse.class);
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
