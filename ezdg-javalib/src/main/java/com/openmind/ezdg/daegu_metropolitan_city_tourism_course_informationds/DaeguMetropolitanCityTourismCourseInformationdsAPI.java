package com.openmind.ezdg.daegu_metropolitan_city_tourism_course_informationds;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DaeguMetropolitanCityTourismCourseInformationdsAPI extends AbstractAPI<DaeguMetropolitanCityTourismCourseInformationds> {

    public DaeguMetropolitanCityTourismCourseInformationdsAPI() {
        super("/daegu_metropolitan_city_tourism_course_informationds");
    }

    public DaeguMetropolitanCityTourismCourseInformationdsAPI classification(String classification) {
        uriBuilder.setParameter("classification", String.valueOf(classification));
        return this;
    }

    public DaeguMetropolitanCityTourismCourseInformationdsAPI classificationContaining(String classification) {
        uriBuilder.setParameter("classificationContaining", classification);
        return this;
    }

    public DaeguMetropolitanCityTourismCourseInformationdsAPI courseTitle(String courseTitle) {
        uriBuilder.setParameter("courseTitle", String.valueOf(courseTitle));
        return this;
    }

    public DaeguMetropolitanCityTourismCourseInformationdsAPI courseTitleContaining(String courseTitle) {
        uriBuilder.setParameter("courseTitleContaining", courseTitle);
        return this;
    }

    public DaeguMetropolitanCityTourismCourseInformationdsAPI courseNumber(Long courseNumber) {
        uriBuilder.setParameter("courseNumber", String.valueOf(courseNumber));
        return this;
    }

    public DaeguMetropolitanCityTourismCourseInformationdsAPI courseNumberLt(Long courseNumberLt) {
        uriBuilder.setParameter("courseNumberLt", String.valueOf(courseNumberLt));
        return this;
    }

    public DaeguMetropolitanCityTourismCourseInformationdsAPI courseNumberLte(Long courseNumberLte) {
        uriBuilder.setParameter("courseNumberLte", String.valueOf(courseNumberLte));
        return this;
    }

    public DaeguMetropolitanCityTourismCourseInformationdsAPI courseNumberGt(Long courseNumberGt) {
        uriBuilder.setParameter("courseNumberGt", String.valueOf(courseNumberGt));
        return this;
    }

    public DaeguMetropolitanCityTourismCourseInformationdsAPI courseNumberGte(Long courseNumberGte) {
        uriBuilder.setParameter("courseNumberGte", String.valueOf(courseNumberGte));
        return this;
    }
    public DaeguMetropolitanCityTourismCourseInformationdsAPI courseTopic(String courseTopic) {
        uriBuilder.setParameter("courseTopic", String.valueOf(courseTopic));
        return this;
    }

    public DaeguMetropolitanCityTourismCourseInformationdsAPI courseTopicContaining(String courseTopic) {
        uriBuilder.setParameter("courseTopicContaining", courseTopic);
        return this;
    }

    public DaeguMetropolitanCityTourismCourseInformationdsAPI courseTopicDescription(String courseTopicDescription) {
        uriBuilder.setParameter("courseTopicDescription", String.valueOf(courseTopicDescription));
        return this;
    }

    public DaeguMetropolitanCityTourismCourseInformationdsAPI courseTopicDescriptionContaining(String courseTopicDescription) {
        uriBuilder.setParameter("courseTopicDescriptionContaining", courseTopicDescription);
        return this;
    }

    public DaeguMetropolitanCityTourismCourseInformationdsAPI region(String region) {
        uriBuilder.setParameter("region", String.valueOf(region));
        return this;
    }

    public DaeguMetropolitanCityTourismCourseInformationdsAPI regionContaining(String region) {
        uriBuilder.setParameter("regionContaining", region);
        return this;
    }

    public DaeguMetropolitanCityTourismCourseInformationdsAPI touristDestination(String touristDestination) {
        uriBuilder.setParameter("touristDestination", String.valueOf(touristDestination));
        return this;
    }

    public DaeguMetropolitanCityTourismCourseInformationdsAPI touristDestinationContaining(String touristDestination) {
        uriBuilder.setParameter("touristDestinationContaining", touristDestination);
        return this;
    }

    public DaeguMetropolitanCityTourismCourseInformationdsAPI courseDescription(String courseDescription) {
        uriBuilder.setParameter("courseDescription", String.valueOf(courseDescription));
        return this;
    }

    public DaeguMetropolitanCityTourismCourseInformationdsAPI courseDescriptionContaining(String courseDescription) {
        uriBuilder.setParameter("courseDescriptionContaining", courseDescription);
        return this;
    }

    public DaeguMetropolitanCityTourismCourseInformationdsAPI address(String address) {
        uriBuilder.setParameter("address", String.valueOf(address));
        return this;
    }

    public DaeguMetropolitanCityTourismCourseInformationdsAPI addressContaining(String address) {
        uriBuilder.setParameter("addressContaining", address);
        return this;
    }

    public DaeguMetropolitanCityTourismCourseInformationdsAPI phoneNumber(String phoneNumber) {
        uriBuilder.setParameter("phoneNumber", String.valueOf(phoneNumber));
        return this;
    }

    public DaeguMetropolitanCityTourismCourseInformationdsAPI phoneNumberContaining(String phoneNumber) {
        uriBuilder.setParameter("phoneNumberContaining", phoneNumber);
        return this;
    }

    public DaeguMetropolitanCityTourismCourseInformationdsAPI homepage(String homepage) {
        uriBuilder.setParameter("homepage", String.valueOf(homepage));
        return this;
    }

    public DaeguMetropolitanCityTourismCourseInformationdsAPI homepageContaining(String homepage) {
        uriBuilder.setParameter("homepageContaining", homepage);
        return this;
    }

}