package com.openmind.ezdg.daegu_accommodation;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;

public class DaeguAccommodationAPI extends AbstractAPI<DaeguAccommodation> {

    public DaeguAccommodationAPI() {
        super("/daegu_accommodation");
    }

    public DaeguAccommodationAPI page(int page) {
        return (DaeguAccommodationAPI) super.page(page);
    }

    public DaeguAccommodationAPI perPage(int perPage) {
        return (DaeguAccommodationAPI) super.perPage(perPage);
    }

    public DaeguAccommodationAPI number(Long number) {
        uriBuilder.setParameter("number", String.valueOf(number));
        return this;
    }

    public DaeguAccommodationAPI numberLt(Long numberLt) {
        uriBuilder.setParameter("numberLt", String.valueOf(numberLt));
        return this;
    }

    public DaeguAccommodationAPI numberLte(Long numberLte) {
        uriBuilder.setParameter("numberLte", String.valueOf(numberLte));
        return this;
    }

    public DaeguAccommodationAPI numberGt(Long numberGt) {
        uriBuilder.setParameter("numberGt", String.valueOf(numberGt));
        return this;
    }

    public DaeguAccommodationAPI numberGte(Long numberGte) {
        uriBuilder.setParameter("numberGte", String.valueOf(numberGte));
        return this;
    }
    public DaeguAccommodationAPI region(String region) {
        uriBuilder.setParameter("region", String.valueOf(region));
        return this;
    }

    public DaeguAccommodationAPI regionContaining(String region) {
        uriBuilder.setParameter("regionContaining", region);
        return this;
    }

    public DaeguAccommodationAPI industryClassification(String industryClassification) {
        uriBuilder.setParameter("industryClassification", String.valueOf(industryClassification));
        return this;
    }

    public DaeguAccommodationAPI industryClassificationContaining(String industryClassification) {
        uriBuilder.setParameter("industryClassificationContaining", industryClassification);
        return this;
    }

    public DaeguAccommodationAPI hotelName(String hotelName) {
        uriBuilder.setParameter("hotelName", String.valueOf(hotelName));
        return this;
    }

    public DaeguAccommodationAPI hotelNameContaining(String hotelName) {
        uriBuilder.setParameter("hotelNameContaining", hotelName);
        return this;
    }

    public DaeguAccommodationAPI guestMistakeStard(Long guestMistakeStard) {
        uriBuilder.setParameter("guestMistakeStard", String.valueOf(guestMistakeStard));
        return this;
    }

    public DaeguAccommodationAPI guestMistakeStardLt(Long guestMistakeStardLt) {
        uriBuilder.setParameter("guestMistakeStardLt", String.valueOf(guestMistakeStardLt));
        return this;
    }

    public DaeguAccommodationAPI guestMistakeStardLte(Long guestMistakeStardLte) {
        uriBuilder.setParameter("guestMistakeStardLte", String.valueOf(guestMistakeStardLte));
        return this;
    }

    public DaeguAccommodationAPI guestMistakeStardGt(Long guestMistakeStardGt) {
        uriBuilder.setParameter("guestMistakeStardGt", String.valueOf(guestMistakeStardGt));
        return this;
    }

    public DaeguAccommodationAPI guestMistakeStardGte(Long guestMistakeStardGte) {
        uriBuilder.setParameter("guestMistakeStardGte", String.valueOf(guestMistakeStardGte));
        return this;
    }
    public DaeguAccommodationAPI guestMistakeDeluxe(Long guestMistakeDeluxe) {
        uriBuilder.setParameter("guestMistakeDeluxe", String.valueOf(guestMistakeDeluxe));
        return this;
    }

    public DaeguAccommodationAPI guestMistakeDeluxeLt(Long guestMistakeDeluxeLt) {
        uriBuilder.setParameter("guestMistakeDeluxeLt", String.valueOf(guestMistakeDeluxeLt));
        return this;
    }

    public DaeguAccommodationAPI guestMistakeDeluxeLte(Long guestMistakeDeluxeLte) {
        uriBuilder.setParameter("guestMistakeDeluxeLte", String.valueOf(guestMistakeDeluxeLte));
        return this;
    }

    public DaeguAccommodationAPI guestMistakeDeluxeGt(Long guestMistakeDeluxeGt) {
        uriBuilder.setParameter("guestMistakeDeluxeGt", String.valueOf(guestMistakeDeluxeGt));
        return this;
    }

    public DaeguAccommodationAPI guestMistakeDeluxeGte(Long guestMistakeDeluxeGte) {
        uriBuilder.setParameter("guestMistakeDeluxeGte", String.valueOf(guestMistakeDeluxeGte));
        return this;
    }
    public DaeguAccommodationAPI guestMistakeSuite(Long guestMistakeSuite) {
        uriBuilder.setParameter("guestMistakeSuite", String.valueOf(guestMistakeSuite));
        return this;
    }

