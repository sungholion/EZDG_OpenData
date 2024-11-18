package com.openmind.ezdg_api_server.daegu_restaurant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document(collection = "daegu_restaurant")
public class DaeguRestaurant {
    @Id
    private String id;
    private String number;
    private String businessName;
    private String businessStatus;
    private String businessAddress;
}