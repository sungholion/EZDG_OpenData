package com.openmind.ezdg_api_server.daegu_restaurant;

import com.openmind.ezdg_api_server.daegu_restaurant.DaeguRestaurantService;
import com.openmind.ezdg_api_server.daegu_restaurant.DaeguRestaurant;
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
@RequestMapping("/daegu_restaurant")
public class DaeguRestaurantController {

    private final DaeguRestaurantService service;

    @GetMapping("")
    public List<DaeguRestaurant> search (
            @RequestParam(required = false) String number,
            @RequestParam(required = false) String numberContaining,
            @RequestParam(required = false) String businessName,
            @RequestParam(required = false) String businessNameContaining,
            @RequestParam(required = false) String businessStatus,
            @RequestParam(required = false) String businessStatusContaining,
            @RequestParam(required = false) String businessAddress,
            @RequestParam(required = false) String businessAddressContaining,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int perPage) {

        Map <String, Object> params = new HashMap<>();

        params.put("number", number);
        params.put("numberContaining", numberContaining);
        params.put("businessName", businessName);
        params.put("businessNameContaining", businessNameContaining);
        params.put("businessStatus", businessStatus);
        params.put("businessStatusContaining", businessStatusContaining);
        params.put("businessAddress", businessAddress);
        params.put("businessAddressContaining", businessAddressContaining);

        return service.search(params, page, perPage);
    }
}
