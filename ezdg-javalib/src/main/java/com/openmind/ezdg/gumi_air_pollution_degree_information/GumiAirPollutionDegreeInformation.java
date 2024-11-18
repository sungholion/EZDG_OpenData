package com.openmind.ezdg.gumi_air_pollution_degree_information;

import java.time.LocalDate;

public class GumiAirPollutionDegreeInformation {

    private LocalDate yearMonth;
    private String location;
    private Double sulfurDioxide;
    private Double nitrogenDioxide;
    private Double carbonMonoxide;
    private Double ozone;
    private Long fineDustTen;
    private Long fineDustTwentyFive;

    // Getters and Setters
    public LocalDate getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(LocalDate yearMonth) {
        this.yearMonth = yearMonth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getSulfurDioxide() {
        return sulfurDioxide;
    }

    public void setSulfurDioxide(Double sulfurDioxide) {
        this.sulfurDioxide = sulfurDioxide;
    }

    public Double getNitrogenDioxide() {
        return nitrogenDioxide;
    }

    public void setNitrogenDioxide(Double nitrogenDioxide) {
        this.nitrogenDioxide = nitrogenDioxide;
    }

    public Double getCarbonMonoxide() {
        return carbonMonoxide;
    }

    public void setCarbonMonoxide(Double carbonMonoxide) {
        this.carbonMonoxide = carbonMonoxide;
    }

    public Double getOzone() {
        return ozone;
    }

    public void setOzone(Double ozone) {
        this.ozone = ozone;
    }

    public Long getFineDustTen() {
        return fineDustTen;
    }

    public void setFineDustTen(Long fineDustTen) {
        this.fineDustTen = fineDustTen;
    }

    public Long getFineDustTwentyFive() {
        return fineDustTwentyFive;
    }

    public void setFineDustTwentyFive(Long fineDustTwentyFive) {
        this.fineDustTwentyFive = fineDustTwentyFive;
    }

}
