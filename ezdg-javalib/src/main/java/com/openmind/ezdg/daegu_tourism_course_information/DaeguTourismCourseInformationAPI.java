package com.openmind.ezdg.daegu_tourism_course_information;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DaeguTourismCourseInformationAPI extends AbstractAPI<DaeguTourismCourseInformation> {

    public DaeguTourismCourseInformationAPI() {
        super("/daegu_tourism_course_information");
    }

    public DaeguTourismCourseInformationAPI classification(String classification) {
        uriBuilder.setParameter("classification", String.valueOf(classification));
        return this;
    }

    public DaeguTourismCourseInformationAPI classificationContaining(String classification) {
        uriBuilder.setParameter("classificationContaining", classification);
        return this;
    }

    public DaeguTourismCourseInformationAPI courseTitle(String courseTitle) {
        uriBuilder.setParameter("courseTitle", String.valueOf(courseTitle));
        return this;
    }

    public DaeguTourismCourseInformationAPI courseTitleContaining(String courseTitle) {
        uriBuilder.setParameter("courseTitleContaining", courseTitle);
        return this;
    }

    public DaeguTourismCourseInformationAPI courseNumber(Long courseNumber) {
        uriBuilder.setParameter("courseNumber", String.valueOf(courseNumber));
        return this;
    }

    public DaeguTourismCourseInformationAPI courseNumberLt(Long courseNumberLt) {
        uriBuilder.setParameter("courseNumberLt", String.valueOf(courseNumberLt));
        return this;
    }

    public DaeguTourismCourseInformationAPI courseNumberLte(Long courseNumberLte) {
        uriBuilder.setParameter("courseNumberLte", String.valueOf(courseNumberLte));
        return this;
    }

    public DaeguTourismCourseInformationAPI courseNumberGt(Long courseNumberGt) {
        uriBuilder.setParameter("courseNumberGt", String.valueOf(courseNumberGt));
        return this;
    }

    public DaeguTourismCourseInformationAPI courseNumberGte(Long courseNumberGte) {
        uriBuilder.setParameter("courseNumberGte", String.valueOf(courseNumberGte));
        return this;
    }
    public DaeguTourismCourseInformationAPI courseTopic(String courseTopic) {
        uriBuilder.setParameter("courseTopic", String.valueOf(courseTopic));
        return this;
    }

    public DaeguTourismCourseInformationAPI courseTopicContaining(String courseTopic) {
        uriBuilder.setParameter("courseTopicContaining", courseTopic);
        return this;
    }

    public DaeguTourismCourseInformationAPI courseTopicDescription(String courseTopicDescription) {
        uriBuilder.setParameter("courseTopicDescription", String.valueOf(courseTopicDescription));
        return this;
    }

    public DaeguTourismCourseInformationAPI courseTopicDescriptionContaining(String courseTopicDescription) {
        uriBuilder.setParameter("courseTopicDescriptionContaining", courseTopicDescription);
        return this;
    }

    public DaeguTourismCourseInformationAPI region(String region) {
        uriBuilder.setParameter("region", String.valueOf(region));
        return this;
    }

    public DaeguTourismCourseInformationAPI regionContaining(String region) {
        uriBuilder.setParameter("regionContaining", region);
        return this;
    }

    public DaeguTourismCourseInformationAPI touristDestination(String touristDestination) {
        uriBuilder.setParameter("touristDestination", String.valueOf(touristDestination));
        return this;
    }

    public DaeguTourismCourseInformationAPI touristDestinationContaining(String touristDestination) {
        uriBuilder.setParameter("touristDestinationContaining", touristDestination);
        return this;
    }

    public DaeguTourismCourseInformationAPI courseDescription(String courseDescription) {
        uriBuilder.setParameter("courseDescription", String.valueOf(courseDescription));
        return this;
    }

    public DaeguTourismCourseInformationAPI courseDescriptionContaining(String courseDescription) {
        uriBuilder.setParameter("courseDescriptionContaining", courseDescription);
        return this;
    }

    public DaeguTourismCourseInformationAPI address(String address) {
        uriBuilder.setParameter("address", String.valueOf(address));
        return this;
    }

    public DaeguTourismCourseInformationAPI addressContaining(String address) {
        uriBuilder.setParameter("addressContaining", address);
        return this;
    }

    public DaeguTourismCourseInformationAPI phoneNumber(String phoneNumber) {
        uriBuilder.setParameter("phoneNumber", String.valueOf(phoneNumber));
        return this;
    }

    public DaeguTourismCourseInformationAPI phoneNumberContaining(String phoneNumber) {
        uriBuilder.setParameter("phoneNumberContaining", phoneNumber);
        return this;
    }

    public DaeguTourismCourseInformationAPI homepage(String homepage) {
        uriBuilder.setParameter("homepage", String.valueOf(homepage));
        return this;
    }

    public DaeguTourismCourseInformationAPI homepageContaining(String homepage) {
        uriBuilder.setParameter("homepageContaining", homepage);
        return this;
    }

}