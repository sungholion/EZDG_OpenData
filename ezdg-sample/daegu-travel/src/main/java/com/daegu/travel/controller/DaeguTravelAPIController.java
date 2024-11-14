package com.daegu.travel.controller;

import com.daegu.travel.service.DaeguTravelAPIService;
import com.openmind.ezdg.daegu_accommodation.DaeguAccommodation;
import com.openmind.ezdg.daegu_restaurant.DaeguRestaurant;
import com.openmind.ezdg.daegu_tourism.DaeguTourism;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/daeguTravelAPI")
@Tag(name = "대구 여행 코스 조회 From Library", description = "대구 여행 코스를 조회하는 공공 데이터 서비스")
public class DaeguTravelAPIController {

    @Operation(summary = "대구 여행 코스 조회 API", description = "API 서버로 대구광역시_관광코스 정보_20231215.csv 파일 데이터를 조회합니다.")
    @GetMapping("/getAllDaeguTourism")
    public List<DaeguTourism> getAllDaeguTourismFromAPI() throws URISyntaxException, IOException {
        return DaeguTravelAPIService.getAllDaeguTourismFromAPI();
    }

    @Operation(summary = "대구 숙박 조회 API", description = "API 서버로 대구광역시_관광코스 정보_20231215.csv 파일 데이터를 조회합니다.")
    @GetMapping("/getAllDaeguAccommodation")
    public List<DaeguAccommodation> getAllDaeguAccommodationFromAPI() throws URISyntaxException, IOException {
        return DaeguTravelAPIService.getAllDaeguAccommodationFromAPI();
    }

    @Operation(summary = "대구 여행 코스 조회 API", description = "API 서버로 대구광역시_관광코스 정보_20231215.csv 파일 데이터를 조회합니다.")
    @GetMapping("/getAllDaeguRestaurant")
    public List<DaeguRestaurant> getAllDaeguRestaurantFromAPI() throws URISyntaxException, IOException {
        return DaeguTravelAPIService.getAllDaeguRestaurantFromAPI();
    }


}
