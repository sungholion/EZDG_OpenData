package com.daegu.travel.controller;

import com.daegu.travel.dto.DaeguRestaurantDto;
import com.daegu.travel.dto.DaeguAccommodationDto;
import com.daegu.travel.dto.DaeguTourismDto;
import com.daegu.travel.service.DaeguTravelDBService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/daeguTravelDB")
@Tag(name = "대구 여행 코스 조회 From DB", description = "대구 여행 코스를 조회하는 공공 데이터 서비스")
public class DaeguTravelDBController {

    @Operation(summary = "대구 여행 코스 조회 API", description = "라이브러리를 통해 조회한 공공 데이터를 내 DB에서 저장한 후, 대구광역시_관광코스 정보_20231215.csv 파일 데이터를 조회합니다.")
    @GetMapping("/getAllDaeguTourism")
    public List<DaeguTourismDto> getAllDaeguTourismFromDB() {
        return DaeguTravelDBService.getAllDaeguTourismFromDB();
    }

    @Operation(summary = "대구 숙박 조회 API", description = "라이브러리를 통해 조회한 공공 데이터를 내 DB에서 저장한 후, 대구광역시_관광코스 정보_20231215.csv 파일 데이터를 조회합니다.")
    @GetMapping("/getAllDaeguAccommodation")
    public List<DaeguAccommodationDto> getAllDaeguAccommodationFromDB() {
        return DaeguTravelDBService.getAllDaeguAccommodationFromDB();
    }

    @Operation(summary = "대구 음식점 등록 조회 API", description = "내 DB에서 대구 음식점 등록 현황을 조회합니다.")
    @GetMapping("/getAllDaeguRestaurant")
    public List<DaeguRestaurantDto> getAllDaeguRestaurantFromDB() {
        return DaeguTravelDBService.getAllDaeguRestaurantFromDB();
    }
}
