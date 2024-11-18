package com.openmind.ezdg_api_server.gumi_population_status;

import com.openmind.ezdg_api_server.gumi_population_status.GumiPopulationStatusService;
import com.openmind.ezdg_api_server.gumi_population_status.GumiPopulationStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
    import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gumi_population_status")
public class GumiPopulationStatusController {

    private final GumiPopulationStatusService service;

    @GetMapping("")
    public List<GumiPopulationStatus> search (
            @RequestParam(required = false) String classification,
            @RequestParam(required = false) String classificationContaining,
            @RequestParam(required = false) Long numberOfHouseholds,
            @RequestParam(required = false) Long numberOfHouseholdsLt,
            @RequestParam(required = false) Long numberOfHouseholdsLte,
            @RequestParam(required = false) Long numberOfHouseholdsGt,
            @RequestParam(required = false) Long numberOfHouseholdsGte,
            @RequestParam(required = false) Long line,
            @RequestParam(required = false) Long lineLt,
            @RequestParam(required = false) Long lineLte,
            @RequestParam(required = false) Long lineGt,
            @RequestParam(required = false) Long lineGte,
            @RequestParam(required = false) Long male,
            @RequestParam(required = false) Long maleLt,
            @RequestParam(required = false) Long maleLte,
            @RequestParam(required = false) Long maleGt,
            @RequestParam(required = false) Long maleGte,
            @RequestParam(required = false) Long female,
            @RequestParam(required = false) Long femaleLt,
            @RequestParam(required = false) Long femaleLte,
            @RequestParam(required = false) Long femaleGt,
            @RequestParam(required = false) Long femaleGte,
            @RequestParam(required = false) String managementAgencyName,
            @RequestParam(required = false) String managementAgencyNameContaining,
            @RequestParam(required = false) String managementAgencyPhoneNumber,
            @RequestParam(required = false) String managementAgencyPhoneNumberContaining,
            @RequestParam(required = false) LocalDate dataBaseDate,
            @RequestParam(required = false) LocalDate dataBaseDateAfter,
            @RequestParam(required = false) LocalDate dataBaseDateBefore,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int perPage) {

        Map <String, Object> params = new HashMap<>();

        params.put("classification", classification);
        params.put("classificationContaining", classificationContaining);
        params.put("numberOfHouseholds", numberOfHouseholds);
        params.put("numberOfHouseholdsLt", numberOfHouseholdsLt);
        params.put("numberOfHouseholdsLte", numberOfHouseholdsLte);
        params.put("numberOfHouseholdsGt", numberOfHouseholdsGt);
        params.put("numberOfHouseholdsGte", numberOfHouseholdsGte);
        params.put("line", line);
        params.put("lineLt", lineLt);
        params.put("lineLte", lineLte);
        params.put("lineGt", lineGt);
        params.put("lineGte", lineGte);
        params.put("male", male);
        params.put("maleLt", maleLt);
        params.put("maleLte", maleLte);
        params.put("maleGt", maleGt);
        params.put("maleGte", maleGte);
        params.put("female", female);
        params.put("femaleLt", femaleLt);
        params.put("femaleLte", femaleLte);
        params.put("femaleGt", femaleGt);
        params.put("femaleGte", femaleGte);
        params.put("managementAgencyName", managementAgencyName);
        params.put("managementAgencyNameContaining", managementAgencyNameContaining);
        params.put("managementAgencyPhoneNumber", managementAgencyPhoneNumber);
        params.put("managementAgencyPhoneNumberContaining", managementAgencyPhoneNumberContaining);
        params.put("dataBaseDate", dataBaseDate);
        params.put("dataBaseDateAfter", dataBaseDateAfter);
        params.put("dataBaseDateBefore", dataBaseDateBefore);

        return service.search(params, page, perPage);
    }
}
