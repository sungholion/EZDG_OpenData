package com.openmind.ezdg_api_server.gumi_model_restaurant_status;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document(collection = "gumi_model_restaurant_status")
public class GumiModelRestaurantStatus {
    @Id
    private String id;
    private Long number;
    private String category;
    private String businessName;
    private String locationRoadNameAddress;
    private String phoneNumber;
    private String representativeMenu;
}