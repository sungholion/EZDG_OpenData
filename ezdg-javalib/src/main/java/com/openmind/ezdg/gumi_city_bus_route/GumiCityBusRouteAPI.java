package com.openmind.ezdg.gumi_city_bus_route;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;

public class GumiCityBusRouteAPI extends AbstractAPI<GumiCityBusRoute> {

    public GumiCityBusRouteAPI() {
        super("/gumi_city_bus_route");
    }

    public GumiCityBusRouteAPI page(int page) {
        return (GumiCityBusRouteAPI) super.page(page);
    }

    public GumiCityBusRouteAPI perPage(int perPage) {
        return (GumiCityBusRouteAPI) super.perPage(perPage);
    }

    public GumiCityBusRouteAPI routeNumber(String routeNumber) {
        uriBuilder.setParameter("routeNumber", String.valueOf(routeNumber));
        return this;
    }

    public GumiCityBusRouteAPI routeNumberContaining(String routeNumber) {
        uriBuilder.setParameter("routeNumberContaining", routeNumber);
        return this;
    }

    public GumiCityBusRouteAPI mainStop(String mainStop) {
        uriBuilder.setParameter("mainStop", String.valueOf(mainStop));
        return this;
    }

    public GumiCityBusRouteAPI mainStopContaining(String mainStop) {
        uriBuilder.setParameter("mainStopContaining", mainStop);
        return this;
    }

    public GumiCityBusRouteAPI departure(String departure) {
        uriBuilder.setParameter("departure", String.valueOf(departure));
        return this;
    }

    public GumiCityBusRouteAPI departureContaining(String departure) {
        uriBuilder.setParameter("departureContaining", departure);
        return this;
    }

    public GumiCityBusRouteAPI destination(String destination) {
        uriBuilder.setParameter("destination", String.valueOf(destination));
        return this;
    }

    public GumiCityBusRouteAPI destinationContaining(String destination) {
        uriBuilder.setParameter("destinationContaining", destination);
        return this;
    }

}