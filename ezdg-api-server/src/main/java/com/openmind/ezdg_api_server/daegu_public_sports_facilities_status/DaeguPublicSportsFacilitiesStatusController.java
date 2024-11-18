package com.openmind.ezdg_api_server.daegu_public_sports_facilities_status;

import com.openmind.ezdg_api_server.daegu_public_sports_facilities_status.DaeguPublicSportsFacilitiesStatusService;
import com.openmind.ezdg_api_server.daegu_public_sports_facilities_status.DaeguPublicSportsFacilitiesStatus;
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
@RequestMapping("/daegu_public_sports_facilities_status")
public class DaeguPublicSportsFacilitiesStatusController {

    private final DaeguPublicSportsFacilitiesStatusService service;

    @GetMapping("")
    public List<DaeguPublicSportsFacilitiesStatus> search (
            @RequestParam(required = false) String facilityName,
            @RequestParam(required = false) String facilityNameContaining,
        <            @RequestParam(required = false) String managementEntity,
            @RequestParam(required = false) String managementEntityContaining,
        <            @RequestParam(required = false) String siteArea,
            @RequestParam(required = false) String siteAreaContaining,
        <            @RequestParam(required = false) String numberOfSeats,
            @RequestParam(required = false) String numberOfSeatsContaining,
        <            @RequestParam(required = false) String numberOfPeople,
            @RequestParam(required = false) String numberOfPeopleContaining,
        <            @RequestParam(required = false) Long completionYear,
        <            @RequestParam(required = false) Long completionYearLt,
            @RequestParam(required = false) Long completionYearLte,
            @RequestParam(required = false) Long completionYearGt,
            @RequestParam(required = false) Long completionYearGte,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int perPage) {

        Map <String, Object> params = new HashMap<>();

        params.put("facilityName", facilityName);
        params.put("facilityNameContaining", facilityNameContaining);
        params.put("managementEntity", managementEntity);
        params.put("managementEntityContaining", managementEntityContaining);
        params.put("siteArea", siteArea);
        params.put("siteAreaContaining", siteAreaContaining);
        params.put("numberOfSeats", numberOfSeats);
        params.put("numberOfSeatsContaining", numberOfSeatsContaining);
        params.put("numberOfPeople", numberOfPeople);
        params.put("numberOfPeopleContaining", numberOfPeopleContaining);
        params.put("completionYear", completionYear);
        params.put("completionYearLt", completionYearLt);
        params.put("completionYearLte", completionYearLte);
        params.put("completionYearGt", completionYearGt);
        params.put("completionYearGte", completionYearGte);

        return service.search(params, page, perPage);
    }
}
