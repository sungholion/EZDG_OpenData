package com.daegu.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DaeguRestaurantDto {
    private String id;
    private String number;
    private String businessName;
    private String businessType;
    private String businessAddress;
}
