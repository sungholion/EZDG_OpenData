package com.openmind.ezdg_api_server.gumi_air_pollution_degree_information;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;


@Getter
@Setter
@Document(collection = "gumi_air_pollution_degree_information")
public class GumiAirPollutionDegreeInformation {
    @Id
    private String id;
    private LocalDate yearMonth;
    private String location;
    private Double sulfurDioxide;
    private Double nitrogenDioxide;
    private Double carbonMonoxide;
    private Double ozone;
    private Long fineDustTen;
    private Long fineDustTwentyFive;
}