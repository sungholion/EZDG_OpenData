package com.ssafy.ezdg.Test;

import com.ssafy.ezdg.Test.TestService;
import com.ssafy.ezdg.Test.Test;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("test")
@RequiredArgsConstructor
public class TestController {
    private final TestService service;

    @GetMapping("")
    public List<Test> search(
        @RequestParam(required = false) String region,
        @RequestParam(required = false) String regionContaining,
        @RequestParam(required = false) Double temperature,
        @RequestParam(required = false) Double temperatureLt,
        @RequestParam(required = false) Double temperatureLte,
        @RequestParam(required = false) Double temperatureGt,
        @RequestParam(required = false) Double temperatureGte,
        @RequestParam(required = false, defaultValue = "0") int page,
        @RequestParam(required = false, defaultValue = "10") int perPage
    ) {
        Map<String, Object> params = new HashMap<>();
        params.put("region", region);
        params.put("regionContaining", regionContaining);
        params.put("temperature", temperature);
        params.put("temperatureLt", temperatureLt);
        params.put("temperatureLte", temperatureLte);
        params.put("temperatureGt", temperatureGt);
        params.put("temperatureGte", temperatureGte);

        return service.search(params, page, perPage);
    }
}
