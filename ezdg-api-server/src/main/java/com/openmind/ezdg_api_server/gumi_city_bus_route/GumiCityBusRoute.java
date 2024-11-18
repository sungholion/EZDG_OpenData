package com.openmind.ezdg_api_server.gumi_city_bus_route;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document(collection = "gumi_city_bus_route")
public class GumiCityBusRoute {
    @Id
    private String id;
    private String routeNumber;
    private String mainStop;
    private String departure;
    private String destination;
}