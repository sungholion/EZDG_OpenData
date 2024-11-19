package com.openmind.ezdg_api_server.gumi_library_information;

import com.openmind.ezdg_api_server.gumi_library_information.GumiLibraryInformationService;
import com.openmind.ezdg_api_server.gumi_library_information.GumiLibraryInformation;
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
@RequestMapping("/gumi_library_information")
public class GumiLibraryInformationController {

    private final GumiLibraryInformationService service;

    @GetMapping("")
    public List<GumiLibraryInformation> search (
            @RequestParam(required = false) Long order,
            @RequestParam(required = false) Long orderLt,
            @RequestParam(required = false) Long orderLte,
            @RequestParam(required = false) Long orderGt,
            @RequestParam(required = false) Long orderGte,
            @RequestParam(required = false) String magazineName,
            @RequestParam(required = false) String magazineNameContaining,
            @RequestParam(required = false) String placeOfIssue,
            @RequestParam(required = false) String placeOfIssueContaining,
            @RequestParam(required = false) String period,
            @RequestParam(required = false) String periodContaining,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String locationContaining,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int perPage) {

        Map <String, Object> params = new HashMap<>();

        params.put("order", order);
        params.put("orderLt", orderLt);
        params.put("orderLte", orderLte);
        params.put("orderGt", orderGt);
        params.put("orderGte", orderGte);
        params.put("magazineName", magazineName);
        params.put("magazineNameContaining", magazineNameContaining);
        params.put("placeOfIssue", placeOfIssue);
        params.put("placeOfIssueContaining", placeOfIssueContaining);
        params.put("period", period);
        params.put("periodContaining", periodContaining);
        params.put("location", location);
        params.put("locationContaining", locationContaining);

        return service.search(params, page, perPage);
    }
}
