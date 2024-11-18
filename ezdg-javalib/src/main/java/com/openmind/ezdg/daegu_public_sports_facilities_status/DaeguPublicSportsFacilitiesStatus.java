package com.openmind.ezdg.daegu_public_sports_facilities_status;


public class DaeguPublicSportsFacilitiesStatus {

    private String facilityName;
    private String managementEntity;
    private String siteArea;
    private String numberOfSeats;
    private String numberOfPeople;
    private Long completionYear;

    // Getters and Setters
    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getManagementEntity() {
        return managementEntity;
    }

    public void setManagementEntity(String managementEntity) {
        this.managementEntity = managementEntity;
    }

    public String getSiteArea() {
        return siteArea;
    }

    public void setSiteArea(String siteArea) {
        this.siteArea = siteArea;
    }

    public String getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(String numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(String numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Long getCompletionYear() {
        return completionYear;
    }

    public void setCompletionYear(Long completionYear) {
        this.completionYear = completionYear;
    }

}
