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
@Document(collection = "daegu_restaurant")
public class DaeguRestaurantEntity {

    @Id
    private String id;

    private String number;
    private String businessName;
    private String businessType;
    private String businessAddress;
}

//    private String nameOfBusiness;
//    private String businessType;
//    private String businessName;
//    private String locationNew;
//    private String locationOld;
//    private String phone;