package com.openmind.ezdg_api_server.busan_protection_cctv_information;

import com.openmind.ezdg_api_server.busan_protection_cctv_information.BusanProtectionCctvInformationService;
import com.openmind.ezdg_api_server.busan_protection_cctv_information.BusanProtectionCctvInformation;
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
@RequestMapping("/busan_protection_cctv_information")
public class BusanProtectionCctvInformationController {

    private final BusanProtectionCctvInformationService service;

    @GetMapping("")
    public List<BusanProtectionCctvInformation> search (
            @RequestParam(required = false) String cctvName,
            @RequestParam(required = false) String cctvNameContaining,
            @RequestParam(required = false) String cctvCoordinates,
            @RequestParam(required = false) String cctvCoordinatesContaining,
            @RequestParam(required = false) String cctvGroup,
            @RequestParam(required = false) String cctvGroupContaining,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int perPage) {

        Map <String, Object> params = new HashMap<>();

        params.put("cctvName", cctvName);
        params.put("cctvNameContaining", cctvNameContaining);
        params.put("cctvCoordinates", cctvCoordinates);
        params.put("cctvCoordinatesContaining", cctvCoordinatesContaining);
        params.put("cctvGroup", cctvGroup);
        params.put("cctvGroupContaining", cctvGroupContaining);

        return service.search(params, page, perPage);
    }
}
