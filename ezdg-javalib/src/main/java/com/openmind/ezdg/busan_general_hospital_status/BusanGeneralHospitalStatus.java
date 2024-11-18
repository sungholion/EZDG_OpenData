package com.openmind.ezdg.busan_general_hospital_status;

import java.time.LocalDate;

public class BusanGeneralHospitalStatus {

    private Long number;
    private String nameOfMedicalInstitution;
    private String representative;
    private String roadNameAddress;
    private Double longitude;
    private Double latitude;
    private String phoneNumber;
    private Long system;
    private Long general;
    private Long spirit;
    private LocalDate authorizationDate;

    // Getters and Setters
    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getNameOfMedicalInstitution() {
        return nameOfMedicalInstitution;
    }

    public void setNameOfMedicalInstitution(String nameOfMedicalInstitution) {
        this.nameOfMedicalInstitution = nameOfMedicalInstitution;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public String getRoadNameAddress() {
        return roadNameAddress;
    }

    public void setRoadNameAddress(String roadNameAddress) {
        this.roadNameAddress = roadNameAddress;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getSystem() {
        return system;
    }

    public void setSystem(Long system) {
        this.system = system;
    }

    public Long getGeneral() {
        return general;
    }

    public void setGeneral(Long general) {
        this.general = general;
    }

    public Long getSpirit() {
        return spirit;
    }

    public void setSpirit(Long spirit) {
        this.spirit = spirit;
    }

    public LocalDate getAuthorizationDate() {
        return authorizationDate;
    }

    public void setAuthorizationDate(LocalDate authorizationDate) {
        this.authorizationDate = authorizationDate;
    }

}
