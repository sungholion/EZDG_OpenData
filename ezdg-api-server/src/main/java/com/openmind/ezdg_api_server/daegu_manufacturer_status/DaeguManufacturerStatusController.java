package com.openmind.ezdg_api_server.daegu_manufacturer_status;

import com.openmind.ezdg_api_server.daegu_manufacturer_status.DaeguManufacturerStatusService;
import com.openmind.ezdg_api_server.daegu_manufacturer_status.DaeguManufacturerStatus;
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
@RequestMapping("/daegu_manufacturer_status")
public class DaeguManufacturerStatusController {

    private final DaeguManufacturerStatusService service;

    @GetMapping("")
    public List<DaeguManufacturerStatus> search (
            @RequestParam(required = false) Long orderNumber,
            @RequestParam(required = false) Long orderNumberLt,
            @RequestParam(required = false) Long orderNumberLte,
            @RequestParam(required = false) Long orderNumberGt,
            @RequestParam(required = false) Long orderNumberGte,
            @RequestParam(required = false) String complexName,
            @RequestParam(required = false) String complexNameContaining,
            @RequestParam(required = false) String companyName,
            @RequestParam(required = false) String companyNameContaining,
            @RequestParam(required = false) String factoryRepresentativeAddress,
            @RequestParam(required = false) String factoryRepresentativeAddressContaining,
            @RequestParam(required = false) String factoryRepresentativeAddress,
            @RequestParam(required = false) String factoryRepresentativeAddressContaining,
            @RequestParam(required = false) String representativeBusinessNumber,
            @RequestParam(required = false) String representativeBusinessNumberContaining,
            @RequestParam(required = false) String businessNumber,
            @RequestParam(required = false) String businessNumberContaining,
            @RequestParam(required = false) String businessName,
            @RequestParam(required = false) String businessNameContaining,
            @RequestParam(required = false) String establishmentClassification,
            @RequestParam(required = false) String establishmentClassificationContaining,
            @RequestParam(required = false) String product,
            @RequestParam(required = false) String productContaining,
            @RequestParam(required = false) String mainMaterial,
            @RequestParam(required = false) String mainMaterialContaining,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int perPage) {

        Map <String, Object> params = new HashMap<>();

        params.put("orderNumber", orderNumber);
        params.put("orderNumberLt", orderNumberLt);
        params.put("orderNumberLte", orderNumberLte);
        params.put("orderNumberGt", orderNumberGt);
        params.put("orderNumberGte", orderNumberGte);
        params.put("complexName", complexName);
        params.put("complexNameContaining", complexNameContaining);
        params.put("companyName", companyName);
        params.put("companyNameContaining", companyNameContaining);
        params.put("factoryRepresentativeAddress", factoryRepresentativeAddress);
        params.put("factoryRepresentativeAddressContaining", factoryRepresentativeAddressContaining);
        params.put("factoryRepresentativeAddress", factoryRepresentativeAddress);
        params.put("factoryRepresentativeAddressContaining", factoryRepresentativeAddressContaining);
        params.put("representativeBusinessNumber", representativeBusinessNumber);
        params.put("representativeBusinessNumberContaining", representativeBusinessNumberContaining);
        params.put("businessNumber", businessNumber);
        params.put("businessNumberContaining", businessNumberContaining);
        params.put("businessName", businessName);
        params.put("businessNameContaining", businessNameContaining);
        params.put("establishmentClassification", establishmentClassification);
        params.put("establishmentClassificationContaining", establishmentClassificationContaining);
        params.put("product", product);
        params.put("productContaining", productContaining);
        params.put("mainMaterial", mainMaterial);
        params.put("mainMaterialContaining", mainMaterialContaining);

        return service.search(params, page, perPage);
    }
}
