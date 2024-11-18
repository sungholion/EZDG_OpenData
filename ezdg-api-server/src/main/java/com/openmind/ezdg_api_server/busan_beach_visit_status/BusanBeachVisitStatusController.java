package com.openmind.ezdg_api_server.busan_beach_visit_status;

import com.openmind.ezdg_api_server.busan_beach_visit_status.BusanBeachVisitStatusService;
import com.openmind.ezdg_api_server.busan_beach_visit_status.BusanBeachVisitStatus;
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
@RequestMapping("/busan_beach_visit_status")
public class BusanBeachVisitStatusController {

    private final BusanBeachVisitStatusService service;

    @GetMapping("")
    public List<BusanBeachVisitStatus> search (
            @RequestParam(required = false) Long byYear,
        <            @RequestParam(required = false) Long byYearLt,
            @RequestParam(required = false) Long byYearLte,
            @RequestParam(required = false) Long byYearGt,
            @RequestParam(required = false) Long byYearGte,
            @RequestParam(required = false) String sido,
            @RequestParam(required = false) String sidoContaining,
        <            @RequestParam(required = false) String gugun,
            @RequestParam(required = false) String gugunContaining,
        <            @RequestParam(required = false) String beachName,
            @RequestParam(required = false) String beachNameContaining,
        <            @RequestParam(required = false) Long scale,
        <            @RequestParam(required = false) Long scaleLt,
            @RequestParam(required = false) Long scaleLte,
            @RequestParam(required = false) Long scaleGt,
            @RequestParam(required = false) Long scaleGte,
            @RequestParam(required = false) String numberOfVisitors,
            @RequestParam(required = false) String numberOfVisitorsContaining,
        <            @RequestParam(required = false) String openingDate,
            @RequestParam(required = false) String openingDateContaining,
        <            @RequestParam(required = false) String closingDate,
            @RequestParam(required = false) String closingDateContaining,
        <            @RequestParam(required = false) String notice,
            @RequestParam(required = false) String noticeContaining,
        <            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int perPage) {

        Map <String, Object> params = new HashMap<>();

        params.put("byYear", byYear);
        params.put("byYearLt", byYearLt);
        params.put("byYearLte", byYearLte);
        params.put("byYearGt", byYearGt);
        params.put("byYearGte", byYearGte);
        params.put("sido", sido);
        params.put("sidoContaining", sidoContaining);
        params.put("gugun", gugun);
        params.put("gugunContaining", gugunContaining);
        params.put("beachName", beachName);
        params.put("beachNameContaining", beachNameContaining);
        params.put("scale", scale);
        params.put("scaleLt", scaleLt);
        params.put("scaleLte", scaleLte);
        params.put("scaleGt", scaleGt);
        params.put("scaleGte", scaleGte);
        params.put("numberOfVisitors", numberOfVisitors);
        params.put("numberOfVisitorsContaining", numberOfVisitorsContaining);
        params.put("openingDate", openingDate);
        params.put("openingDateContaining", openingDateContaining);
        params.put("closingDate", closingDate);
        params.put("closingDateContaining", closingDateContaining);
        params.put("notice", notice);
        params.put("noticeContaining", noticeContaining);

        return service.search(params, page, perPage);
    }
}
