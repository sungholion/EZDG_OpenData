package com.ezdg.sample.findMyCompany;

import com.openmind.ezdg.GetCorpBasicInfoService.*;
import com.openmind.ezdg.GetFinaStatInfoService.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class MainController {

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
            CorpOutline api3 = new CorpOutline("AjfNwt5gGi7y9HqihqAb4uGiX5wOhFAu5uhT++n9jwuoU6ZMOGo1nny/WyxcZG1LzOFicbztT6huskonphWasQ==")
                    .corpNm(corpNm)
                    .numOfRows(numOfRows)
                    .pageNo(String.valueOf(pageNo))
                    .resultType(resultType);

            CorpOutlineResponse basicInfoResponse = api3.fetch();
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
            IncoStat api2 = new IncoStat("AjfNwt5gGi7y9HqihqAb4uGiX5wOhFAu5uhT++n9jwuoU6ZMOGo1nny/WyxcZG1LzOFicbztT6huskonphWasQ==")
                    .numOfRows("10")
                    .pageNo("1")
                    .resultType("json")
                    .crno(crno)
                    .bizYear(bizYear);

            SummFinaStat api3 = new SummFinaStat("AjfNwt5gGi7y9HqihqAb4uGiX5wOhFAu5uhT++n9jwuoU6ZMOGo1nny/WyxcZG1LzOFicbztT6huskonphWasQ==")
                    .numOfRows("10")
                    .pageNo("1")
                    .resultType("json")
                    .crno(crno)
                    .bizYear(bizYear);

            // 재무 상태 조회
            IncoStatResponse statResponse = api2.fetch(); // 손익계산서
            SummFinaStatResponse sumResponse = api3.fetch(); // 요약재무제표

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