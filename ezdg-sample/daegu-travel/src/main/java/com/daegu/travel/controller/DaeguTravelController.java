package com.daegu.travel.controller;

import com.daegu.travel.dto.DaeguMetropolitanCityRestaurantRegistrationStatusDto;
import com.daegu.travel.dto.DaeguMetropolitanCityStatusOfTourismAccommodationBusinessDto;
import com.daegu.travel.dto.DaeguTourismCourseInformationDto;
import com.daegu.travel.service.DaeguTravelService;
import com.openmind.ezdg.daegu_tourism_course_information.DaeguTourismCourseInformation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/daeguTravel")
@Tag(name = "대구 여행 코스 조회 API", description = "대구 여행 코스를 조회하는 공공 데이터 서비스")
public class DaeguTravelController {

    @Operation(summary = "(API 서버로부터) 대구 여행 코스 조회 API", description = "API 서버로 대구광역시_관광코스 정보_20231215.csv 파일 데이터를 조회합니다.")
    @GetMapping("/getAllDaeguTourismCourseInformationForAPI")
    public List<DaeguTourismCourseInformation> getAllDaeguTourismCourseInformationForAPI() throws URISyntaxException, IOException {
        return DaeguTravelService.getAllDaeguTourismCourseInformationForAPI();
    }

    @Operation(summary = "(내 DB로부터) 대구 여행 코스 조회 API", description = "라이브러리를 통해 조회한 공공 데이터를 내 DB에서 저장한 후, 대구광역시_관광코스 정보_20231215.csv 파일 데이터를 조회합니다.")
    @GetMapping("/getAllDaeguTourismCourseInformationForDB")
    public List<DaeguTourismCourseInformationDto> getAllDaeguTourismCourseInformationForDB() {
        return DaeguTravelService.getAllDaeguTourismCourseInformationForDB();
    }

    @Operation(summary = "(내 DB로부터) 대구 숙박 조회 API", description = "라이브러리를 통해 조회한 공공 데이터를 내 DB에서 저장한 후, 대구광역시_관광코스 정보_20231215.csv 파일 데이터를 조회합니다.")
    @GetMapping("/getAllDaeguMetropolitanCityStatusOfTourismAccommodationBusinessForDB")
    public List<DaeguMetropolitanCityStatusOfTourismAccommodationBusinessDto> getAllDaeguMetropolitanCityStatusOfTourismAccommodationBusinessForDB() {
        return DaeguTravelService.getAllDaeguMetropolitanCityStatusOfTourismAccommodationBusinessForDB();
    }

    @Operation(summary = "(내 DB로부터) 대구 음식점 등록 조회 API", description = "내 DB에서 대구 음식점 등록 현황을 조회합니다.")
    @GetMapping("/getAllDaeguMetropolitanCityRestaurantRegistrationStatusForDB")
    public List<DaeguMetropolitanCityRestaurantRegistrationStatusDto> getAllDaeguMetropolitanCityRestaurantRegistrationStatusForDB() {
        return DaeguTravelService.getAllDaeguMetropolitanCityRestaurantRegistrationStatusForDB();
    }
}
