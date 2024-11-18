package com.openmind.ezdg_api_server.gumi_air_pollution_degree_information;

import com.openmind.ezdg_api_server.gumi_air_pollution_degree_information.GumiAirPollutionDegreeInformationService;
import com.openmind.ezdg_api_server.gumi_air_pollution_degree_information.GumiAirPollutionDegreeInformation;
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
@RequestMapping("/gumi_air_pollution_degree_information")
public class GumiAirPollutionDegreeInformationController {

    private final GumiAirPollutionDegreeInformationService service;

    @GetMapping("")
    public List<GumiAirPollutionDegreeInformation> search (
            @RequestParam(required = false) LocalDate yearMonth,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String locationContaining,
            @RequestParam(required = false) Double sulfurDioxide,
            @RequestParam(required = false) Double sulfurDioxideLt,
            @RequestParam(required = false) Double sulfurDioxideLte,
            @RequestParam(required = false) Double sulfurDioxideGt,
            @RequestParam(required = false) Double sulfurDioxideGte,
            @RequestParam(required = false) Double nitrogenDioxide,
            @RequestParam(required = false) Double nitrogenDioxideLt,
            @RequestParam(required = false) Double nitrogenDioxideLte,
            @RequestParam(required = false) Double nitrogenDioxideGt,
            @RequestParam(required = false) Double nitrogenDioxideGte,
            @RequestParam(required = false) Double carbonMonoxide,
            @RequestParam(required = false) Double carbonMonoxideLt,
            @RequestParam(required = false) Double carbonMonoxideLte,
            @RequestParam(required = false) Double carbonMonoxideGt,
            @RequestParam(required = false) Double carbonMonoxideGte,
            @RequestParam(required = false) Double ozone,
            @RequestParam(required = false) Double ozoneLt,
            @RequestParam(required = false) Double ozoneLte,
            @RequestParam(required = false) Double ozoneGt,
            @RequestParam(required = false) Double ozoneGte,
            @RequestParam(required = false) Long fineDustTen,
            @RequestParam(required = false) Long fineDustTenLt,
            @RequestParam(required = false) Long fineDustTenLte,
            @RequestParam(required = false) Long fineDustTenGt,
            @RequestParam(required = false) Long fineDustTenGte,
            @RequestParam(required = false) Long fineDustTwentyFive,
            @RequestParam(required = false) Long fineDustTwentyFiveLt,
            @RequestParam(required = false) Long fineDustTwentyFiveLte,
            @RequestParam(required = false) Long fineDustTwentyFiveGt,
            @RequestParam(required = false) Long fineDustTwentyFiveGte,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int perPage) {

        Map <String, Object> params = new HashMap<>();

        params.put("yearMonth", yearMonth);
        params.put("yearMonthAfter", yearMonthAfter);
        params.put("yearMonthBefore", yearMonthBefore);
        params.put("location", location);
        params.put("locationContaining", locationContaining);
        params.put("sulfurDioxide", sulfurDioxide);
        params.put("sulfurDioxideLt", sulfurDioxideLt);
        params.put("sulfurDioxideLte", sulfurDioxideLte);
        params.put("sulfurDioxideGt", sulfurDioxideGt);
        params.put("sulfurDioxideGte", sulfurDioxideGte);
        params.put("nitrogenDioxide", nitrogenDioxide);
        params.put("nitrogenDioxideLt", nitrogenDioxideLt);
        params.put("nitrogenDioxideLte", nitrogenDioxideLte);
        params.put("nitrogenDioxideGt", nitrogenDioxideGt);
        params.put("nitrogenDioxideGte", nitrogenDioxideGte);
        params.put("carbonMonoxide", carbonMonoxide);
        params.put("carbonMonoxideLt", carbonMonoxideLt);
        params.put("carbonMonoxideLte", carbonMonoxideLte);
        params.put("carbonMonoxideGt", carbonMonoxideGt);
        params.put("carbonMonoxideGte", carbonMonoxideGte);
        params.put("ozone", ozone);
        params.put("ozoneLt", ozoneLt);
        params.put("ozoneLte", ozoneLte);
        params.put("ozoneGt", ozoneGt);
        params.put("ozoneGte", ozoneGte);
        params.put("fineDustTen", fineDustTen);
        params.put("fineDustTenLt", fineDustTenLt);
        params.put("fineDustTenLte", fineDustTenLte);
        params.put("fineDustTenGt", fineDustTenGt);
        params.put("fineDustTenGte", fineDustTenGte);
        params.put("fineDustTwentyFive", fineDustTwentyFive);
        params.put("fineDustTwentyFiveLt", fineDustTwentyFiveLt);
        params.put("fineDustTwentyFiveLte", fineDustTwentyFiveLte);
        params.put("fineDustTwentyFiveGt", fineDustTwentyFiveGt);
        params.put("fineDustTwentyFiveGte", fineDustTwentyFiveGte);

        return service.search(params, page, perPage);
    }
}
