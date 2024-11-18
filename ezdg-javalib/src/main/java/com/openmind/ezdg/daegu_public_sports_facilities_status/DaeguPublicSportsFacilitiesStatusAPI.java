package com.openmind.ezdg.daegu_public_sports_facilities_status;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;

public class DaeguPublicSportsFacilitiesStatusAPI extends AbstractAPI<DaeguPublicSportsFacilitiesStatus> {

    public DaeguPublicSportsFacilitiesStatusAPI() {
        super("/daegu_public_sports_facilities_status");
    }

    public DaeguPublicSportsFacilitiesStatusAPI page(int page) {
        return (DaeguPublicSportsFacilitiesStatusAPI) super.page(page);
    }

    public DaeguPublicSportsFacilitiesStatusAPI perPage(int perPage) {
        return (DaeguPublicSportsFacilitiesStatusAPI) super.perPage(perPage);
    }

    public DaeguPublicSportsFacilitiesStatusAPI facilityName(String facilityName) {
        uriBuilder.setParameter("facilityName", String.valueOf(facilityName));
        return this;
    }

    public DaeguPublicSportsFacilitiesStatusAPI facilityNameContaining(String facilityName) {
        uriBuilder.setParameter("facilityNameContaining", facilityName);
        return this;
    }

    public DaeguPublicSportsFacilitiesStatusAPI managementEntity(String managementEntity) {
        uriBuilder.setParameter("managementEntity", String.valueOf(managementEntity));
        return this;
    }

    public DaeguPublicSportsFacilitiesStatusAPI managementEntityContaining(String managementEntity) {
        uriBuilder.setParameter("managementEntityContaining", managementEntity);
        return this;
    }

    public DaeguPublicSportsFacilitiesStatusAPI siteArea(String siteArea) {
        uriBuilder.setParameter("siteArea", String.valueOf(siteArea));
        return this;
    }

    public DaeguPublicSportsFacilitiesStatusAPI siteAreaContaining(String siteArea) {
        uriBuilder.setParameter("siteAreaContaining", siteArea);
        return this;
    }

    public DaeguPublicSportsFacilitiesStatusAPI numberOfSeats(String numberOfSeats) {
        uriBuilder.setParameter("numberOfSeats", String.valueOf(numberOfSeats));
        return this;
    }

    public DaeguPublicSportsFacilitiesStatusAPI numberOfSeatsContaining(String numberOfSeats) {
        uriBuilder.setParameter("numberOfSeatsContaining", numberOfSeats);
        return this;
    }

    public DaeguPublicSportsFacilitiesStatusAPI numberOfPeople(String numberOfPeople) {
        uriBuilder.setParameter("numberOfPeople", String.valueOf(numberOfPeople));
        return this;
    }

    public DaeguPublicSportsFacilitiesStatusAPI numberOfPeopleContaining(String numberOfPeople) {
        uriBuilder.setParameter("numberOfPeopleContaining", numberOfPeople);
        return this;
    }

    public DaeguPublicSportsFacilitiesStatusAPI completionYear(Long completionYear) {
        uriBuilder.setParameter("completionYear", String.valueOf(completionYear));
        return this;
    }

    public DaeguPublicSportsFacilitiesStatusAPI completionYearLt(Long completionYearLt) {
        uriBuilder.setParameter("completionYearLt", String.valueOf(completionYearLt));
        return this;
    }

    public DaeguPublicSportsFacilitiesStatusAPI completionYearLte(Long completionYearLte) {
        uriBuilder.setParameter("completionYearLte", String.valueOf(completionYearLte));
        return this;
    }

    public DaeguPublicSportsFacilitiesStatusAPI completionYearGt(Long completionYearGt) {
        uriBuilder.setParameter("completionYearGt", String.valueOf(completionYearGt));
        return this;
    }

    public DaeguPublicSportsFacilitiesStatusAPI completionYearGte(Long completionYearGte) {
        uriBuilder.setParameter("completionYearGte", String.valueOf(completionYearGte));
        return this;
    }
}