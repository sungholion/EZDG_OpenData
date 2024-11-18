package com.daegu.travel.kafka;

import com.daegu.travel.dto.DaeguAccommodationDto;
import com.daegu.travel.dto.DaeguRestaurantDto;
import com.daegu.travel.dto.DaeguTourismDto;
import com.daegu.travel.service.DaeguTravelDBService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class KafkaConsumer {

    private final DaeguTravelDBService daeguTravelDBService;

    public KafkaConsumer(DaeguTravelDBService daeguTravelDBService) {
        this.daeguTravelDBService = daeguTravelDBService;
    }

    @KafkaListener(topics = "daegu-travel", groupId = "daegu-travel-group")
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);

        // 메시지에 따른 분기 처리
        switch (message) {
            case "getAllDaeguTourism":
                List<DaeguTourismDto> tourismData = DaeguTravelDBService.getAllDaeguTourismFromDB();
                System.out.println("Tourism Data: " + tourismData);
                break;

            case "getAllDaeguAccommodation":
                List<DaeguAccommodationDto> accommodationData = DaeguTravelDBService.getAllDaeguAccommodationFromDB();
                System.out.println("Accommodation Data: " + accommodationData);
                break;

            case "getAllDaeguRestaurant":
                List<DaeguRestaurantDto> restaurantData = DaeguTravelDBService.getAllDaeguRestaurantFromDB();
                System.out.println("Restaurant Data: " + restaurantData);
                break;

            default:
                System.out.println("Unknown message type: " + message);
        }

        // 메시지를 처리하여 DB에서 데이터 가져오기 등 로직 추가
    }
}