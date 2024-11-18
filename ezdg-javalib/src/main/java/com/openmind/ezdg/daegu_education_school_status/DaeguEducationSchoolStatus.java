package com.openmind.ezdg.daegu_education_school_status;


public class DaeguEducationSchoolStatus {

    private String schoolName;
    private String districtCountyOffice;
    private String address;
    private Long postcode;
    private String phoneNumber;
    private String faxNumber;

    // Getters and Setters
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getDistrictCountyOffice() {
        return districtCountyOffice;
    }

    public void setDistrictCountyOffice(String districtCountyOffice) {
        this.districtCountyOffice = districtCountyOffice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPostcode() {
        return postcode;
    }

    public void setPostcode(Long postcode) {
        this.postcode = postcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

}
