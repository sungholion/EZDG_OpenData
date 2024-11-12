package com.ezdg.sample.myhome;

import GetCorpBasicInfoService.*;
import GetFinaStatInfoService.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GetBs_V2ApiController {

    @GetMapping("/")
    public String showHomePage() {
        return "main";  // main.html을 반환
    }

    @GetMapping("/financial-form")
    public String showFinancialForm() {
        return "financial_form";  // financial_form.html 화면을 반환
    }

    @GetMapping("/basic-info-form")
    public String showBasicInfoForm(){
        return "basic_info_form"; // 기업 기본 정보 폼 화면을 반환
    }

    // 재무 조회
    @PostMapping("/submit-fin-info")
    public String handleFinSubmission(
            @RequestParam("crno") String crno,
            @RequestParam(value = "bizYear", required = false) String bizYear,
            Model model) {

        try {
            GetBs_V2Api api = new GetBs_V2Api()
                    .numOfRows("10")
                    .pageNo("1")
                    .resultType("json")
                    .serviceKey("AjfNwt5gGi7y9HqihqAb4uGiX5wOhFAu5uhT%2B%2Bn9jwuoU6ZMOGo1nny%2FWyxcZG1LzOFicbztT6huskonphWasQ%3D%3D")
                    .crno(crno);

            GetIncoStat_V2Api api2 = new GetIncoStat_V2Api()
                    .numOfRows("10")
                    .pageNo("1")
                    .resultType("json")
                    .serviceKey("AjfNwt5gGi7y9HqihqAb4uGiX5wOhFAu5uhT%2B%2Bn9jwuoU6ZMOGo1nny%2FWyxcZG1LzOFicbztT6huskonphWasQ%3D%3D")
                    .crno(crno);

            GetSummFinaStat_V2Api api3 = new GetSummFinaStat_V2Api()
                    .numOfRows("10")
                    .pageNo("1")
                    .resultType("json")
                    .serviceKey("AjfNwt5gGi7y9HqihqAb4uGiX5wOhFAu5uhT%2B%2Bn9jwuoU6ZMOGo1nny%2FWyxcZG1LzOFicbztT6huskonphWasQ%3D%3D")
                    .crno(crno);

            if (bizYear != null) {
                api.bizYear(bizYear);
                api2.bizYear(bizYear);
                api3.bizYear(bizYear);
            }

            // 재무 상태표 조회
            GetBs_V2ApiResponse response1 = api.fetch();
            // 요약 재무제표 조회
            GetIncoStat_V2ApiResponse response2 = api2.fetch();
            // 손익 계산서 조회
            GetSummFinaStat_V2ApiResponse response3 = api3.fetch();

            System.out.println(response1.toString());
            System.out.println(response2.toString());
            System.out.println(response3.toString());

            // 응답 데이터를 모델에 추가
            model.addAttribute("response", response1);
            return "fin_result";  // fin_result.html 화면에서 응답을 보여줌

        } catch (Exception e) {
            model.addAttribute("error", "API 요청에 실패했습니다: " + e.getMessage());
            return "error";  // 오류 화면을 반환
        }
    }
    // 재무 조회
    @PostMapping("/submit-basic-info")
    public String handleBasicSubmission(
            @RequestParam(value = "basDt", required = false) String basdt,
            @RequestParam("crno") String crno,
            @RequestParam(value = "afilCmpyNm", required = false) String afilCmpyNm,
            @RequestParam(value = "sbrdEnpNm", required = false) String sbrdEnpNm,
            @RequestParam(value = "corpNm", required = false) String corpNm,
            Model model) {

        try {
            GetAffiliate_V2Api api = new GetAffiliate_V2Api()
                    .numOfRows("10")
                    .pageNo("1")
                    .resultType("json")
                    .ServiceKey("AjfNwt5gGi7y9HqihqAb4uGiX5wOhFAu5uhT%2B%2Bn9jwuoU6ZMOGo1nny%2FWyxcZG1LzOFicbztT6huskonphWasQ%3D%3D")
                    .crno(crno);

            if(afilCmpyNm != null){
                api.afilCmpyNm(afilCmpyNm);
            }

            GetConsSubsComp_V2Api api2 = new GetConsSubsComp_V2Api()
                    .numOfRows("10")
                    .pageNo("1")
                    .resultType("json")
                    .ServiceKey("AjfNwt5gGi7y9HqihqAb4uGiX5wOhFAu5uhT%2B%2Bn9jwuoU6ZMOGo1nny%2FWyxcZG1LzOFicbztT6huskonphWasQ%3D%3D")
                    .crno(crno);

            if(sbrdEnpNm != null){
                api2.sbrdEnpNm(sbrdEnpNm);
            }

            GetCorpOutline_V2Api api3 = new GetCorpOutline_V2Api()
                    .numOfRows("10")
                    .pageNo("1")
                    .resultType("json")
                    .ServiceKey("AjfNwt5gGi7y9HqihqAb4uGiX5wOhFAu5uhT%2B%2Bn9jwuoU6ZMOGo1nny%2FWyxcZG1LzOFicbztT6huskonphWasQ%3D%3D")
                    .crno(crno);

            if(corpNm != null){
                api3.corpNm(corpNm);
            }

            // 재무 상태표 조회
            GetAffiliate_V2ApiResponse response1 = api.fetch();
            // 요약 재무제표 조회
            GetConsSubsComp_V2ApiResponse response2 = api2.fetch();
            // 손익 계산서 조회
            GetCorpOutline_V2ApiResponse response3 = api3.fetch();

            System.out.println(response1.toString());
            System.out.println(response2.toString());
            System.out.println(response3.toString());

            // 응답 데이터를 모델에 추가
            model.addAttribute("response", response3);
            return "basic_info_result";  // fin_result.html 화면에서 응답을 보여줌

        } catch (Exception e) {
            model.addAttribute("error", "API 요청에 실패했습니다: " + e.getMessage());
            return "error";  // 오류 화면을 반환
        }
    }
}