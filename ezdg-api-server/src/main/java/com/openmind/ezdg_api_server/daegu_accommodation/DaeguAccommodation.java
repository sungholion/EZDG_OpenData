package com.openmind.ezdg_api_server.daegu_accommodation;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document(collection = "daegu_accommodation")
public class DaeguAccommodation {
    @Id
    private String id;
    private Long number;
    private String region;
    private String industryClassification;
    private String hotelName;
    private Long guestMistakeStard;
    private Long guestMistakeDeluxe;
    private Long guestMistakeSuite;
    private Long guestMistakeOneRoom;
    private String guestMistakeOther;
    private Long guestMistakeCount;
    private String location;
    private String phoneNumber;
}