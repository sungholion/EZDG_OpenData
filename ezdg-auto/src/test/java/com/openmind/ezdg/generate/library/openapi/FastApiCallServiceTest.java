package com.openmind.ezdg.generate.library.openapi;

import VilageFcstInfoService.VilagefcstinfoserviceAPI;
import VilageFcstInfoService.VilagefcstinfoserviceResponse;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

public class FastApiCallServiceTest {
    private RestTemplate restTemplate;
    private FastApiCallService fastApiCallService;

    @BeforeEach
    public void setUp() {
        restTemplate = new RestTemplate();
        fastApiCallService = new FastApiCallService(restTemplate);
    }

    @Test
    public void tableFormApi() throws IOException, TemplateException {
        String inputUrl = "https://www.data.go.kr/data/15084084/openapi.do";
        String filePath = fastApiCallService.tableFormApi(inputUrl);
        System.out.println("SAVED AT : " + filePath);

        CodeGenerator codeGenerator = new CodeGenerator();
        codeGenerator.generateCode(filePath);
    }

    @Test
    public void getnerateCode() throws IOException, TemplateException {

        CodeGenerator codeGenerator = new CodeGenerator();
        codeGenerator.generateCode("src/main/resources/api_spec_generated.json");
    }

    @Test
    public void testWeatherFetch() throws Exception {
        // VilagefcstinfoserviceAPI 인스턴스를 생성
        VilagefcstinfoserviceAPI api = new VilagefcstinfoserviceAPI()
                .ServiceKey("AjfNwt5gGi7y9HqihqAb4uGiX5wOhFAu5uhT%2B%2Bn9jwuoU6ZMOGo1nny%2FWyxcZG1LzOFicbztT6huskonphWasQ%3D%3D")       // 공공데이터포털에서 발급받은 인증키를 넣어주세요
                .pageNo("1")                            // 페이지 번호 설정
                .numOfRows("10")                        // 한 페이지 결과 수 설정
                .dataType("JSON")                     // 응답 데이터 타입 설정 (JSON or XML)
                .base_date("20241106")                  // 기준 날짜 (예: 2024년 6월 28일)
                .base_time("0600")                       // 기준 시간 (예: 06:00)
                .nx("60")                               // 예보 지점 X 좌표
                .ny("127");                             // 예보 지점 Y 좌표

        // API 호출하여 결과 리스트 가져오기
        VilagefcstinfoserviceResponse response = api.fetch();

        // Items 내의 item 리스트 가져오기
        List<VilagefcstinfoserviceResponse.Item> items = response.getResponse().getBody().getItems().getItem();

        // 전체 Body 출력
        System.out.println(response.getResponse().getBody());

        // Item 리스트 출력
        for (VilagefcstinfoserviceResponse.Item item : items) {
            System.out.println("Base Date: " + item.getBaseDate());
            System.out.println("Base Time: " + item.getBaseTime());
            System.out.println("Category: " + item.getCategory());
            System.out.println("nx: " + item.getNx());
            System.out.println("ny: " + item.getNy());
            System.out.println("Observation Value: " + item.getObsrValue());
            System.out.println("-----------------------");
        }
    }
}
