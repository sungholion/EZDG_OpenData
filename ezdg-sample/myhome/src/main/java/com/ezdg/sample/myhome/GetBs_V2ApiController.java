package com.ezdg.sample.myhome;

import GetCorpBasicInfoService.*;
import GetFinaStatInfoService.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
public class GetBs_V2ApiController {

    // 메인 페이지
    @GetMapping("/")
    public String showHomePage() {
        return "main";
    }

    // 기본 정보 조회
    @GetMapping("/submitForm")
    public String handleBasicSubmission(
            @RequestParam("corpNm") String corpNm,
            @RequestParam("numOfRows") String numOfRows,
            @RequestParam("pageNo") int pageNo,
            @RequestParam("resultType") String resultType,
            Model model) {

        try {
            GetCorpOutline_V2Api api3 = new GetCorpOutline_V2Api()
                    .corpNm(URLEncoder.encode(corpNm, StandardCharsets.UTF_8))
                    .numOfRows(numOfRows)
                    .pageNo(String.valueOf(pageNo))
                    .resultType(resultType)
                    .ServiceKey(URLEncoder.encode("AjfNwt5gGi7y9HqihqAb4uGiX5wOhFAu5uhT++n9jwuoU6ZMOGo1nny/WyxcZG1LzOFicbztT6huskonphWasQ==", StandardCharsets.UTF_8));

            GetCorpOutline_V2ApiResponse basicInfoResponse = api3.fetch();
            int totalCount = Integer.parseInt(basicInfoResponse.getResponse().getBody().getTotalCount());
            int totalPages = (int) Math.ceil((double) totalCount / Integer.parseInt(numOfRows));

            model.addAttribute("basicResponse", basicInfoResponse);
            model.addAttribute("totalPages", totalPages);
            model.addAttribute("currentPage", pageNo);
            model.addAttribute("numOfRows", numOfRows);
            model.addAttribute("corpNm", corpNm);

        } catch (Exception e) {
            model.addAttribute("basicError", "API 요청에 실패했습니다: " + e.getMessage());
        }

        return "main";
    }

    //  재무 조회
    @GetMapping("/submitFinForm")
    public String handleFinSubmission(
            @RequestParam("crno") String crno,
            @RequestParam("corpNm") String corpNm,
            @RequestParam(value = "bizYear", defaultValue = "2023") String bizYear,
            Model model) {

        try {
            GetIncoStat_V2Api api2 = new GetIncoStat_V2Api()
                    .numOfRows("10")
                    .pageNo("1")
                    .resultType("json")
                    .serviceKey(URLEncoder.encode("AjfNwt5gGi7y9HqihqAb4uGiX5wOhFAu5uhT++n9jwuoU6ZMOGo1nny/WyxcZG1LzOFicbztT6huskonphWasQ==", StandardCharsets.UTF_8))
                    .crno(crno)
                    .bizYear(bizYear);

            GetSummFinaStat_V2Api api3 = new GetSummFinaStat_V2Api()
                    .numOfRows("10")
                    .pageNo("1")
                    .resultType("json")
                    .serviceKey(URLEncoder.encode("AjfNwt5gGi7y9HqihqAb4uGiX5wOhFAu5uhT++n9jwuoU6ZMOGo1nny/WyxcZG1LzOFicbztT6huskonphWasQ==", StandardCharsets.UTF_8))
                    .crno(crno)
                    .bizYear(bizYear);

            // 재무 상태 조회
            GetIncoStat_V2ApiResponse statResponse = api2.fetch(); // 손익계산서
            GetSummFinaStat_V2ApiResponse sumResponse = api3.fetch(); // 요약재무제표

            System.out.println(statResponse.toString());
            System.out.println(sumResponse.toString());

            // 응답 데이터를 모델에 추가
            model.addAttribute("statResponse", statResponse);
            model.addAttribute("summResponse", sumResponse);
            model.addAttribute("corpNm", corpNm);
            model.addAttribute("crno", crno);

        } catch (Exception e) {
            model.addAttribute("finError", "API 요청에 실패했습니다: " + e.getMessage());
        }
        return "financial_form";
    }
}