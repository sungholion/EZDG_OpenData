package com.openmind.ezdg.gumi_air_pollution_degree_information;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;

public class GumiAirPollutionDegreeInformationAPI extends AbstractAPI<GumiAirPollutionDegreeInformation> {

    public GumiAirPollutionDegreeInformationAPI() {
        super("/gumi_air_pollution_degree_information");
    }

    public GumiAirPollutionDegreeInformationAPI page(int page) {
        return (GumiAirPollutionDegreeInformationAPI) super.page(page);
    }

    public GumiAirPollutionDegreeInformationAPI perPage(int perPage) {
        return (GumiAirPollutionDegreeInformationAPI) super.perPage(perPage);
    }

    public GumiAirPollutionDegreeInformationAPI yearMonth(LocalDate yearMonth) {
        uriBuilder.setParameter("yearMonth", String.valueOf(yearMonth));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI yearMonthAfter(LocalDate yearMonthAfter) {
        uriBuilder.setParameter("yearMonthAfter", yearMonthAfter.toString());
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI yearMonthBefore(LocalDate yearMonthBefore) {
        uriBuilder.setParameter("yearMonthBefore", yearMonthBefore.toString());
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI location(String location) {
        uriBuilder.setParameter("location", String.valueOf(location));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI locationContaining(String location) {
        uriBuilder.setParameter("locationContaining", location);
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI sulfurDioxide(Double sulfurDioxide) {
        uriBuilder.setParameter("sulfurDioxide", String.valueOf(sulfurDioxide));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI sulfurDioxideLt(Double sulfurDioxideLt) {
        uriBuilder.setParameter("sulfurDioxideLt", String.valueOf(sulfurDioxideLt));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI sulfurDioxideLte(Double sulfurDioxideLte) {
        uriBuilder.setParameter("sulfurDioxideLte", String.valueOf(sulfurDioxideLte));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI sulfurDioxideGt(Double sulfurDioxideGt) {
        uriBuilder.setParameter("sulfurDioxideGt", String.valueOf(sulfurDioxideGt));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI sulfurDioxideGte(Double sulfurDioxideGte) {
        uriBuilder.setParameter("sulfurDioxideGte", String.valueOf(sulfurDioxideGte));
        return this;
    }
    public GumiAirPollutionDegreeInformationAPI nitrogenDioxide(Double nitrogenDioxide) {
        uriBuilder.setParameter("nitrogenDioxide", String.valueOf(nitrogenDioxide));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI nitrogenDioxideLt(Double nitrogenDioxideLt) {
        uriBuilder.setParameter("nitrogenDioxideLt", String.valueOf(nitrogenDioxideLt));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI nitrogenDioxideLte(Double nitrogenDioxideLte) {
        uriBuilder.setParameter("nitrogenDioxideLte", String.valueOf(nitrogenDioxideLte));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI nitrogenDioxideGt(Double nitrogenDioxideGt) {
        uriBuilder.setParameter("nitrogenDioxideGt", String.valueOf(nitrogenDioxideGt));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI nitrogenDioxideGte(Double nitrogenDioxideGte) {
        uriBuilder.setParameter("nitrogenDioxideGte", String.valueOf(nitrogenDioxideGte));
        return this;
    }
    public GumiAirPollutionDegreeInformationAPI carbonMonoxide(Double carbonMonoxide) {
        uriBuilder.setParameter("carbonMonoxide", String.valueOf(carbonMonoxide));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI carbonMonoxideLt(Double carbonMonoxideLt) {
        uriBuilder.setParameter("carbonMonoxideLt", String.valueOf(carbonMonoxideLt));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI carbonMonoxideLte(Double carbonMonoxideLte) {
        uriBuilder.setParameter("carbonMonoxideLte", String.valueOf(carbonMonoxideLte));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI carbonMonoxideGt(Double carbonMonoxideGt) {
        uriBuilder.setParameter("carbonMonoxideGt", String.valueOf(carbonMonoxideGt));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI carbonMonoxideGte(Double carbonMonoxideGte) {
        uriBuilder.setParameter("carbonMonoxideGte", String.valueOf(carbonMonoxideGte));
        return this;
    }
    public GumiAirPollutionDegreeInformationAPI ozone(Double ozone) {
        uriBuilder.setParameter("ozone", String.valueOf(ozone));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI ozoneLt(Double ozoneLt) {
        uriBuilder.setParameter("ozoneLt", String.valueOf(ozoneLt));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI ozoneLte(Double ozoneLte) {
        uriBuilder.setParameter("ozoneLte", String.valueOf(ozoneLte));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI ozoneGt(Double ozoneGt) {
        uriBuilder.setParameter("ozoneGt", String.valueOf(ozoneGt));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI ozoneGte(Double ozoneGte) {
        uriBuilder.setParameter("ozoneGte", String.valueOf(ozoneGte));
        return this;
    }
    public GumiAirPollutionDegreeInformationAPI fineDustTen(Long fineDustTen) {
        uriBuilder.setParameter("fineDustTen", String.valueOf(fineDustTen));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI fineDustTenLt(Long fineDustTenLt) {
        uriBuilder.setParameter("fineDustTenLt", String.valueOf(fineDustTenLt));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI fineDustTenLte(Long fineDustTenLte) {
        uriBuilder.setParameter("fineDustTenLte", String.valueOf(fineDustTenLte));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI fineDustTenGt(Long fineDustTenGt) {
        uriBuilder.setParameter("fineDustTenGt", String.valueOf(fineDustTenGt));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI fineDustTenGte(Long fineDustTenGte) {
        uriBuilder.setParameter("fineDustTenGte", String.valueOf(fineDustTenGte));
        return this;
    }
    public GumiAirPollutionDegreeInformationAPI fineDustTwentyFive(Long fineDustTwentyFive) {
        uriBuilder.setParameter("fineDustTwentyFive", String.valueOf(fineDustTwentyFive));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI fineDustTwentyFiveLt(Long fineDustTwentyFiveLt) {
        uriBuilder.setParameter("fineDustTwentyFiveLt", String.valueOf(fineDustTwentyFiveLt));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI fineDustTwentyFiveLte(Long fineDustTwentyFiveLte) {
        uriBuilder.setParameter("fineDustTwentyFiveLte", String.valueOf(fineDustTwentyFiveLte));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI fineDustTwentyFiveGt(Long fineDustTwentyFiveGt) {
        uriBuilder.setParameter("fineDustTwentyFiveGt", String.valueOf(fineDustTwentyFiveGt));
        return this;
    }

    public GumiAirPollutionDegreeInformationAPI fineDustTwentyFiveGte(Long fineDustTwentyFiveGte) {
        uriBuilder.setParameter("fineDustTwentyFiveGte", String.valueOf(fineDustTwentyFiveGte));
        return this;
    }
}