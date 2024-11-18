package com.daegu.travel.controller;

import com.daegu.travel.dto.DaeguRestaurantDto;
import com.daegu.travel.dto.DaeguAccommodationDto;
import com.daegu.travel.dto.DaeguTourismDto;
import com.daegu.travel.service.DaeguTravelDBService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/daeguTravelDB")
@Tag(name = "대구 여행 관련 정보 조회 From DB", description = "대구 여행을 위해 관광 코스, 숙박 업소, 맛집을 알려주는 API")
public class DaeguTravelDBController {

    private final DaeguTravelDBService daeguTravelDBService;

    public DaeguTravelDBController(DaeguTravelDBService daeguTravelDBService) {
        this.daeguTravelDBService = daeguTravelDBService;
    }


    @Operation(summary = "대구 관광 코스 조회", description = "대구의 관광 코스를 조회합니다")
    @GetMapping("/getAllDaeguTourism")
    public List<DaeguTourismDto> getAllDaeguTourismFromCache(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return daeguTravelDBService.getAllDaeguTourismFromCache(pageable);
    }

    @Operation(summary = "대구 숙박 업소 조회", description = "대구의 숙박 업소를 조회합니다")
    @GetMapping("/getAllDaeguAccommodation")
    public List<DaeguAccommodationDto> getAllDaeguAccommodationFromDB(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return daeguTravelDBService.getAllDaeguAccommodationFromCache(pageable);
    }

    @Operation(summary = "대구 맛집 식당 조회", description = "대구의 맛집 식당을 조회합니다")
    @GetMapping("/getAllDaeguRestaurant")
    public List<DaeguRestaurantDto> getAllDaeguRestaurantFromDB(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return daeguTravelDBService.getAllDaeguRestaurantFromCache(pageable);
    }

    @Operation(summary = "대구 관광 코스 조회", description = "대구의 관광 코스를 조회합니다")
    @GetMapping("/getAllDaeguTourismNoRedis")
    public List<DaeguTourismDto> getAllDaeguTourismFromDBNoRedis(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return daeguTravelDBService.getAllDaeguTourismFromDBNoRedis(pageable);
    }

    @Operation(summary = "대구 숙박 업소 조회", description = "대구의 숙박 업소를 조회합니다")
    @GetMapping("/getAllDaeguAccommodationNoRedis")
    public List<DaeguAccommodationDto> getAllDaeguAccommodationFromDBNoRedis(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return daeguTravelDBService.getAllDaeguAccommodationFromDBNoRedis(pageable);
    }

    @Operation(summary = "대구 맛집 식당 조회", description = "대구의 맛집 식당을 조회합니다")
    @GetMapping("/getAllDaeguRestaurantNoRedis")
    public List<DaeguRestaurantDto> getAllDaeguRestaurantFromDBNoRedis(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return daeguTravelDBService.getAllDaeguRestaurantFromDBNoRedis(pageable);
    }




}


