package com.daegu.travel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Document(collection = "daegu_accommodation")
public class DaeguAccommodationEntity {
    @Id
    private String id;
    private int number;
    private String industryClassification;
    private int guestMistakeStandard;
    private int guestMistakeCount;
    private String phoneNumber;
    private int guestMistakeOneRoom;
    private int guestMistakeDeluxe;
    private String location;
    private String region;
    private int guestMistakeSuite;
    private String guestMistakeOther;
    private String hotelName;
}
