package com.openmind.ezdg_api_server.sido;

import com.openmind.ezdg_api_server.sido.SidoService;
import com.openmind.ezdg_api_server.sido.Sido;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("sido")
@RequiredArgsConstructor
public class SidoController {
private final SidoService service;

@GetMapping("")
public List<Sido> search(
    @RequestParam(required = false) String sido,
        @RequestParam(required = false) String sidoContaining,
    @RequestParam(required = false) String sigungu,
        @RequestParam(required = false) String sigunguContaining,
    @RequestParam(required = false) Long population,
        @RequestParam(required = false) Long populationLt,
        @RequestParam(required = false) Long populationLte,
        @RequestParam(required = false) Long populationGt,
        @RequestParam(required = false) Long populationGte,
    @RequestParam(required = false) LocalDate dateTimeOfCreation,
@RequestParam(required = false, defaultValue = "0") int page,
@RequestParam(required = false, defaultValue = "10") int perPage
) {
Map
<String, Object> params = new HashMap<>();
    params.put("sido", sido);
        params.put("sidoContaining", sidoContaining);
    params.put("sigungu", sigungu);
        params.put("sigunguContaining", sigunguContaining);
    params.put("population", population);
        params.put("populationLt", populationLt);
        params.put("populationLte", populationLte);
        params.put("populationGt", populationGt);
        params.put("populationGte", populationGte);
    params.put("dateTimeOfCreation", dateTimeOfCreation);

return service.search(params, page, perPage);
}
}
