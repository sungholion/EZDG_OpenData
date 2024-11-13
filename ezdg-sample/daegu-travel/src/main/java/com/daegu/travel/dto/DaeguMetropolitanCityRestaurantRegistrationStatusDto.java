package com.daegu.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DaeguMetropolitanCityRestaurantRegistrationStatusDto {

    private String id;
    private String number;
    private String businessName;
    private String businessStatus;
    private String businessAddress;
}
