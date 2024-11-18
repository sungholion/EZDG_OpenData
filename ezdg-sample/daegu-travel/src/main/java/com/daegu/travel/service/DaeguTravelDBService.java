package com.daegu.travel.service;

import com.daegu.travel.dto.DaeguAccommodationDto;
import com.daegu.travel.dto.DaeguRestaurantDto;
import com.daegu.travel.dto.DaeguTourismDto;
import com.daegu.travel.repository.DaeguAccommodationRepository;
import com.daegu.travel.repository.DaeguRestaurantRepository;
import com.daegu.travel.repository.DaeguTourismRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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

    private static final int PAGE_SIZE = 100; // 각 페이지 크기

    @Cacheable(value = "daeguTourismCache", key = "'tourism-all'")
    public List<DaeguTourismDto> getAllDaeguTourismFromCache() {
        log.info("Cache miss: Fetching Daegu Tourism data from DB");
        return getAllDaeguTourismFromDB();
    }

    @Cacheable(value = "daeguAccommodationCache", key = "'accommodation-all'")
    public List<DaeguAccommodationDto> getAllDaeguAccommodationFromCache() {
        log.info("Cache miss: Fetching Daegu Accommodation data from DB");
        return getAllDaeguAccommodationFromDB();
    }

    @Cacheable(value = "daeguRestaurantCache", key = "'restaurant-all'")
    public List<DaeguRestaurantDto> getAllDaeguRestaurantFromCache() {
        log.info("Cache miss: Fetching Daegu Restaurant data from DB");
        return getAllDaeguRestaurantFromDB();
    }


    public List<DaeguAccommodationDto> getAllDaeguAccommodationFromDB() {
        List<DaeguAccommodationDto> allData = new ArrayList<>();
        int page = 0;
        List<DaeguAccommodationDto> currentPage;

        do {
            Pageable pageable = PageRequest.of(page, PAGE_SIZE);
            currentPage = daeguAccommodationRepository.findAll(pageable)
                    .map(entity -> new DaeguAccommodationDto(
                            entity.getId(),
                            entity.getNumber(),
                            entity.getIndustryClassification(),
                            entity.getGuestMistakeStard(),
                            entity.getGuestMistakeCount(),
                            entity.getPhoneNumber(),
                            entity.getGuestMistakeOneRoom(),
                            entity.getGuestMistakeDeluxe(),
                            entity.getLocation(),
                            entity.getRegion(),
                            entity.getGuestMistakeSuite(),
                            entity.getGuestMistakeOther(),
                            entity.getHotelName()
                    )).getContent();
            allData.addAll(currentPage);
            page++;
        } while (!currentPage.isEmpty());

        return allData;
    }

    public List<DaeguTourismDto> getAllDaeguTourismFromDB() {
        List<DaeguTourismDto> allData = new ArrayList<>();
        int page = 0;
        List<DaeguTourismDto> currentPage;

        do {
            Pageable pageable = PageRequest.of(page, PAGE_SIZE);
            currentPage = daeguTourismRepository.findAll(pageable)
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
                    )).getContent();
            allData.addAll(currentPage);
            page++;
        } while (!currentPage.isEmpty());

        return allData;
    }

    public List<DaeguRestaurantDto> getAllDaeguRestaurantFromDB() {
        List<DaeguRestaurantDto> allData = new ArrayList<>();
        int page = 0;
        List<DaeguRestaurantDto> currentPage;

        do {
            Pageable pageable = PageRequest.of(page, PAGE_SIZE);
            currentPage = daeguRestaurantRepository.findAll(pageable)
                    .map(entity -> new DaeguRestaurantDto(
                            entity.getId(),
                            entity.getNumber(),
                            entity.getBusinessName(),
                            entity.getBusinessStatus(),
                            entity.getBusinessAddress()
                    )).getContent();
            allData.addAll(currentPage);
            page++;
        } while (!currentPage.isEmpty());

        return allData;
    }
}

