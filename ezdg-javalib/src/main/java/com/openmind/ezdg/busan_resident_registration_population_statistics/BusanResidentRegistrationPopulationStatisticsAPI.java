package com.openmind.ezdg.busan_resident_registration_population_statistics;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;

public class BusanResidentRegistrationPopulationStatisticsAPI extends AbstractAPI<BusanResidentRegistrationPopulationStatistics> {

    public BusanResidentRegistrationPopulationStatisticsAPI() {
        super("/busan_resident_registration_population_statistics");
    }

    public BusanResidentRegistrationPopulationStatisticsAPI page(int page) {
        return (BusanResidentRegistrationPopulationStatisticsAPI) super.page(page);
    }

    public BusanResidentRegistrationPopulationStatisticsAPI perPage(int perPage) {
        return (BusanResidentRegistrationPopulationStatisticsAPI) super.perPage(perPage);
    }

    public BusanResidentRegistrationPopulationStatisticsAPI gugun(String gugun) {
        uriBuilder.setParameter("gugun", String.valueOf(gugun));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI gugunContaining(String gugun) {
        uriBuilder.setParameter("gugunContaining", gugun);
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI dongsu(Long dongsu) {
        uriBuilder.setParameter("dongsu", String.valueOf(dongsu));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI dongsuLt(Long dongsuLt) {
        uriBuilder.setParameter("dongsuLt", String.valueOf(dongsuLt));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI dongsuLte(Long dongsuLte) {
        uriBuilder.setParameter("dongsuLte", String.valueOf(dongsuLte));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI dongsuGt(Long dongsuGt) {
        uriBuilder.setParameter("dongsuGt", String.valueOf(dongsuGt));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI dongsuGte(Long dongsuGte) {
        uriBuilder.setParameter("dongsuGte", String.valueOf(dongsuGte));
        return this;
    }
    public BusanResidentRegistrationPopulationStatisticsAPI generation(Long generation) {
        uriBuilder.setParameter("generation", String.valueOf(generation));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI generationLt(Long generationLt) {
        uriBuilder.setParameter("generationLt", String.valueOf(generationLt));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI generationLte(Long generationLte) {
        uriBuilder.setParameter("generationLte", String.valueOf(generationLte));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI generationGt(Long generationGt) {
        uriBuilder.setParameter("generationGt", String.valueOf(generationGt));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI generationGte(Long generationGte) {
        uriBuilder.setParameter("generationGte", String.valueOf(generationGte));
        return this;
    }
    public BusanResidentRegistrationPopulationStatisticsAPI population(Long population) {
        uriBuilder.setParameter("population", String.valueOf(population));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI populationLt(Long populationLt) {
        uriBuilder.setParameter("populationLt", String.valueOf(populationLt));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI populationLte(Long populationLte) {
        uriBuilder.setParameter("populationLte", String.valueOf(populationLte));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI populationGt(Long populationGt) {
        uriBuilder.setParameter("populationGt", String.valueOf(populationGt));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI populationGte(Long populationGte) {
        uriBuilder.setParameter("populationGte", String.valueOf(populationGte));
        return this;
    }
    public BusanResidentRegistrationPopulationStatisticsAPI malePopulation(Long malePopulation) {
        uriBuilder.setParameter("malePopulation", String.valueOf(malePopulation));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI malePopulationLt(Long malePopulationLt) {
        uriBuilder.setParameter("malePopulationLt", String.valueOf(malePopulationLt));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI malePopulationLte(Long malePopulationLte) {
        uriBuilder.setParameter("malePopulationLte", String.valueOf(malePopulationLte));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI malePopulationGt(Long malePopulationGt) {
        uriBuilder.setParameter("malePopulationGt", String.valueOf(malePopulationGt));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI malePopulationGte(Long malePopulationGte) {
        uriBuilder.setParameter("malePopulationGte", String.valueOf(malePopulationGte));
        return this;
    }
    public BusanResidentRegistrationPopulationStatisticsAPI femalePopulation(Long femalePopulation) {
        uriBuilder.setParameter("femalePopulation", String.valueOf(femalePopulation));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI femalePopulationLt(Long femalePopulationLt) {
        uriBuilder.setParameter("femalePopulationLt", String.valueOf(femalePopulationLt));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI femalePopulationLte(Long femalePopulationLte) {
        uriBuilder.setParameter("femalePopulationLte", String.valueOf(femalePopulationLte));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI femalePopulationGt(Long femalePopulationGt) {
        uriBuilder.setParameter("femalePopulationGt", String.valueOf(femalePopulationGt));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI femalePopulationGte(Long femalePopulationGte) {
        uriBuilder.setParameter("femalePopulationGte", String.valueOf(femalePopulationGte));
        return this;
    }
    public BusanResidentRegistrationPopulationStatisticsAPI compositionRatio(Double compositionRatio) {
        uriBuilder.setParameter("compositionRatio", String.valueOf(compositionRatio));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI compositionRatioLt(Double compositionRatioLt) {
        uriBuilder.setParameter("compositionRatioLt", String.valueOf(compositionRatioLt));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI compositionRatioLte(Double compositionRatioLte) {
        uriBuilder.setParameter("compositionRatioLte", String.valueOf(compositionRatioLte));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI compositionRatioGt(Double compositionRatioGt) {
        uriBuilder.setParameter("compositionRatioGt", String.valueOf(compositionRatioGt));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI compositionRatioGte(Double compositionRatioGte) {
        uriBuilder.setParameter("compositionRatioGte", String.valueOf(compositionRatioGte));
        return this;
    }
    public BusanResidentRegistrationPopulationStatisticsAPI area(Double area) {
        uriBuilder.setParameter("area", String.valueOf(area));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI areaLt(Double areaLt) {
        uriBuilder.setParameter("areaLt", String.valueOf(areaLt));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI areaLte(Double areaLte) {
        uriBuilder.setParameter("areaLte", String.valueOf(areaLte));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI areaGt(Double areaGt) {
        uriBuilder.setParameter("areaGt", String.valueOf(areaGt));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI areaGte(Double areaGte) {
        uriBuilder.setParameter("areaGte", String.valueOf(areaGte));
        return this;
    }
    public BusanResidentRegistrationPopulationStatisticsAPI populationDensity(Long populationDensity) {
        uriBuilder.setParameter("populationDensity", String.valueOf(populationDensity));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI populationDensityLt(Long populationDensityLt) {
        uriBuilder.setParameter("populationDensityLt", String.valueOf(populationDensityLt));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI populationDensityLte(Long populationDensityLte) {
        uriBuilder.setParameter("populationDensityLte", String.valueOf(populationDensityLte));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI populationDensityGt(Long populationDensityGt) {
        uriBuilder.setParameter("populationDensityGt", String.valueOf(populationDensityGt));
        return this;
    }

    public BusanResidentRegistrationPopulationStatisticsAPI populationDensityGte(Long populationDensityGte) {
        uriBuilder.setParameter("populationDensityGte", String.valueOf(populationDensityGte));
        return this;
    }
}