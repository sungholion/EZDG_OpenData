package com.daegu.travel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Document(collection = "daegu_metropolitan_city_restaurant_registration_status")
public class DaeguMetropolitanCityRestaurantRegistrationStatusEntity {

    @Id
    private String id;

    private String number;
    private String businessName;
    private String businessStatus;
    private String businessAddress;
}
