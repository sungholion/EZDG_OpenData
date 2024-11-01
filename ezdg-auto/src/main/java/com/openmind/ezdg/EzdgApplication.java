package com.openmind.ezdg;

//import VilageFcstInfoService.VilagefcstinfoserviceAPI;
//import VilageFcstInfoService.VilagefcstinfoserviceResponse;
import VilageFcstInfoService.VilagefcstinfoserviceAPI;
import VilageFcstInfoService.VilagefcstinfoserviceResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.util.List;
@SpringBootApplication
@ComponentScan(excludeFilters = @ComponentScan.Filter(pattern = "com.openmind.ezdg.file.*", type = FilterType.REGEX))
public class EzdgApplication {

	public static void main(String[] args) {
		SpringApplication.run(EzdgApplication.class, args);

		try {
			// API 호출 테스트 코드
			VilagefcstinfoserviceAPI api = new VilagefcstinfoserviceAPI()
					.ServiceKey("FNEiXVDs8uhQ7bHEeW%2Bou2xekuNtjIVurFi%2Fvp6nfH3Ky4eIQwCGLgoxF%2BoQZisPqm02pYf0M5u9xu1fjbJMMQ%3D%3D")
					.pageNo(1)
					.numOfRows(1000)
					.dataType("JSON")
					.base_date(20241101)
					.base_time("0600")  // 문자열로 설정하여 앞의 0 유지
					.nx(60)
					.ny(127);


			List<VilagefcstinfoserviceResponse> responseList = api.fetch();
			for (VilagefcstinfoserviceResponse response : responseList) {
				System.out.println("결과코드: " + response.getResultCode());
				System.out.println("결과메시지: " + response.getResultMsg());
				System.out.println("기준 날짜: " + response.getBaseDate());
				System.out.println("기준 시간: " + response.getBaseTime());
				System.out.println("좌표 X: " + response.getNx());
				System.out.println("좌표 Y: " + response.getNy());
				System.out.println("카테고리: " + response.getCategory());
				System.out.println("관측값: " + response.getObsrValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
