package com.openmind.ezdg_api_server.daegu_education_school_status;

import com.openmind.ezdg_api_server.daegu_education_school_status.DaeguEducationSchoolStatusService;
import com.openmind.ezdg_api_server.daegu_education_school_status.DaeguEducationSchoolStatus;
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
@RequestMapping("/daegu_education_school_status")
public class DaeguEducationSchoolStatusController {

    private final DaeguEducationSchoolStatusService service;

    @GetMapping("")
    public List<DaeguEducationSchoolStatus> search (
            @RequestParam(required = false) String schoolName,
            @RequestParam(required = false) String schoolNameContaining,
        <            @RequestParam(required = false) String districtCountyOffice,
            @RequestParam(required = false) String districtCountyOfficeContaining,
        <            @RequestParam(required = false) String address,
            @RequestParam(required = false) String addressContaining,
        <            @RequestParam(required = false) Long postcode,
        <            @RequestParam(required = false) Long postcodeLt,
            @RequestParam(required = false) Long postcodeLte,
            @RequestParam(required = false) Long postcodeGt,
            @RequestParam(required = false) Long postcodeGte,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String phoneNumberContaining,
        <            @RequestParam(required = false) String faxNumber,
            @RequestParam(required = false) String faxNumberContaining,
        <            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int perPage) {

        Map <String, Object> params = new HashMap<>();

        params.put("schoolName", schoolName);
        params.put("schoolNameContaining", schoolNameContaining);
        params.put("districtCountyOffice", districtCountyOffice);
        params.put("districtCountyOfficeContaining", districtCountyOfficeContaining);
        params.put("address", address);
        params.put("addressContaining", addressContaining);
        params.put("postcode", postcode);
        params.put("postcodeLt", postcodeLt);
        params.put("postcodeLte", postcodeLte);
        params.put("postcodeGt", postcodeGt);
        params.put("postcodeGte", postcodeGte);
        params.put("phoneNumber", phoneNumber);
        params.put("phoneNumberContaining", phoneNumberContaining);
        params.put("faxNumber", faxNumber);
        params.put("faxNumberContaining", faxNumberContaining);

        return service.search(params, page, perPage);
    }
}
