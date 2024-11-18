package com.openmind.ezdg_api_server.busan_resident_registration_population_statistics;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document(collection = "busan_resident_registration_population_statistics")
public class BusanResidentRegistrationPopulationStatistics {
    @Id
    private String id;
    private String gugun;
    private Long dongsu;
    private Long generation;
    private Long population;
    private Long malePopulation;
    private Long femalePopulation;
    private Double compositionRatio;
    private Double area;
    private Long populationDensity;
}