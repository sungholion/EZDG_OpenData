package com.openmind.ezdg_api_server.daegu_local_company_information_status;

import com.openmind.ezdg_api_server.daegu_local_company_information_status.DaeguLocalCompanyInformationStatusService;
import com.openmind.ezdg_api_server.daegu_local_company_information_status.DaeguLocalCompanyInformationStatus;
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
@RequestMapping("/daegu_local_company_information_status")
public class DaeguLocalCompanyInformationStatusController {

    private final DaeguLocalCompanyInformationStatusService service;

    @GetMapping("")
    public List<DaeguLocalCompanyInformationStatus> search (
            @RequestParam(required = false) String companyName,
            @RequestParam(required = false) String companyNameContaining,
            @RequestParam(required = false) String companySize,
            @RequestParam(required = false) String companySizeContaining,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int perPage) {

        Map <String, Object> params = new HashMap<>();

        params.put("companyName", companyName);
        params.put("companyNameContaining", companyNameContaining);
        params.put("companySize", companySize);
        params.put("companySizeContaining", companySizeContaining);

        return service.search(params, page, perPage);
    }
}
