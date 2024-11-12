package com.openmind.ezdg_api_server.sido;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "sido")
@Getter
@Setter
public class Sido {
@Id
private String id;
    private String sido;
    private String sigungu;
    private Long population;
    private LocalDate dateTimeOfCreation;
// Getters and Setters
}