package com.daegu.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DaeguRestaurantDto {

    private String id;
//    private String nameOfBusiness;
//    private String businessType;
//    private String businessName;
//    private String locationNew;
//    private String locationOld;
//    private String phone;
    private String number;
    private String businessName;
    private String businessType;
    private String businessAddress;
}
