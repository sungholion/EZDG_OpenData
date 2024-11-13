package com.daegu.travel.service;

import com.daegu.travel.dto.DaeguMetropolitanCityRestaurantRegistrationStatusDto;
import com.daegu.travel.dto.DaeguMetropolitanCityStatusOfTourismAccommodationBusinessDto;
import com.daegu.travel.dto.DaeguTourismCourseInformationDto;
import com.daegu.travel.entity.DaeguMetropolitanCityRestaurantRegistrationStatusEntity;
import com.daegu.travel.entity.DaeguMetropolitanCityStatusOfTourismAccommodationBusinessEntity;
import com.daegu.travel.entity.DaeguTourismCourseInformationEntity;
import com.daegu.travel.repository.DaeguMetropolitanCityRestaurantRegistrationStatusRepository;
import com.daegu.travel.repository.DaeguMetropolitanCityStatusOfTourismAccommodationBusinessRepository;
import com.daegu.travel.repository.DaeguTourismCourseInformationRepository;
import com.openmind.ezdg.daegu_tourism_course_information.DaeguTourismCourseInformation;
import com.openmind.ezdg.daegu_tourism_course_information.DaeguTourismCourseInformationAPI;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

//
@Service
public class DaeguTravelService {

    private static DaeguTourismCourseInformationRepository daeguTourismCourseInformationRepository = null;
    private static DaeguMetropolitanCityStatusOfTourismAccommodationBusinessRepository daeguMetropolitanCityStatusOfTourismBusinessRepository = null;
    private static DaeguMetropolitanCityRestaurantRegistrationStatusRepository daeguMetropolitanCityRestaurantRegistrationStatusRepository = null;

    public DaeguTravelService(DaeguTourismCourseInformationRepository daeguTourismCourseInformationRepository,
                              DaeguMetropolitanCityStatusOfTourismAccommodationBusinessRepository daeguMetropolitanCityStatusOfTourismBusinessRepository,
                              DaeguMetropolitanCityRestaurantRegistrationStatusRepository daeguRestaurantRepository) {
        DaeguTravelService.daeguTourismCourseInformationRepository = daeguTourismCourseInformationRepository;
        DaeguTravelService.daeguMetropolitanCityStatusOfTourismBusinessRepository = daeguMetropolitanCityStatusOfTourismBusinessRepository;
        DaeguTravelService.daeguMetropolitanCityRestaurantRegistrationStatusRepository = daeguRestaurantRepository;
    }

    public static List<DaeguTourismCourseInformation> getAllDaeguTourismCourseInformationForAPI() throws URISyntaxException, IOException {
        DaeguTourismCourseInformationAPI api = new DaeguTourismCourseInformationAPI();

        return api.fetch();
    }

    public static List<DaeguTourismCourseInformationDto> getAllDaeguTourismCourseInformationForDB() {
        List<DaeguTourismCourseInformationEntity> entities = daeguTourismCourseInformationRepository.findAll();
        return entities.stream()
                .map(entity -> new DaeguTourismCourseInformationDto(
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

    public static List<DaeguMetropolitanCityStatusOfTourismAccommodationBusinessDto> getAllDaeguMetropolitanCityStatusOfTourismAccommodationBusinessForDB(){
        List<DaeguMetropolitanCityStatusOfTourismAccommodationBusinessEntity> entities = daeguMetropolitanCityStatusOfTourismBusinessRepository.findAll();
        return entities.stream()
                .map(entity -> new DaeguMetropolitanCityStatusOfTourismAccommodationBusinessDto(
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

    public static List<DaeguMetropolitanCityRestaurantRegistrationStatusDto> getAllDaeguMetropolitanCityRestaurantRegistrationStatusForDB() {
        List<DaeguMetropolitanCityRestaurantRegistrationStatusEntity> entities = daeguMetropolitanCityRestaurantRegistrationStatusRepository.findAll();
        return entities.stream()
                .map(entity -> new DaeguMetropolitanCityRestaurantRegistrationStatusDto(
                        entity.getId(),
                        entity.getNumber(),
                        entity.getBusinessName(),
                        entity.getBusinessStatus(),
                        entity.getBusinessAddress()
                ))
                .collect(Collectors.toList());
    }
}
