package com.openmind.ezdg.file.controller;

import com.openmind.ezdg.datalist.service.DatalistService;
import com.openmind.ezdg.file.dto.filesave.FileDataRequestDto;
import com.openmind.ezdg.file.dto.filesave.FileInfoDto;
import com.openmind.ezdg.file.service.CsvSaveService;
import com.openmind.ezdg.file.service.SendAutoLibraryInfoService;
import com.openmind.ezdg.file.util.CsvUtil;
import com.openmind.ezdg.file.util.FileUtil;
import com.openmind.ezdg.generate.library.file.service.JavaFileLibraryGenerateService;
import com.openmind.ezdg.generate.server.service.APIServerGenerateService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/file")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CsvSaveController {

    private final CsvSaveService csvSaveService;
    private final SendAutoLibraryInfoService sendAutoLibraryInfoService;
    private final JavaFileLibraryGenerateService javaFileLibraryGenerateService;
    private final APIServerGenerateService apiServerGenerateService;
    private final CsvUtil csvUtil;
    private final FileUtil fileUtil;
    private final DatalistService datalistService;

    @Value("${admin.base-url}")
    private String baseUrl;

    /**
     * 파일 변환
     */
    @PostMapping()
    @ResponseBody
    public Map<String, Object> translateFile(@RequestParam("file") MultipartFile file,
                                             @RequestParam("code") String code) {
        log.info("[FileSaveController] request save file for {}", file.getOriginalFilename());
        Map<String, Object> response = new HashMap<>();

        boolean isSuccessFileSaveToTempPath = fileUtil.saveFileToTempPath(file);
        if (!isSuccessFileSaveToTempPath) {
            response.put("isSuccess", false);
            response.put("error", "파일을 저장하는 중 오류가 발생했습니다.");
            return response;
        }

        // 파일 이름 한<->영 번역 및 컨벤션 적용
        String translatedFileName = csvSaveService.getTranslatedFileName(file.getOriginalFilename());
        log.info("translated file name = {}", translatedFileName);

        // csv 파일 읽기 및 칼럼 변환
        String filePath = fileUtil.getFullPath(file.getOriginalFilename());
        List<String[]> datas = csvUtil.readCsvFile(filePath);
        List<String> originalColumns = csvSaveService.getOriginalColumns(datas);
        List<String> translatedColumns = csvSaveService.getTranslatedColumns(originalColumns);

        log.info("original columns = {}", originalColumns);
        log.info("translated columns = {}", translatedColumns);

        // 성공 응답 구성
        response.put("isSuccess", true);
        if ("/admin".equals(baseUrl)) {
            response.put("redirectUrl", "/file/save");
        } else if ("".equals(baseUrl)) {
            response.put("redirectUrl", "/admin/file/save");
        }

        response.put("originFileName", file.getOriginalFilename());
        response.put("translatedFileName", translatedFileName);
        response.put("originalColumns", originalColumns);
        response.put("translatedColumns", translatedColumns);
        response.put("fileName", file.getOriginalFilename());
        response.put("code", code);

        return response;
    }

    /**
     * 파일 저장 페이지 호출
     */
    @PostMapping("/save-data")
    @ResponseBody
    public ResponseEntity<Void> saveFileData(@RequestBody Map<String, Object> data, HttpSession session) {
        log.info("[FileSaveController] request file save data {}", data.toString());
        session.setAttribute("fileData", data);
        return ResponseEntity.ok().build();
    }

    /**
     * 파일 저장 페이지 호출
     */
    @GetMapping("/save")
    public String getFileSavePage(HttpSession session, Model model) {
        log.info("[FileSaveController] request get file save page");
        Map<String, Object> fileData = (Map<String, Object>) session.getAttribute("fileData");
        if (fileData != null) {
            model.addAttribute("fileData", fileData);
            session.removeAttribute("fileData");
        }
        if ("/admin".equals(baseUrl)) {
            model.addAttribute("baseUrl", "");
        } else if ("".equals(baseUrl)) {
            model.addAttribute("baseUrl", "/admin");
        }
        return "views/file/translate";
    }

    /**
     * 파일 저장
     */
    @PostMapping("/save")
    @ResponseBody
    public Map<String, Object> saveFile(@RequestBody FileDataRequestDto fileData) {

        Map<String, Object> response = new HashMap<>();

        String translatedFileName = fileData.getTranslatedFileName();
        List<String> translatedColumns = fileData.getTranslatedColumns();
        String originFileName = fileData.getOriginFileName();
        List<String> originalColumns = fileData.getOriginColumns();
        String code = fileData.getCode();

        log.info("save file request for {}", translatedFileName);
        log.info("translatedColumns = {}", translatedColumns);

        MultipartFile file = fileUtil.readFileFromTempPath(originFileName);

        // read csv
        String filePath = fileUtil.getFullPath(file.getOriginalFilename());
        List<String[]> datas = csvUtil.readCsvFile(filePath);

        // mongoDB에 저장
        csvSaveService.saveFile(datas, translatedFileName, translatedColumns);

        // library 자동화를 위해 DTO 생성
        FileInfoDto fileInfoDto = sendAutoLibraryInfoService.setBasicInfo(originFileName, translatedFileName, originalColumns, translatedColumns, datas);

        // api 서버 코드 생성
        apiServerGenerateService.generate(fileInfoDto);

        // library 코드 생성
        javaFileLibraryGenerateService.generate(fileInfoDto);

        // 데이터 정보 저장 (MongoDB)
        datalistService.saveDocument(fileInfoDto);

        // 파일 삭제
        fileUtil.deleteFileFromTempPath(originFileName);

        // 성공 응답 구성
        response.put("isSuccess", true);
        if ("/admin".equals(baseUrl)) {
            response.put("redirectUrl", "/file/complete");
        } else if ("".equals(baseUrl)) {
            response.put("redirectUrl", "/admin/file/complete");
        }
        return response;
    }

    @GetMapping("/complete")
    public String getCompletePage() {
        return "views/file/file-complete";
    }
}
