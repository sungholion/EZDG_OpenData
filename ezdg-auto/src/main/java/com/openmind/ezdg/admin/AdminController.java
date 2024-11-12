package com.openmind.ezdg.admin;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {

    @Value("${admin.base-url}")
    private String baseUrl;

    /**
     * 관리자 페이지 호출
     */
    @GetMapping("${admin.base-url}")
    public String getAdminPage(HttpSession session, Model model) {
        Boolean isAuth = (Boolean) session.getAttribute("isAuth");
        log.info("request get admin page, isAuth = {}", isAuth);
        model.addAttribute("isAuth", isAuth != null && isAuth);
        return "views/admin";
    }

    /**
     * 관리자 코드 인증
     */
    @PostMapping("${admin.base-url}/authenticate")
    @ResponseBody
    public Map<String, Object> authenticate(@RequestParam("code") String adminCode, HttpSession session) {
        log.info("request authenticate admin code {}", adminCode);
        boolean isSuccess = "openmind".equals(adminCode);

        session.setAttribute("isAuth", isSuccess);

        Map<String, Object> response = new HashMap<>();

        response.put("isSuccess", isSuccess);
        if (isSuccess) {
            response.put("redirectUrl", "/admin");
        } else {
            response.put("message", "잘못된 인증번호입니다.");
        }
        return response;
    }

    /**
     * 로그아웃
     */
    @GetMapping("${admin.base-url}/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 무효화 (로그아웃)
        return "redirect:/admin";
    }

    /**
     * file 업로드 페이지 호출
     */
    @GetMapping("${admin.base-url}/file")
    public String filePage(@SessionAttribute(value = "isAuth", required = false) Boolean isAuth, Model model) {
        if (Boolean.TRUE.equals(isAuth)) {
            if("/admin".equals(baseUrl)) {
                model.addAttribute("baseUrl", "");
            } else if("".equals(baseUrl)) {
                model.addAttribute("baseUrl", "/admin");
            }

            return "views/file/file"; // 인증된 경우 파일 페이지로 이동
        }
        return "redirect:" + baseUrl; // 인증되지 않은 경우 admin 페이지로 리다이렉트
    }

    /**
     * openapi url 업로드 페이지 호출
     */
    @GetMapping("${admin.base-url}/openapi")
    public String openApiPage(@SessionAttribute(value = "isAuth", required = false) Boolean isAuth, Model model) {
        if (Boolean.TRUE.equals(isAuth)) {
            if("/admin".equals(baseUrl)) {
                model.addAttribute("baseUrl", "");
            } else if("".equals(baseUrl)) {
                model.addAttribute("baseUrl", "/admin");
            }
            return "views/api/api"; // 인증된 경우 Open API 페이지로 이동
        }
        return "redirect:" + baseUrl; // 인증되지 않은 경우 admin 페이지로 리다이렉트
    }

    /**
     * 배포 현황 페이지 호출
     */
    @GetMapping("${admin.base-url}/deploy")
    public String deployPage(@SessionAttribute(value = "isAuth", required = false) Boolean isAuth, Model model) {
        if (Boolean.TRUE.equals(isAuth)) {
            if("/admin".equals(baseUrl)) {
                model.addAttribute("baseUrl", "");
            } else if("".equals(baseUrl)) {
                model.addAttribute("baseUrl", "/admin");
            }
            return "views/deploy/deploy"; // 인증된 경우 배포 현황 페이지로 이동
        }
        return "redirect:" + baseUrl; // 인증되지 않은 경우 admin 페이지로 리다이렉트
    }

    /**
     * 데이터 신청 내역 페이지 호출
     */
    @GetMapping("${admin.base-url}/data")
    public String dataRequestPage(@SessionAttribute(value = "isAuth", required = false) Boolean isAuth, Model model) {
        if (Boolean.TRUE.equals(isAuth)) {
            if("/admin".equals(baseUrl)) {
                model.addAttribute("baseUrl", "");
            } else if("".equals(baseUrl)) {
                model.addAttribute("baseUrl", "/admin");
            }
            return "views/data/data"; // 인증된 경우 배포 현황 페이지로 이동
        }
        return "redirect:" + baseUrl;
    }
}
