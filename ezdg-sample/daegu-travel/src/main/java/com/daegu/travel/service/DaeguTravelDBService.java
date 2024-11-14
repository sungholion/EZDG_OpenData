package com.daegu.travel.service;

import com.daegu.travel.dto.DaeguAccommodationDto;
import com.daegu.travel.dto.DaeguRestaurantDto;
import com.daegu.travel.dto.DaeguTourismDto;
import com.daegu.travel.entity.DaeguAccommodationEntity;
import com.daegu.travel.entity.DaeguRestaurantEntity;
import com.daegu.travel.entity.DaeguTourismEntity;
import com.daegu.travel.repository.DaeguAccommodationRepository;
import com.daegu.travel.repository.DaeguRestaurantRepository;
import com.daegu.travel.repository.DaeguTourismRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DaeguTravelDBService {

    private static DaeguTourismRepository daeguTourismRepository = null;
    private static DaeguAccommodationRepository daeguAccommodationRepository = null;
    private static DaeguRestaurantRepository daeguRestaurantRepository = null;

    public DaeguTravelDBService(DaeguTourismRepository daeguTourismRepository,
                                 DaeguAccommodationRepository daeguAccommodationRepository,
                                 DaeguRestaurantRepository daeguRestaurantRepository) {
        DaeguTravelDBService.daeguTourismRepository = daeguTourismRepository;
        DaeguTravelDBService.daeguAccommodationRepository = daeguAccommodationRepository;
        DaeguTravelDBService.daeguRestaurantRepository = daeguRestaurantRepository;
    }


    public static List<DaeguTourismDto> getAllDaeguTourismFromDB() {
        List<DaeguTourismEntity> entities = daeguTourismRepository.findAll();
        return entities.stream()
                .map(entity -> new DaeguTourismDto(
                        entity.getId(),
                        entity.getClassification(),
                        entity.getCourseTitle(),
                        entity.getCourseNumber(),
                        entity.getCourseTopic(),
                        entity.getCourseTopicDescription(),
                        entity.getRegion(),
                        entity.getTouristDestination(),
                        entity.getCourseDescription(),
                        entity.getAddress(),
                        entity.getPhoneNumber(),
                        entity.getHomepage()
                ))
                .collect(Collectors.toList());
    }

    public static List<DaeguAccommodationDto> getAllDaeguAccommodationFromDB(){
        List<DaeguAccommodationEntity> entities = daeguAccommodationRepository.findAll();
        return entities.stream()
                .map(entity -> new DaeguAccommodationDto(
                        entity.getId(),
                        entity.getNumber(),
                        entity.getIndustryClassification(),
                        entity.getGuestMistakeStandard(),
                        entity.getGuestMistakeCount(),
                        entity.getPhoneNumber(),
                        entity.getGuestMistakeOneRoom(),
                        entity.getGuestMistakeDeluxe(),
                        entity.getLocation(),
                        entity.getRegion(),
                        entity.getGuestMistakeSuite(),
                        entity.getGuestMistakeOther(),
                        entity.getHotelName()
                ))
                .collect(Collectors.toList());
    }

    public static List<DaeguRestaurantDto> getAllDaeguRestaurantFromDB() {
        String[] regions = {"중구", "동구", "서구", "남구", "북구", "수성구", "달서구", "달성군", "군위군"};

        int size = 50;
        Pageable pageable = PageRequest.of(0, size);

        List<DaeguRestaurantDto> allData = new ArrayList<>();

        for (String region : regions) {
            List<DaeguRestaurantEntity> entities = daeguRestaurantRepository.findByBusinessAddressContaining(region, pageable).getContent();

            List<DaeguRestaurantDto> regionData = entities.stream()
                    .map(entity -> new DaeguRestaurantDto(
                            entity.getId(),
                            entity.getNumber(),
                            entity.getBusinessName(),
                            entity.getBusinessType(),
                            entity.getBusinessAddress()
                    ))
                    .collect(Collectors.toList());

            allData.addAll(regionData);
        }

        return allData;
    }
}
