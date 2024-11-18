package com.daegu.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DaeguRestaurantDto {
    private String id;
    private String number;
    private String businessName;
    private String businessType;
    private String businessAddress;
}
