package com.openmind.ezdg.admin;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {

    /**
     * 관리자 페이지 호출
     */
    @GetMapping()
    public String getAdminPage(HttpSession session, Model model) {
        log.info("request get admin page");
        // 배포 테스트
        session.setAttribute("isAuth", true);
        Boolean isAuth = (Boolean) session.getAttribute("isAuth");
        model.addAttribute("isAuth", isAuth != null && isAuth);
        return "views/admin";
    }

    /**
     * 관리자 코드 인증
     */
    @PostMapping("/authenticate")
    public String authenticate(@RequestParam("code") String adminCode, HttpSession session, RedirectAttributes redirectAttributes) {
        log.info("request authenticate admin code {}", adminCode);
        boolean isSuccess = "openmind".equals(adminCode);

        // 배포 테스트
        isSuccess = true;
//        session.setAttribute("isAuth", isSuccess);

        redirectAttributes.addFlashAttribute("isSuccess", isSuccess);
        return "redirect:/admin";
    }

    /**
     * 로그아웃
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 무효화 (로그아웃)
        return "redirect:/admin";
    }

    /**
     * file 업로드 페이지 호출
     */
    @GetMapping("/file")
    public String filePage(@SessionAttribute(value = "isAuth", required = false) Boolean isAuth) {
        if (Boolean.TRUE.equals(isAuth)) {
            return "views/file/file"; // 인증된 경우 파일 페이지로 이동
        }
        return "redirect:/admin"; // 인증되지 않은 경우 admin 페이지로 리다이렉트
    }

    /**
     * openapi url 업로드 페이지 호출
     */
    @GetMapping("/openapi")
    public String openApiPage(@SessionAttribute(value = "isAuth", required = false) Boolean isAuth) {
        if (Boolean.TRUE.equals(isAuth)) {
            return "views/api/api"; // 인증된 경우 Open API 페이지로 이동
        }
        return "redirect:/admin"; // 인증되지 않은 경우 admin 페이지로 리다이렉트
    }

    /**
     * 배포 현황 페이지 호출
     */
    @GetMapping("/deploy")
    public String deployPage(@SessionAttribute(value = "isAuth", required = false) Boolean isAuth) {
        if (Boolean.TRUE.equals(isAuth)) {
            return "views/deploy/deploy"; // 인증된 경우 배포 현황 페이지로 이동
        }
        return "redirect:/admin"; // 인증되지 않은 경우 admin 페이지로 리다이렉트
    }

    /**
     * 데이터 신청 내역 페이지 호출
     */
    @GetMapping("/data")
    public String dataRequestPage(@SessionAttribute(value = "isAuth", required = false) Boolean isAuth) {
        if (Boolean.TRUE.equals(isAuth)) {
            return "views/data/data"; // 인증된 경우 배포 현황 페이지로 이동
        }
        return "redirect:/admin";
    }
}
