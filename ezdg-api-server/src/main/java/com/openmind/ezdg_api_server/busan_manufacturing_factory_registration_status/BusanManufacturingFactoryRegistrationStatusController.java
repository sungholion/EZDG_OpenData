package com.openmind.ezdg_api_server.busan_manufacturing_factory_registration_status;

import com.openmind.ezdg_api_server.busan_manufacturing_factory_registration_status.BusanManufacturingFactoryRegistrationStatusService;
import com.openmind.ezdg_api_server.busan_manufacturing_factory_registration_status.BusanManufacturingFactoryRegistrationStatus;
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
@RequestMapping("/busan_manufacturing_factory_registration_status")
public class BusanManufacturingFactoryRegistrationStatusController {

    private final BusanManufacturingFactoryRegistrationStatusService service;

    @GetMapping("")
    public List<BusanManufacturingFactoryRegistrationStatus> search (
            @RequestParam(required = false) Long order,
            @RequestParam(required = false) Long orderLt,
            @RequestParam(required = false) Long orderLte,
            @RequestParam(required = false) Long orderGt,
            @RequestParam(required = false) Long orderGte,
            @RequestParam(required = false) String companyName,
            @RequestParam(required = false) String companyNameContaining,
            @RequestParam(required = false) String factoryRepresentativeAddress,
            @RequestParam(required = false) String factoryRepresentativeAddressContaining,
            @RequestParam(required = false) String businessName,
            @RequestParam(required = false) String businessNameContaining,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String phoneNumberContaining,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int perPage) {

        Map <String, Object> params = new HashMap<>();

        params.put("order", order);
        params.put("orderLt", orderLt);
        params.put("orderLte", orderLte);
        params.put("orderGt", orderGt);
        params.put("orderGte", orderGte);
        params.put("companyName", companyName);
        params.put("companyNameContaining", companyNameContaining);
        params.put("factoryRepresentativeAddress", factoryRepresentativeAddress);
        params.put("factoryRepresentativeAddressContaining", factoryRepresentativeAddressContaining);
        params.put("businessName", businessName);
        params.put("businessNameContaining", businessNameContaining);
        params.put("phoneNumber", phoneNumber);
        params.put("phoneNumberContaining", phoneNumberContaining);

        return service.search(params, page, perPage);
    }
}
