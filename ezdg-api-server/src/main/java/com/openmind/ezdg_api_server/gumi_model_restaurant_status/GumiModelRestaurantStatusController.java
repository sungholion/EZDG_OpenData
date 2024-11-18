package com.openmind.ezdg_api_server.gumi_model_restaurant_status;

import com.openmind.ezdg_api_server.gumi_model_restaurant_status.GumiModelRestaurantStatusService;
import com.openmind.ezdg_api_server.gumi_model_restaurant_status.GumiModelRestaurantStatus;
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
@RequestMapping("/gumi_model_restaurant_status")
public class GumiModelRestaurantStatusController {

    private final GumiModelRestaurantStatusService service;

    @GetMapping("")
    public List<GumiModelRestaurantStatus> search (
            @RequestParam(required = false) Long number,
            @RequestParam(required = false) Long numberLt,
            @RequestParam(required = false) Long numberLte,
            @RequestParam(required = false) Long numberGt,
            @RequestParam(required = false) Long numberGte,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String categoryContaining,
            @RequestParam(required = false) String businessName,
            @RequestParam(required = false) String businessNameContaining,
            @RequestParam(required = false) String locationRoadNameAddress,
            @RequestParam(required = false) String locationRoadNameAddressContaining,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String phoneNumberContaining,
            @RequestParam(required = false) String representativeMenu,
            @RequestParam(required = false) String representativeMenuContaining,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int perPage) {

        Map <String, Object> params = new HashMap<>();

        params.put("number", number);
        params.put("numberLt", numberLt);
        params.put("numberLte", numberLte);
        params.put("numberGt", numberGt);
        params.put("numberGte", numberGte);
        params.put("category", category);
        params.put("categoryContaining", categoryContaining);
        params.put("businessName", businessName);
        params.put("businessNameContaining", businessNameContaining);
        params.put("locationRoadNameAddress", locationRoadNameAddress);
        params.put("locationRoadNameAddressContaining", locationRoadNameAddressContaining);
        params.put("phoneNumber", phoneNumber);
        params.put("phoneNumberContaining", phoneNumberContaining);
        params.put("representativeMenu", representativeMenu);
        params.put("representativeMenuContaining", representativeMenuContaining);

        return service.search(params, page, perPage);
    }
}