    public DaeguAccommodationAPI guestMistakeSuiteLt(Long guestMistakeSuiteLt) {
        uriBuilder.setParameter("guestMistakeSuiteLt", String.valueOf(guestMistakeSuiteLt));
        return this;
    }

    public DaeguAccommodationAPI guestMistakeSuiteLte(Long guestMistakeSuiteLte) {
        uriBuilder.setParameter("guestMistakeSuiteLte", String.valueOf(guestMistakeSuiteLte));
        return this;
    }

    public DaeguAccommodationAPI guestMistakeSuiteGt(Long guestMistakeSuiteGt) {
        uriBuilder.setParameter("guestMistakeSuiteGt", String.valueOf(guestMistakeSuiteGt));
        return this;
    }

    public DaeguAccommodationAPI guestMistakeSuiteGte(Long guestMistakeSuiteGte) {
        uriBuilder.setParameter("guestMistakeSuiteGte", String.valueOf(guestMistakeSuiteGte));
        return this;
    }
    public DaeguAccommodationAPI guestMistakeOneRoom(Long guestMistakeOneRoom) {
        uriBuilder.setParameter("guestMistakeOneRoom", String.valueOf(guestMistakeOneRoom));
        return this;
    }

    public DaeguAccommodationAPI guestMistakeOneRoomLt(Long guestMistakeOneRoomLt) {
        uriBuilder.setParameter("guestMistakeOneRoomLt", String.valueOf(guestMistakeOneRoomLt));
        return this;
    }

    public DaeguAccommodationAPI guestMistakeOneRoomLte(Long guestMistakeOneRoomLte) {
        uriBuilder.setParameter("guestMistakeOneRoomLte", String.valueOf(guestMistakeOneRoomLte));
        return this;
    }

    public DaeguAccommodationAPI guestMistakeOneRoomGt(Long guestMistakeOneRoomGt) {
        uriBuilder.setParameter("guestMistakeOneRoomGt", String.valueOf(guestMistakeOneRoomGt));
        return this;
    }

    public DaeguAccommodationAPI guestMistakeOneRoomGte(Long guestMistakeOneRoomGte) {
        uriBuilder.setParameter("guestMistakeOneRoomGte", String.valueOf(guestMistakeOneRoomGte));
        return this;
    }
    public DaeguAccommodationAPI guestMistakeOther(String guestMistakeOther) {
        uriBuilder.setParameter("guestMistakeOther", String.valueOf(guestMistakeOther));
        return this;
    }

    public DaeguAccommodationAPI guestMistakeOtherContaining(String guestMistakeOther) {
        uriBuilder.setParameter("guestMistakeOtherContaining", guestMistakeOther);
        return this;
    }

    public DaeguAccommodationAPI guestMistakeCount(Long guestMistakeCount) {
        uriBuilder.setParameter("guestMistakeCount", String.valueOf(guestMistakeCount));
        return this;
    }

    public DaeguAccommodationAPI guestMistakeCountLt(Long guestMistakeCountLt) {
        uriBuilder.setParameter("guestMistakeCountLt", String.valueOf(guestMistakeCountLt));
        return this;
    }

    public DaeguAccommodationAPI guestMistakeCountLte(Long guestMistakeCountLte) {
        uriBuilder.setParameter("guestMistakeCountLte", String.valueOf(guestMistakeCountLte));
        return this;
    }

    public DaeguAccommodationAPI guestMistakeCountGt(Long guestMistakeCountGt) {
        uriBuilder.setParameter("guestMistakeCountGt", String.valueOf(guestMistakeCountGt));
        return this;
    }

    public DaeguAccommodationAPI guestMistakeCountGte(Long guestMistakeCountGte) {
        uriBuilder.setParameter("guestMistakeCountGte", String.valueOf(guestMistakeCountGte));
        return this;
    }
    public DaeguAccommodationAPI location(String location) {
        uriBuilder.setParameter("location", String.valueOf(location));
        return this;
    }

    public DaeguAccommodationAPI locationContaining(String location) {
        uriBuilder.setParameter("locationContaining", location);
        return this;
    }

    public DaeguAccommodationAPI phoneNumber(String phoneNumber) {
        uriBuilder.setParameter("phoneNumber", String.valueOf(phoneNumber));
        return this;
    }

    public DaeguAccommodationAPI phoneNumberContaining(String phoneNumber) {
        uriBuilder.setParameter("phoneNumberContaining", phoneNumber);
        return this;
    }

}