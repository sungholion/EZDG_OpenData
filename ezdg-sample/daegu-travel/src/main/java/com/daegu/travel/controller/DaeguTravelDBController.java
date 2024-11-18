package com.daegu.travel.controller;

import com.daegu.travel.dto.DaeguRestaurantDto;
import com.daegu.travel.dto.DaeguAccommodationDto;
import com.daegu.travel.dto.DaeguTourismDto;
import com.daegu.travel.kafka.KafkaProducer;
import com.daegu.travel.service.DaeguTravelDBService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/daeguTravelDB")
@Tag(name = "대구 여행 관련 정보 조회 From DB", description = "대구 여행을 위해 관광 코스, 숙박 업소, 맛집을 알려주는 API")
public class DaeguTravelDBController {

    private final KafkaProducer kafkaProducer;

    public DaeguTravelDBController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/getAllDaeguTourism")
    public void getAllDaeguTourismFromDB() {
        kafkaProducer.sendMessage("daegu-travel", "getAllDaeguTourism");
    }

    @GetMapping("/getAllDaeguAccommodation")
    public void getAllDaeguAccommodationFromDB() {
        kafkaProducer.sendMessage("daegu-travel", "getAllDaeguAccommodation");
    }

    @GetMapping("/getAllDaeguRestaurant")
    public void getAllDaeguRestaurantFromDB() {
        kafkaProducer.sendMessage("daegu-travel", "getAllDaeguRestaurant");
    }

//    @Operation(summary = "대구 관광 코스 조회", description = "대구의 관광 코스를 조회합니다")
//    @GetMapping("/getAllDaeguTourism")
//    public List<DaeguTourismDto> getAllDaeguTourismFromDB() {
//        return DaeguTravelDBService.getAllDaeguTourismFromDB();
//    }
//
//    @Operation(summary = "대구 숙박 업소 조회", description = "대구의 숙박 업소를 조회합니다")
//    @GetMapping("/getAllDaeguAccommodation")
//    public List<DaeguAccommodationDto> getAllDaeguAccommodationFromDB() {
//        return DaeguTravelDBService.getAllDaeguAccommodationFromDB();
//    }
//
//    @Operation(summary = "대구 맛집 식당 조회", description = "대구의 맛집 식당을 조회합니다")
//    @GetMapping("/getAllDaeguRestaurant")
//    public List<DaeguRestaurantDto> getAllDaeguRestaurantFromDB() {
//        return DaeguTravelDBService.getAllDaeguRestaurantFromDB();
//    }
}
