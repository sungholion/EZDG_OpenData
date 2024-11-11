package com.openmind.ezdg.api.controller;

import com.openmind.ezdg.api.dto.UrlAndCrollingOptionRequestDto;
import com.openmind.ezdg.api.service.OpenApiService;
import com.openmind.ezdg.datalist.dto.ApiDataDto;
import com.openmind.ezdg.datalist.service.DatalistService;
import com.openmind.ezdg.generate.library.openapi.FastApiResponseDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/openapi")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OpenApiController {

    @Value("${admin.base-url}")
    private String baseUrl;

    private final OpenApiService openApiService;
    private final DatalistService datalistService;

    /**
     * 호출 시점: url 입력 후 다음 버튼 클릭 시
     */
    @PostMapping()
    @ResponseBody
    public Map<String, Object> analyzeUrl(@RequestBody UrlAndCrollingOptionRequestDto request) {
        log.info("[OpenApiController] request get url {}, {}", request.getUrl(), request.getCrollerOption()) ;
        Map<String, Object> response = new HashMap<>();

        // 크롤링
        ApiDataDto apiData = openApiService.callFastApiCroller(request.getUrl(), request.getCrollerOption());

        // 중복검사
        List<FastApiResponseDto> apiList = apiData.getApiList();
        for (FastApiResponseDto res : apiList) {
            String name = res.getClassName();
            boolean isDuplicatedName = datalistService.isDuplicatedTranslatedName(name);
            if(isDuplicatedName) {
                throw new RuntimeException("중복된 클래스가 존재합니다.");
            }
        }

        if ("/admin".equals(baseUrl)) {
            response.put("saveUrl", "/openapi/save-data");
            response.put("redirectUrl", "/openapi/save");
        } else if ("".equals(baseUrl)) {
            response.put("saveUrl", "/admin/openapi/save-data");
            response.put("redirectUrl", "/admin/openapi/save");
        }
        response.put("response", apiData);

        return response;
    }

    @PostMapping("/save-data")
    @ResponseBody
    public ResponseEntity<Void> saveApiData(@RequestBody Map<String, Object> data, HttpSession session) {
        log.info("[OpenApiController] request save api data");
        session.setAttribute("apiData", data.get("response"));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/save")
    public String getApiSavePage(Model model, HttpSession session) {
        log.info("[OpenApiController] get api save page");
        model.addAttribute("apiData", session.getAttribute("apiData"));

        return "views/api/save";
    }

    /**
     * 호출 시점: save 페이지에서 저장 버튼 클릭 시
     */
    @PostMapping("/save")
    public String saveApi() {
        // TODO 본 메서드 파라미터에서 api명, request 파라미터, response 파라미터 받아야 함
        // TODO 자동화 코드 생성
        return "views/api/api-complete";
    }
}
