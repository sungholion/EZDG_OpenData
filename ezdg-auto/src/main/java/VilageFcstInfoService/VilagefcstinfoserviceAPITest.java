package VilageFcstInfoService;

import java.util.List;

public class VilagefcstinfoserviceAPITest {
    public static void main(String[] args) {
        try {
            // VilagefcstinfoserviceAPI 인스턴스 생성 및 파라미터 설정
            VilagefcstinfoserviceAPI api = new VilagefcstinfoserviceAPI()
                    .ServiceKey("AjfNwt5gGi7y9HqihqAb4uGiX5wOhFAu5uhT%2B%2Bn9jwuoU6ZMOGo1nny%2FWyxcZG1LzOFicbztT6huskonphWasQ%3D%3D") // 실제 인증키로 대체
                    .pageNo(1)
                    .numOfRows(10)
                    .dataType("JSON")
                    .base_date(20241104)
                    .base_time("0600")
                    .nx(60)
                    .ny(127);

            // API 호출
            VilagefcstinfoserviceResponse response = api.fetch();
            List<VilagefcstinfoserviceResponse.Item> items = response.getResponse().getBody().getItems().getItem();
            for (VilagefcstinfoserviceResponse.Item item : items) {
                System.out.println("Base Date: " + item.getBaseDate());
                System.out.println("Base Time: " + item.getBaseTime());
                System.out.println("Category: " + item.getCategory());
                System.out.println("nx: " + item.getNx());
                System.out.println("ny: " + item.getNy());
                System.out.println("Observation Value: " + item.getObsrValue());
                System.out.println("-----------------------");
            }

            // 응답 출력
            System.out.println("API 호출 결과:");
            System.out.println(response.toString());

        } catch (Exception e) {
            System.err.println("API 호출 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
