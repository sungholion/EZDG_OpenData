package com.openmind.ezdg.generate.library.openapi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/generator")
@RequiredArgsConstructor
public class GeneratorController {

    private final FastApiCallService fastApiCallService;

    @GetMapping
    public String showForm() {
        log.info("GET /generator called");
        return "generator";
    }

    @PostMapping("/table")
    public String generateTableCode(@RequestParam String url, Model model) {
        log.info("POST /generator/table called with url: {}", url);
        try {
            List<FastApiResponseDto> results = fastApiCallService.tableFormApi(url);
            model.addAttribute("results", results);
            model.addAttribute("success", true);
            model.addAttribute("message", "Table 코드 생성이 완료되었습니다.");
        } catch (Exception e) {
            log.error("Error generating Table code", e);
            model.addAttribute("success", false);
            model.addAttribute("message", "Table 코드 생성 중 에러 발생: " + e.getMessage());
        }
        return "generator";
    }

    @PostMapping("/swagger")
    public String generateSwaggerCode(@RequestParam String url, Model model) {
        log.info("POST /generator/swagger called with url: {}", url);
        try {
            List<FastApiResponseDto> results = fastApiCallService.swaggerFormApi(url);
            model.addAttribute("results", results);
            model.addAttribute("success", true);
            model.addAttribute("message", "Swagger 코드 생성이 완료되었습니다.");
        } catch (Exception e) {
            log.error("Error generating Swagger code", e);
            model.addAttribute("success", false);
            model.addAttribute("message", "Swagger 코드 생성 중 에러 발생: " + e.getMessage());
        }
        return "generator";
    }
}
