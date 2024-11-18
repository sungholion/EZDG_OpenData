package com.openmind.ezdg.gumi_population_status;

import java.time.LocalDate;

public class GumiPopulationStatus {

    private String classification;
    private Long numberOfHouseholds;
    private Long line;
    private Long male;
    private Long female;
    private String managementAgencyName;
    private String managementAgencyPhoneNumber;
    private LocalDate dataBaseDate;

    // Getters and Setters
    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public Long getNumberOfHouseholds() {
        return numberOfHouseholds;
    }

    public void setNumberOfHouseholds(Long numberOfHouseholds) {
        this.numberOfHouseholds = numberOfHouseholds;
    }

    public Long getLine() {
        return line;
    }

    public void setLine(Long line) {
        this.line = line;
    }

    public Long getMale() {
        return male;
    }

    public void setMale(Long male) {
        this.male = male;
    }

    public Long getFemale() {
        return female;
    }

    public void setFemale(Long female) {
        this.female = female;
    }

    public String getManagementAgencyName() {
        return managementAgencyName;
    }

    public void setManagementAgencyName(String managementAgencyName) {
        this.managementAgencyName = managementAgencyName;
    }

    public String getManagementAgencyPhoneNumber() {
        return managementAgencyPhoneNumber;
    }

    public void setManagementAgencyPhoneNumber(String managementAgencyPhoneNumber) {
        this.managementAgencyPhoneNumber = managementAgencyPhoneNumber;
    }

    public LocalDate getDataBaseDate() {
        return dataBaseDate;
    }

    public void setDataBaseDate(LocalDate dataBaseDate) {
        this.dataBaseDate = dataBaseDate;
    }

}
