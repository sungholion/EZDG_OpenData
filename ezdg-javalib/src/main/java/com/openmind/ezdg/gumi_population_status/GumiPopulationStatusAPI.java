package com.openmind.ezdg.gumi_population_status;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;

public class GumiPopulationStatusAPI extends AbstractAPI<GumiPopulationStatus> {

    public GumiPopulationStatusAPI() {
        super("/gumi_population_status");
    }

    public GumiPopulationStatusAPI page(int page) {
        return (GumiPopulationStatusAPI) super.page(page);
    }

    public GumiPopulationStatusAPI perPage(int perPage) {
        return (GumiPopulationStatusAPI) super.perPage(perPage);
    }

    public GumiPopulationStatusAPI classification(String classification) {
        uriBuilder.setParameter("classification", String.valueOf(classification));
        return this;
    }

    public GumiPopulationStatusAPI classificationContaining(String classification) {
        uriBuilder.setParameter("classificationContaining", classification);
        return this;
    }

    public GumiPopulationStatusAPI numberOfHouseholds(Long numberOfHouseholds) {
        uriBuilder.setParameter("numberOfHouseholds", String.valueOf(numberOfHouseholds));
        return this;
    }

    public GumiPopulationStatusAPI numberOfHouseholdsLt(Long numberOfHouseholdsLt) {
        uriBuilder.setParameter("numberOfHouseholdsLt", String.valueOf(numberOfHouseholdsLt));
        return this;
    }

    public GumiPopulationStatusAPI numberOfHouseholdsLte(Long numberOfHouseholdsLte) {
        uriBuilder.setParameter("numberOfHouseholdsLte", String.valueOf(numberOfHouseholdsLte));
        return this;
    }

    public GumiPopulationStatusAPI numberOfHouseholdsGt(Long numberOfHouseholdsGt) {
        uriBuilder.setParameter("numberOfHouseholdsGt", String.valueOf(numberOfHouseholdsGt));
        return this;
    }

    public GumiPopulationStatusAPI numberOfHouseholdsGte(Long numberOfHouseholdsGte) {
        uriBuilder.setParameter("numberOfHouseholdsGte", String.valueOf(numberOfHouseholdsGte));
        return this;
    }
    public GumiPopulationStatusAPI line(Long line) {
        uriBuilder.setParameter("line", String.valueOf(line));
        return this;
    }

    public GumiPopulationStatusAPI lineLt(Long lineLt) {
        uriBuilder.setParameter("lineLt", String.valueOf(lineLt));
        return this;
    }

    public GumiPopulationStatusAPI lineLte(Long lineLte) {
        uriBuilder.setParameter("lineLte", String.valueOf(lineLte));
        return this;
    }

    public GumiPopulationStatusAPI lineGt(Long lineGt) {
        uriBuilder.setParameter("lineGt", String.valueOf(lineGt));
        return this;
    }

    public GumiPopulationStatusAPI lineGte(Long lineGte) {
        uriBuilder.setParameter("lineGte", String.valueOf(lineGte));
        return this;
    }
    public GumiPopulationStatusAPI male(Long male) {
        uriBuilder.setParameter("male", String.valueOf(male));
        return this;
    }

    public GumiPopulationStatusAPI maleLt(Long maleLt) {
        uriBuilder.setParameter("maleLt", String.valueOf(maleLt));
        return this;
    }

    public GumiPopulationStatusAPI maleLte(Long maleLte) {
        uriBuilder.setParameter("maleLte", String.valueOf(maleLte));
        return this;
    }

    public GumiPopulationStatusAPI maleGt(Long maleGt) {
        uriBuilder.setParameter("maleGt", String.valueOf(maleGt));
        return this;
    }

    public GumiPopulationStatusAPI maleGte(Long maleGte) {
        uriBuilder.setParameter("maleGte", String.valueOf(maleGte));
        return this;
    }
    public GumiPopulationStatusAPI female(Long female) {
        uriBuilder.setParameter("female", String.valueOf(female));
        return this;
    }

    public GumiPopulationStatusAPI femaleLt(Long femaleLt) {
        uriBuilder.setParameter("femaleLt", String.valueOf(femaleLt));
        return this;
    }

    public GumiPopulationStatusAPI femaleLte(Long femaleLte) {
        uriBuilder.setParameter("femaleLte", String.valueOf(femaleLte));
        return this;
    }

    public GumiPopulationStatusAPI femaleGt(Long femaleGt) {
        uriBuilder.setParameter("femaleGt", String.valueOf(femaleGt));
        return this;
    }

    public GumiPopulationStatusAPI femaleGte(Long femaleGte) {
        uriBuilder.setParameter("femaleGte", String.valueOf(femaleGte));
        return this;
    }
    public GumiPopulationStatusAPI managementAgencyName(String managementAgencyName) {
        uriBuilder.setParameter("managementAgencyName", String.valueOf(managementAgencyName));
        return this;
    }

    public GumiPopulationStatusAPI managementAgencyNameContaining(String managementAgencyName) {
        uriBuilder.setParameter("managementAgencyNameContaining", managementAgencyName);
        return this;
    }

    public GumiPopulationStatusAPI managementAgencyPhoneNumber(String managementAgencyPhoneNumber) {
        uriBuilder.setParameter("managementAgencyPhoneNumber", String.valueOf(managementAgencyPhoneNumber));
        return this;
    }

    public GumiPopulationStatusAPI managementAgencyPhoneNumberContaining(String managementAgencyPhoneNumber) {
        uriBuilder.setParameter("managementAgencyPhoneNumberContaining", managementAgencyPhoneNumber);
        return this;
    }

    public GumiPopulationStatusAPI dataBaseDate(LocalDate dataBaseDate) {
        uriBuilder.setParameter("dataBaseDate", String.valueOf(dataBaseDate));
        return this;
    }

    public GumiPopulationStatusAPI dataBaseDateAfter(LocalDate dataBaseDateAfter) {
        uriBuilder.setParameter("dataBaseDateAfter", dataBaseDateAfter.toString());
        return this;
    }

    public GumiPopulationStatusAPI dataBaseDateBefore(LocalDate dataBaseDateBefore) {
        uriBuilder.setParameter("dataBaseDateBefore", dataBaseDateBefore.toString());
        return this;
    }

}