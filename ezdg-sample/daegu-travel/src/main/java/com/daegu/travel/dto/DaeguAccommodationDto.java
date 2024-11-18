package com.daegu.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DaeguAccommodationDto {
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
