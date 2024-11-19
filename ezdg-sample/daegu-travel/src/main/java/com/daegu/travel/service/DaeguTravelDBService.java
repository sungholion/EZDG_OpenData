package com.daegu.travel.service;

import com.daegu.travel.dto.DaeguAccommodationDto;
import com.daegu.travel.dto.DaeguRestaurantDto;
import com.daegu.travel.dto.DaeguTourismDto;
import com.daegu.travel.entity.DaeguRestaurantEntity;
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

    public List<DaeguRestaurantDto> getAllDaeguRestaurantFromCache() {
        String[] regions = {"중구", "동구", "서구", "남구", "북구", "수성구", "달서구", "달성군", "군위군"};
        List<DaeguRestaurantDto> allData = new ArrayList<>();

        for (String region : regions) {
            allData.addAll(getRegionDataFromCache(region));
        }

        return allData;
    }

    @Cacheable(value = "daeguRestaurantCache", key = "'restaurant-' + #region")
    public List<DaeguRestaurantDto> getRegionDataFromCache(String region) {
        log.info("Cache miss for region: {}", region);
        return getRegionDataFromDB(region);
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
        String[] regions = {"중구", "동구", "서구", "남구", "북구", "수성구", "달서구", "달성군", "군위군"};
        List<DaeguRestaurantDto> allData = new ArrayList<>();
        int maxItemsPerRegion = 20; // 각 지역별 최대 20개

        for (String region : regions) {
            List<DaeguRestaurantEntity> regionEntities = daeguRestaurantRepository.findTopByRegion(region, maxItemsPerRegion);
            allData.addAll(regionEntities.stream()
                    .map(entity -> new DaeguRestaurantDto(
                            entity.getId(),
                            entity.getNumber(),
                            entity.getBusinessName(),
                            entity.getBusinessStatus(),
                            entity.getBusinessAddress()
                    ))
                    .toList());
        }

        return allData;
    }

    private List<DaeguRestaurantDto> getRegionDataFromDB(String region) {
        int maxItemsPerRegion = 20; // 지역별 최대 데이터 수
        List<DaeguRestaurantEntity> regionEntities = daeguRestaurantRepository.findTopByRegion(region, maxItemsPerRegion);
        return regionEntities.stream()
                .map(entity -> new DaeguRestaurantDto(
                        entity.getId(),
                        entity.getNumber(),
                        entity.getBusinessName(),
                        entity.getBusinessStatus(),
                        entity.getBusinessAddress()
                ))
                .toList();
    }




//    public List<DaeguRestaurantDto> getAllDaeguRestaurantFromDB() {
//        String[] regions = {"중구", "동구", "서구", "남구", "북구", "수성구", "달서구", "달성군", "군위군"};
//        List<DaeguRestaurantDto> allData = new ArrayList<>();
//        int size = 10; // 페이지당 가져올 개수
//        int maxPages = 3; // 최대 3페이지만 가져오기
//        int maxItemsPerRegion = 20; // 각 지역별 최대 30개
//
//        // 각 지역별로 데이터를 조회하여 수집
//        for (String region : regions) {
//            int page = 0;
//            List<DaeguRestaurantDto> pageData;
//            List<DaeguRestaurantDto> regionData = new ArrayList<>();
//
//            // 페이지별로 데이터를 가져와 추가 (최대 3페이지, 최대 30개)
//            do {
//                Pageable pageable = PageRequest.of(page, size);
//                pageData = daeguRestaurantRepository.findByBusinessAddressContaining(region, pageable)
//                        .map(entity -> new DaeguRestaurantDto(
//                                entity.getId(),
//                                entity.getNumber(),
//                                entity.getBusinessName(),
//                                entity.getBusinessStatus(),
//                                entity.getBusinessAddress()
//                        )).getContent();
//
//                regionData.addAll(pageData);
//                page++;
//
//            } while (!pageData.isEmpty() && page < maxPages && regionData.size() < maxItemsPerRegion);
//
//            // 최대 30개까지 데이터를 잘라서 추가
//            allData.addAll(regionData.subList(0, Math.min(regionData.size(), maxItemsPerRegion)));
//        }
//
//        return allData;
//    }


}

