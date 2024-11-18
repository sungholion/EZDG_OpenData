package com.openmind.ezdg_api_server.daegu_october_resident_registered_population_generation_status;

import com.openmind.ezdg_api_server.daegu_october_resident_registered_population_generation_status.DaeguOctoberResidentRegisteredPopulationGenerationStatusService;
import com.openmind.ezdg_api_server.daegu_october_resident_registered_population_generation_status.DaeguOctoberResidentRegisteredPopulationGenerationStatus;
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
@RequestMapping("/daegu_october_resident_registered_population_generation_status")
public class DaeguOctoberResidentRegisteredPopulationGenerationStatusController {

    private final DaeguOctoberResidentRegisteredPopulationGenerationStatusService service;

    @GetMapping("")
    public List<DaeguOctoberResidentRegisteredPopulationGenerationStatus> search (
            @RequestParam(required = false) String administrativeDistricts,
            @RequestParam(required = false) String administrativeDistrictsContaining,
        <            @RequestParam(required = false) String octoberTotalPopulation,
            @RequestParam(required = false) String octoberTotalPopulationContaining,
        <            @RequestParam(required = false) String octoberGeneration,
            @RequestParam(required = false) String octoberGenerationContaining,
        <            @RequestParam(required = false) String octoberPopulationPerGeneration,
            @RequestParam(required = false) String octoberPopulationPerGenerationContaining,
        <            @RequestParam(required = false) String octoberMalePopulation,
            @RequestParam(required = false) String octoberMalePopulationContaining,
        <            @RequestParam(required = false) String octoberFemalePopulation,
            @RequestParam(required = false) String octoberFemalePopulationContaining,
        <            @RequestParam(required = false) Double octoberMaleRatio,
        <            @RequestParam(required = false) Double octoberMaleRatioLt,
            @RequestParam(required = false) Double octoberMaleRatioLte,
            @RequestParam(required = false) Double octoberMaleRatioGt,
            @RequestParam(required = false) Double octoberMaleRatioGte,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int perPage) {

        Map <String, Object> params = new HashMap<>();

        params.put("administrativeDistricts", administrativeDistricts);
        params.put("administrativeDistrictsContaining", administrativeDistrictsContaining);
        params.put("octoberTotalPopulation", octoberTotalPopulation);
        params.put("octoberTotalPopulationContaining", octoberTotalPopulationContaining);
        params.put("octoberGeneration", octoberGeneration);
        params.put("octoberGenerationContaining", octoberGenerationContaining);
        params.put("octoberPopulationPerGeneration", octoberPopulationPerGeneration);
        params.put("octoberPopulationPerGenerationContaining", octoberPopulationPerGenerationContaining);
        params.put("octoberMalePopulation", octoberMalePopulation);
        params.put("octoberMalePopulationContaining", octoberMalePopulationContaining);
        params.put("octoberFemalePopulation", octoberFemalePopulation);
        params.put("octoberFemalePopulationContaining", octoberFemalePopulationContaining);
        params.put("octoberMaleRatio", octoberMaleRatio);
        params.put("octoberMaleRatioLt", octoberMaleRatioLt);
        params.put("octoberMaleRatioLte", octoberMaleRatioLte);
        params.put("octoberMaleRatioGt", octoberMaleRatioGt);
        params.put("octoberMaleRatioGte", octoberMaleRatioGte);

        return service.search(params, page, perPage);
    }
}
