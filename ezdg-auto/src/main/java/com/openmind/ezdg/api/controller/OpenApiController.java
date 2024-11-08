package com.openmind.ezdg.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/openapi")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OpenApiController {

    /**
     * 호출 시점: url 입력 후 다음 버튼 클릭 시
     */
    @PostMapping()
    public String analyzeUrl(@RequestParam String url, RedirectAttributes redirectAttributes) {
        // TODO 크롤링
        // TODO 중복검사(API명 중복되는거 있는지)
        // TODO api명, request 파라미터, response 파라미터 redirectAttributes에 담기
        return "redirect:/openapi/save";
    }

    /**
     * 호출 시점: 위 analyzeUrl 메서드가 return되면 호출
     */
    @GetMapping("/save")
    public String getApiSavePage(Model model) {
        // TODO api명, request 파라미터, response 파라미터를 model에 담아서 return
        // TODO save view 페이지 구현
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
