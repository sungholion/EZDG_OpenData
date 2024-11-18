package com.openmind.ezdg.daegu_tourism;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;

public class DaeguTourismAPI extends AbstractAPI<DaeguTourism> {

    public DaeguTourismAPI() {
        super("/daegu_tourism");
    }

    public DaeguTourismAPI page(int page) {
        return (DaeguTourismAPI) super.page(page);
    }

    public DaeguTourismAPI perPage(int perPage) {
        return (DaeguTourismAPI) super.perPage(perPage);
    }

    public DaeguTourismAPI classification(String classification) {
        uriBuilder.setParameter("classification", String.valueOf(classification));
        return this;
    }

    public DaeguTourismAPI classificationContaining(String classification) {
        uriBuilder.setParameter("classificationContaining", classification);
        return this;
    }

    public DaeguTourismAPI courseTitle(String courseTitle) {
        uriBuilder.setParameter("courseTitle", String.valueOf(courseTitle));
        return this;
    }

    public DaeguTourismAPI courseTitleContaining(String courseTitle) {
        uriBuilder.setParameter("courseTitleContaining", courseTitle);
        return this;
    }

    public DaeguTourismAPI courseNumber(Long courseNumber) {
        uriBuilder.setParameter("courseNumber", String.valueOf(courseNumber));
        return this;
    }

    public DaeguTourismAPI courseNumberLt(Long courseNumberLt) {
        uriBuilder.setParameter("courseNumberLt", String.valueOf(courseNumberLt));
        return this;
    }

    public DaeguTourismAPI courseNumberLte(Long courseNumberLte) {
        uriBuilder.setParameter("courseNumberLte", String.valueOf(courseNumberLte));
        return this;
    }

    public DaeguTourismAPI courseNumberGt(Long courseNumberGt) {
        uriBuilder.setParameter("courseNumberGt", String.valueOf(courseNumberGt));
        return this;
    }

    public DaeguTourismAPI courseNumberGte(Long courseNumberGte) {
        uriBuilder.setParameter("courseNumberGte", String.valueOf(courseNumberGte));
        return this;
    }
    public DaeguTourismAPI courseTopic(String courseTopic) {
        uriBuilder.setParameter("courseTopic", String.valueOf(courseTopic));
        return this;
    }

    public DaeguTourismAPI courseTopicContaining(String courseTopic) {
        uriBuilder.setParameter("courseTopicContaining", courseTopic);
        return this;
    }

    public DaeguTourismAPI courseTopicDescription(String courseTopicDescription) {
        uriBuilder.setParameter("courseTopicDescription", String.valueOf(courseTopicDescription));
        return this;
    }

    public DaeguTourismAPI courseTopicDescriptionContaining(String courseTopicDescription) {
        uriBuilder.setParameter("courseTopicDescriptionContaining", courseTopicDescription);
        return this;
    }

    public DaeguTourismAPI region(String region) {
        uriBuilder.setParameter("region", String.valueOf(region));
        return this;
    }

    public DaeguTourismAPI regionContaining(String region) {
        uriBuilder.setParameter("regionContaining", region);
        return this;
    }

    public DaeguTourismAPI touristDestination(String touristDestination) {
        uriBuilder.setParameter("touristDestination", String.valueOf(touristDestination));
        return this;
    }

    public DaeguTourismAPI touristDestinationContaining(String touristDestination) {
        uriBuilder.setParameter("touristDestinationContaining", touristDestination);
        return this;
    }

    public DaeguTourismAPI courseDescription(String courseDescription) {
        uriBuilder.setParameter("courseDescription", String.valueOf(courseDescription));
        return this;
    }

    public DaeguTourismAPI courseDescriptionContaining(String courseDescription) {
        uriBuilder.setParameter("courseDescriptionContaining", courseDescription);
        return this;
    }

    public DaeguTourismAPI address(String address) {
        uriBuilder.setParameter("address", String.valueOf(address));
        return this;
    }

    public DaeguTourismAPI addressContaining(String address) {
        uriBuilder.setParameter("addressContaining", address);
        return this;
    }

    public DaeguTourismAPI phoneNumber(String phoneNumber) {
        uriBuilder.setParameter("phoneNumber", String.valueOf(phoneNumber));
        return this;
    }

    public DaeguTourismAPI phoneNumberContaining(String phoneNumber) {
        uriBuilder.setParameter("phoneNumberContaining", phoneNumber);
        return this;
    }

    public DaeguTourismAPI homepage(String homepage) {
        uriBuilder.setParameter("homepage", String.valueOf(homepage));
        return this;
    }

    public DaeguTourismAPI homepageContaining(String homepage) {
        uriBuilder.setParameter("homepageContaining", homepage);
        return this;
    }

}