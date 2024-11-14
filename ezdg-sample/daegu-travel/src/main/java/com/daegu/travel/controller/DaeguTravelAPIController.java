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
@Tag(name = "대구 여행 관련 정보 조회 From Library", description = "대구 여행을 위해 관광 코스, 숙박 업소, 맛집을 알려주는 API")
public class DaeguTravelAPIController {

    @Operation(summary = "대구 관광 코스 조회", description = "대구의 관광 코스를 조회합니다")
    @GetMapping("/getAllDaeguTourism")
    public List<DaeguTourism> getAllDaeguTourismFromAPI() throws URISyntaxException, IOException {
        return DaeguTravelAPIService.getAllDaeguTourismFromAPI();
    }

    @Operation(summary = "대구 숙박 업소 조회", description = "대구의 숙박 업소를 조회합니다")
    @GetMapping("/getAllDaeguAccommodation")
    public List<DaeguAccommodation> getAllDaeguAccommodationFromAPI() throws URISyntaxException, IOException {
        return DaeguTravelAPIService.getAllDaeguAccommodationFromAPI();
    }

    @Operation(summary = "대구 맛집 식당 조회", description = "대구의 맛집 식당을 조회합니다")
    @GetMapping("/getAllDaeguRestaurant")
    public List<DaeguRestaurant> getAllDaeguRestaurantFromAPI() throws URISyntaxException, IOException {
        return DaeguTravelAPIService.getAllDaeguRestaurantFromAPI();
    }
}
