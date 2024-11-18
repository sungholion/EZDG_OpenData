package com.openmind.ezdg_api_server.gumi_city_bus_route;

import com.openmind.ezdg_api_server.gumi_city_bus_route.GumiCityBusRouteService;
import com.openmind.ezdg_api_server.gumi_city_bus_route.GumiCityBusRoute;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gumi_city_bus_route")
public class GumiCityBusRouteController {

    private final GumiCityBusRouteService service;

    @GetMapping("")
    public List<GumiCityBusRoute> search (
            @RequestParam(required = false) String routeNumber,
            @RequestParam(required = false) String routeNumberContaining,
        <            @RequestParam(required = false) String mainStop,
            @RequestParam(required = false) String mainStopContaining,
        <            @RequestParam(required = false) String departure,
            @RequestParam(required = false) String departureContaining,
        <            @RequestParam(required = false) String destination,
            @RequestParam(required = false) String destinationContaining,
        <            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int perPage) {

        Map <String, Object> params = new HashMap<>();

        params.put("routeNumber", routeNumber);
        params.put("routeNumberContaining", routeNumberContaining);
        params.put("mainStop", mainStop);
        params.put("mainStopContaining", mainStopContaining);
        params.put("departure", departure);
        params.put("departureContaining", departureContaining);
        params.put("destination", destination);
        params.put("destinationContaining", destinationContaining);

        return service.search(params, page, perPage);
    }
}
