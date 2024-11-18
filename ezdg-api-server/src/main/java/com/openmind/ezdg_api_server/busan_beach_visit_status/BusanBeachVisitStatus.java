package com.openmind.ezdg_api_server.busan_beach_visit_status;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document(collection = "busan_beach_visit_status")
public class BusanBeachVisitStatus {
    @Id
    private String id;
    private Long byYear;
    private String sido;
    private String gugun;
    private String beachName;
    private Long scale;
    private String numberOfVisitors;
    private String openingDate;
    private String closingDate;
    private String notice;
}