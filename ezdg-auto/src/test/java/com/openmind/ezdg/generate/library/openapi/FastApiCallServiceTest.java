package com.openmind.ezdg.generate.library.openapi;

import VilageFcstInfoService.VilagefcstinfoserviceAPI;
import VilageFcstInfoService.VilagefcstinfoserviceResponse;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
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
    public void testWeatherFetch() {
        // VilagefcstinfoserviceAPI 인스턴스를 생성
        VilagefcstinfoserviceAPI api = new VilagefcstinfoserviceAPI()
                .ServiceKey("your-service-key")       // 공공데이터포털에서 발급받은 인증키를 넣어주세요
                .pageNo(1)                            // 페이지 번호 설정
                .numOfRows(10)                        // 한 페이지 결과 수 설정
                .dataType("JSON")                     // 응답 데이터 타입 설정 (JSON or XML)
                .base_date(20241101)                  // 기준 날짜 (예: 2024년 6월 28일)
                .base_time(600)                       // 기준 시간 (예: 06:00)
                .nx(60)                               // 예보 지점 X 좌표
                .ny(127);                             // 예보 지점 Y 좌표

        // API 호출하여 결과 리스트 가져오기
        List<VilagefcstinfoserviceResponse> responses = api.fetch();

        // 응답이 null이 아님을 확인
        System.out.println(responses);
        //assertNotNull(responses, "The fetch result should not be null");

        // 각 응답 결과 출력 (옵션)
        responses.forEach(response -> System.out.println(response));
    }
}
