package com.daegu.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
//
@Data
@AllArgsConstructor
public class DaeguMetropolitanCityStatusOfTourismAccommodationBusinessDto {

    private String id;
    private int number;  // number 필드
    private String industryClassification;  // industryClassification
    private int guestMistakeStandard;  // guestMistakeStandard
    private int guestMistakeCount;  // guestMistakeCount
    private String phoneNumber;  // phoneNumber
    private int guestMistakeOneRoom;  // guestMistakeOneRoom
    private int guestMistakeDeluxe;  // guestMistakeDeluxe
    private String location;  // location
    private String region;  // region
    private int guestMistakeSuite;  // guestMistakeSuite
    private String guestMistakeOther;  // guestMistakeOther
    private String hotelName;  // hotelName
}
