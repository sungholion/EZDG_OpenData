package com.openmind.ezdg.daegu_resident_registered_population_generation_status;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;

public class DaeguResidentRegisteredPopulationGenerationStatusAPI extends AbstractAPI<DaeguResidentRegisteredPopulationGenerationStatus> {

    public DaeguResidentRegisteredPopulationGenerationStatusAPI() {
        super("/daegu_resident_registered_population_generation_status");
    }

    public DaeguResidentRegisteredPopulationGenerationStatusAPI page(int page) {
        return (DaeguResidentRegisteredPopulationGenerationStatusAPI) super.page(page);
    }

    public DaeguResidentRegisteredPopulationGenerationStatusAPI perPage(int perPage) {
        return (DaeguResidentRegisteredPopulationGenerationStatusAPI) super.perPage(perPage);
    }

    public DaeguResidentRegisteredPopulationGenerationStatusAPI administrativeDistricts(String administrativeDistricts) {
        uriBuilder.setParameter("administrativeDistricts", String.valueOf(administrativeDistricts));
        return this;
    }

    public DaeguResidentRegisteredPopulationGenerationStatusAPI administrativeDistrictsContaining(String administrativeDistricts) {
        uriBuilder.setParameter("administrativeDistrictsContaining", administrativeDistricts);
        return this;
    }

    public DaeguResidentRegisteredPopulationGenerationStatusAPI octoberTotalPopulation(String octoberTotalPopulation) {
        uriBuilder.setParameter("octoberTotalPopulation", String.valueOf(octoberTotalPopulation));
        return this;
    }

    public DaeguResidentRegisteredPopulationGenerationStatusAPI octoberTotalPopulationContaining(String octoberTotalPopulation) {
        uriBuilder.setParameter("octoberTotalPopulationContaining", octoberTotalPopulation);
        return this;
    }

    public DaeguResidentRegisteredPopulationGenerationStatusAPI octoberGeneration(String octoberGeneration) {
        uriBuilder.setParameter("octoberGeneration", String.valueOf(octoberGeneration));
        return this;
    }

    public DaeguResidentRegisteredPopulationGenerationStatusAPI octoberGenerationContaining(String octoberGeneration) {
        uriBuilder.setParameter("octoberGenerationContaining", octoberGeneration);
        return this;
    }

    public DaeguResidentRegisteredPopulationGenerationStatusAPI octoberPopulationPerGeneration(String octoberPopulationPerGeneration) {
        uriBuilder.setParameter("octoberPopulationPerGeneration", String.valueOf(octoberPopulationPerGeneration));
        return this;
    }

    public DaeguResidentRegisteredPopulationGenerationStatusAPI octoberPopulationPerGenerationContaining(String octoberPopulationPerGeneration) {
        uriBuilder.setParameter("octoberPopulationPerGenerationContaining", octoberPopulationPerGeneration);
        return this;
    }

    public DaeguResidentRegisteredPopulationGenerationStatusAPI octoberMalePopulation(String octoberMalePopulation) {
        uriBuilder.setParameter("octoberMalePopulation", String.valueOf(octoberMalePopulation));
        return this;
    }

    public DaeguResidentRegisteredPopulationGenerationStatusAPI octoberMalePopulationContaining(String octoberMalePopulation) {
        uriBuilder.setParameter("octoberMalePopulationContaining", octoberMalePopulation);
        return this;
    }

    public DaeguResidentRegisteredPopulationGenerationStatusAPI octoberFemalePopulation(String octoberFemalePopulation) {
        uriBuilder.setParameter("octoberFemalePopulation", String.valueOf(octoberFemalePopulation));
        return this;
    }

    public DaeguResidentRegisteredPopulationGenerationStatusAPI octoberFemalePopulationContaining(String octoberFemalePopulation) {
        uriBuilder.setParameter("octoberFemalePopulationContaining", octoberFemalePopulation);
        return this;
    }

    public DaeguResidentRegisteredPopulationGenerationStatusAPI octoberMaleRatio(Double octoberMaleRatio) {
        uriBuilder.setParameter("octoberMaleRatio", String.valueOf(octoberMaleRatio));
        return this;
    }

    public DaeguResidentRegisteredPopulationGenerationStatusAPI octoberMaleRatioLt(Double octoberMaleRatioLt) {
        uriBuilder.setParameter("octoberMaleRatioLt", String.valueOf(octoberMaleRatioLt));
        return this;
    }

    public DaeguResidentRegisteredPopulationGenerationStatusAPI octoberMaleRatioLte(Double octoberMaleRatioLte) {
        uriBuilder.setParameter("octoberMaleRatioLte", String.valueOf(octoberMaleRatioLte));
        return this;
    }

    public DaeguResidentRegisteredPopulationGenerationStatusAPI octoberMaleRatioGt(Double octoberMaleRatioGt) {
        uriBuilder.setParameter("octoberMaleRatioGt", String.valueOf(octoberMaleRatioGt));
        return this;
    }

    public DaeguResidentRegisteredPopulationGenerationStatusAPI octoberMaleRatioGte(Double octoberMaleRatioGte) {
        uriBuilder.setParameter("octoberMaleRatioGte", String.valueOf(octoberMaleRatioGte));
        return this;
    }
}