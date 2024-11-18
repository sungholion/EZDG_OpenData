package com.openmind.ezdg.daegu_october_resident_registered_population_generation_status;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;

public class DaeguOctoberResidentRegisteredPopulationGenerationStatusAPI extends AbstractAPI<DaeguOctoberResidentRegisteredPopulationGenerationStatus> {

    public DaeguOctoberResidentRegisteredPopulationGenerationStatusAPI() {
        super("/daegu_october_resident_registered_population_generation_status");
    }

    public DaeguOctoberResidentRegisteredPopulationGenerationStatusAPI page(int page) {
        return (DaeguOctoberResidentRegisteredPopulationGenerationStatusAPI) super.page(page);
    }

    public DaeguOctoberResidentRegisteredPopulationGenerationStatusAPI perPage(int perPage) {
        return (DaeguOctoberResidentRegisteredPopulationGenerationStatusAPI) super.perPage(perPage);
    }

    public DaeguOctoberResidentRegisteredPopulationGenerationStatusAPI administrativeDistricts(String administrativeDistricts) {
        uriBuilder.setParameter("administrativeDistricts", String.valueOf(administrativeDistricts));
        return this;
    }

    public DaeguOctoberResidentRegisteredPopulationGenerationStatusAPI administrativeDistrictsContaining(String administrativeDistricts) {
        uriBuilder.setParameter("administrativeDistrictsContaining", administrativeDistricts);
        return this;
    }

    public DaeguOctoberResidentRegisteredPopulationGenerationStatusAPI octoberTotalPopulation(String octoberTotalPopulation) {
        uriBuilder.setParameter("octoberTotalPopulation", String.valueOf(octoberTotalPopulation));
        return this;
    }

    public DaeguOctoberResidentRegisteredPopulationGenerationStatusAPI octoberTotalPopulationContaining(String octoberTotalPopulation) {
        uriBuilder.setParameter("octoberTotalPopulationContaining", octoberTotalPopulation);
        return this;
    }

    public DaeguOctoberResidentRegisteredPopulationGenerationStatusAPI octoberGeneration(String octoberGeneration) {
        uriBuilder.setParameter("octoberGeneration", String.valueOf(octoberGeneration));
        return this;
    }

    public DaeguOctoberResidentRegisteredPopulationGenerationStatusAPI octoberGenerationContaining(String octoberGeneration) {
        uriBuilder.setParameter("octoberGenerationContaining", octoberGeneration);
        return this;
    }

    public DaeguOctoberResidentRegisteredPopulationGenerationStatusAPI octoberPopulationPerGeneration(String octoberPopulationPerGeneration) {
        uriBuilder.setParameter("octoberPopulationPerGeneration", String.valueOf(octoberPopulationPerGeneration));
        return this;
    }

    public DaeguOctoberResidentRegisteredPopulationGenerationStatusAPI octoberPopulationPerGenerationContaining(String octoberPopulationPerGeneration) {
        uriBuilder.setParameter("octoberPopulationPerGenerationContaining", octoberPopulationPerGeneration);
        return this;
    }

    public DaeguOctoberResidentRegisteredPopulationGenerationStatusAPI octoberMalePopulation(String octoberMalePopulation) {
        uriBuilder.setParameter("octoberMalePopulation", String.valueOf(octoberMalePopulation));
        return this;
    }

    public DaeguOctoberResidentRegisteredPopulationGenerationStatusAPI octoberMalePopulationContaining(String octoberMalePopulation) {
        uriBuilder.setParameter("octoberMalePopulationContaining", octoberMalePopulation);
        return this;
    }

    public DaeguOctoberResidentRegisteredPopulationGenerationStatusAPI octoberFemalePopulation(String octoberFemalePopulation) {
        uriBuilder.setParameter("octoberFemalePopulation", String.valueOf(octoberFemalePopulation));
        return this;
    }

    public DaeguOctoberResidentRegisteredPopulationGenerationStatusAPI octoberFemalePopulationContaining(String octoberFemalePopulation) {
        uriBuilder.setParameter("octoberFemalePopulationContaining", octoberFemalePopulation);
        return this;
    }

    public DaeguOctoberResidentRegisteredPopulationGenerationStatusAPI octoberMaleRatio(Double octoberMaleRatio) {
        uriBuilder.setParameter("octoberMaleRatio", String.valueOf(octoberMaleRatio));
        return this;
    }

    public DaeguOctoberResidentRegisteredPopulationGenerationStatusAPI octoberMaleRatioLt(Double octoberMaleRatioLt) {
        uriBuilder.setParameter("octoberMaleRatioLt", String.valueOf(octoberMaleRatioLt));
        return this;
    }

    public DaeguOctoberResidentRegisteredPopulationGenerationStatusAPI octoberMaleRatioLte(Double octoberMaleRatioLte) {
        uriBuilder.setParameter("octoberMaleRatioLte", String.valueOf(octoberMaleRatioLte));
        return this;
    }

    public DaeguOctoberResidentRegisteredPopulationGenerationStatusAPI octoberMaleRatioGt(Double octoberMaleRatioGt) {
        uriBuilder.setParameter("octoberMaleRatioGt", String.valueOf(octoberMaleRatioGt));
        return this;
    }

    public DaeguOctoberResidentRegisteredPopulationGenerationStatusAPI octoberMaleRatioGte(Double octoberMaleRatioGte) {
        uriBuilder.setParameter("octoberMaleRatioGte", String.valueOf(octoberMaleRatioGte));
        return this;
    }
}