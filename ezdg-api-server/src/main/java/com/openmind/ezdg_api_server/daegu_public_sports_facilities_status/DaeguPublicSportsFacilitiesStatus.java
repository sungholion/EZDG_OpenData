package com.openmind.ezdg_api_server.daegu_public_sports_facilities_status;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document(collection = "daegu_public_sports_facilities_status")
public class DaeguPublicSportsFacilitiesStatus {
    @Id
    private String id;
    private String facilityName;
    private String managementEntity;
    private String siteArea;
    private String numberOfSeats;
    private String numberOfPeople;
    private Long completionYear;
}