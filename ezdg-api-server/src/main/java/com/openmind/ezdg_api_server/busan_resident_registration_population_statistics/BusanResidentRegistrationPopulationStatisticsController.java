package com.openmind.ezdg_api_server.busan_resident_registration_population_statistics;

import com.openmind.ezdg_api_server.busan_resident_registration_population_statistics.BusanResidentRegistrationPopulationStatisticsService;
import com.openmind.ezdg_api_server.busan_resident_registration_population_statistics.BusanResidentRegistrationPopulationStatistics;
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
@RequestMapping("/busan_resident_registration_population_statistics")
public class BusanResidentRegistrationPopulationStatisticsController {

    private final BusanResidentRegistrationPopulationStatisticsService service;

    @GetMapping("")
    public List<BusanResidentRegistrationPopulationStatistics> search (
            @RequestParam(required = false) String gugun,
            @RequestParam(required = false) String gugunContaining,
            @RequestParam(required = false) Long dongsu,
            @RequestParam(required = false) Long dongsuLt,
            @RequestParam(required = false) Long dongsuLte,
            @RequestParam(required = false) Long dongsuGt,
            @RequestParam(required = false) Long dongsuGte,
            @RequestParam(required = false) Long generation,
            @RequestParam(required = false) Long generationLt,
            @RequestParam(required = false) Long generationLte,
            @RequestParam(required = false) Long generationGt,
            @RequestParam(required = false) Long generationGte,
            @RequestParam(required = false) Long population,
            @RequestParam(required = false) Long populationLt,
            @RequestParam(required = false) Long populationLte,
            @RequestParam(required = false) Long populationGt,
            @RequestParam(required = false) Long populationGte,
            @RequestParam(required = false) Long malePopulation,
            @RequestParam(required = false) Long malePopulationLt,
            @RequestParam(required = false) Long malePopulationLte,
            @RequestParam(required = false) Long malePopulationGt,
            @RequestParam(required = false) Long malePopulationGte,
            @RequestParam(required = false) Long femalePopulation,
            @RequestParam(required = false) Long femalePopulationLt,
            @RequestParam(required = false) Long femalePopulationLte,
            @RequestParam(required = false) Long femalePopulationGt,
            @RequestParam(required = false) Long femalePopulationGte,
            @RequestParam(required = false) Double compositionRatio,
            @RequestParam(required = false) Double compositionRatioLt,
            @RequestParam(required = false) Double compositionRatioLte,
            @RequestParam(required = false) Double compositionRatioGt,
            @RequestParam(required = false) Double compositionRatioGte,
            @RequestParam(required = false) Double area,
            @RequestParam(required = false) Double areaLt,
            @RequestParam(required = false) Double areaLte,
            @RequestParam(required = false) Double areaGt,
            @RequestParam(required = false) Double areaGte,
            @RequestParam(required = false) Long populationDensity,
            @RequestParam(required = false) Long populationDensityLt,
            @RequestParam(required = false) Long populationDensityLte,
            @RequestParam(required = false) Long populationDensityGt,
            @RequestParam(required = false) Long populationDensityGte,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int perPage) {

        Map <String, Object> params = new HashMap<>();

        params.put("gugun", gugun);
        params.put("gugunContaining", gugunContaining);
        params.put("dongsu", dongsu);
        params.put("dongsuLt", dongsuLt);
        params.put("dongsuLte", dongsuLte);
        params.put("dongsuGt", dongsuGt);
        params.put("dongsuGte", dongsuGte);
        params.put("generation", generation);
        params.put("generationLt", generationLt);
        params.put("generationLte", generationLte);
        params.put("generationGt", generationGt);
        params.put("generationGte", generationGte);
        params.put("population", population);
        params.put("populationLt", populationLt);
        params.put("populationLte", populationLte);
        params.put("populationGt", populationGt);
        params.put("populationGte", populationGte);
        params.put("malePopulation", malePopulation);
        params.put("malePopulationLt", malePopulationLt);
        params.put("malePopulationLte", malePopulationLte);
        params.put("malePopulationGt", malePopulationGt);
        params.put("malePopulationGte", malePopulationGte);
        params.put("femalePopulation", femalePopulation);
        params.put("femalePopulationLt", femalePopulationLt);
        params.put("femalePopulationLte", femalePopulationLte);
        params.put("femalePopulationGt", femalePopulationGt);
        params.put("femalePopulationGte", femalePopulationGte);
        params.put("compositionRatio", compositionRatio);
        params.put("compositionRatioLt", compositionRatioLt);
        params.put("compositionRatioLte", compositionRatioLte);
        params.put("compositionRatioGt", compositionRatioGt);
        params.put("compositionRatioGte", compositionRatioGte);
        params.put("area", area);
        params.put("areaLt", areaLt);
        params.put("areaLte", areaLte);
        params.put("areaGt", areaGt);
        params.put("areaGte", areaGte);
        params.put("populationDensity", populationDensity);
        params.put("populationDensityLt", populationDensityLt);
        params.put("populationDensityLte", populationDensityLte);
        params.put("populationDensityGt", populationDensityGt);
        params.put("populationDensityGte", populationDensityGte);

        return service.search(params, page, perPage);
    }
}
