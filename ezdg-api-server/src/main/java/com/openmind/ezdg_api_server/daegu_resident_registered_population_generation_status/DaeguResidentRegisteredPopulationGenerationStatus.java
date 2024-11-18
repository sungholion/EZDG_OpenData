package com.openmind.ezdg_api_server.daegu_resident_registered_population_generation_status;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document(collection = "daegu_resident_registered_population_generation_status")
public class DaeguResidentRegisteredPopulationGenerationStatus {
    @Id
    private String id;
    private String administrativeDistricts;
    private String octoberTotalPopulation;
    private String octoberGeneration;
    private String octoberPopulationPerGeneration;
    private String octoberMalePopulation;
    private String octoberFemalePopulation;
    private Double octoberMaleRatio;
}