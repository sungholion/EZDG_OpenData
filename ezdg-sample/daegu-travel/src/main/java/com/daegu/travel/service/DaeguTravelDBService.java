package com.daegu.travel.service;

import com.daegu.travel.dto.DaeguAccommodationDto;
import com.daegu.travel.dto.DaeguRestaurantDto;
import com.daegu.travel.dto.DaeguTourismDto;
import com.daegu.travel.repository.DaeguAccommodationRepository;
import com.daegu.travel.repository.DaeguRestaurantRepository;
import com.daegu.travel.repository.DaeguTourismRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    @Cacheable(value = "daeguTourismCache", key = "'tourism-' + #pageable.pageNumber + '-' + #pageable.pageSize")
    public List<DaeguTourismDto> getAllDaeguTourismFromCache(Pageable pageable) {
        log.info("Cache miss: Fetching Daegu Tourism data for key = " + cacheKey(pageable));
        return getAllDaeguTourismFromDB(pageable);
    }

    @Cacheable(value = "daeguAccommodationCache", key = "'accommodation-' + #pageable.pageNumber + '-' + #pageable.pageSize")
    public List<DaeguAccommodationDto> getAllDaeguAccommodationFromCache(Pageable pageable) {
        log.info("Cache miss: Fetching Daegu Accommodation data for key = " + cacheKey(pageable));
        return getAllDaeguAccommodationFromDB(pageable);
    }

    @Cacheable(value = "daeguRestaurantCache", key = "'restaurant-' + #pageable.pageNumber + '-' + #pageable.pageSize")
    public List<DaeguRestaurantDto> getAllDaeguRestaurantFromCache(Pageable pageable) {
        log.info("Cache miss: Fetching Daegu Restaurant data for key = " + cacheKey(pageable));
        return getAllDaeguRestaurantFromDB(pageable);
    }

    private String cacheKey(Pageable pageable) {
        return pageable.getPageNumber() + "-" + pageable.getPageSize();
    }


    public List<DaeguTourismDto> getAllDaeguTourismFromDB(Pageable pageable) {
        return daeguTourismRepository.findAll(pageable)
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
                .getContent(); // Page에서 List만 추출
    }

    public List<DaeguAccommodationDto> getAllDaeguAccommodationFromDB(Pageable pageable) {
        return daeguAccommodationRepository.findAll(pageable)
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
                .getContent(); // Page에서 List만 추출
    }

    public List<DaeguRestaurantDto> getAllDaeguRestaurantFromDB(Pageable pageable) {
        return daeguRestaurantRepository.findAll(pageable)
                .map(entity -> new DaeguRestaurantDto(
                        entity.getId(),
                        entity.getNumber(),
                        entity.getBusinessName(),
                        entity.getBusinessType(),
                        entity.getBusinessAddress()
                ))
                .getContent(); // Page에서 List만 추출
    }


    public List<DaeguTourismDto> getAllDaeguTourismFromDBNoRedis(Pageable pageable) {
        return daeguTourismRepository.findAll(pageable)
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
                .getContent(); // Page에서 List만 추출
    }

    public List<DaeguAccommodationDto> getAllDaeguAccommodationFromDBNoRedis(Pageable pageable){
        return daeguAccommodationRepository.findAll(pageable)
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
                .getContent(); // Page에서 List만 추출
    }

    public List<DaeguRestaurantDto> getAllDaeguRestaurantFromDBNoRedis(Pageable pageable) {
        return daeguRestaurantRepository.findAll(pageable)
                .map(entity -> new DaeguRestaurantDto(
                        entity.getId(),
                        entity.getNumber(),
                        entity.getBusinessName(),
                        entity.getBusinessType(),
                        entity.getBusinessAddress()
                ))
                .getContent(); // Page에서 List만 추출
    }
}

