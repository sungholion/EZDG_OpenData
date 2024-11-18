package com.openmind.ezdg_api_server.gumi_population_status;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;


@Getter
@Setter
@Document(collection = "gumi_population_status")
public class GumiPopulationStatus {
    @Id
    private String id;
    private String classification;
    private Long numberOfHouseholds;
    private Long line;
    private Long male;
    private Long female;
    private String managementAgencyName;
    private String managementAgencyPhoneNumber;
    private LocalDate dataBaseDate;
}