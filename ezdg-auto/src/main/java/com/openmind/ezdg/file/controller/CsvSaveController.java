package com.openmind.ezdg.file.controller;

import com.openmind.ezdg.file.dto.filesave.AutoLibraryInfoDto;
import com.openmind.ezdg.file.dto.filesave.MongoBsonValueDto;
import com.openmind.ezdg.file.dto.filesave.ValidateDuplicateCodeDto;
import com.openmind.ezdg.file.service.CsvSaveService;
import com.openmind.ezdg.file.service.SendAutoLibraryInfoService;
import com.openmind.ezdg.file.util.CsvUtil;
import com.openmind.ezdg.file.util.FileUtil;
import com.openmind.ezdg.file.util.ObjectMapperUtil;
import com.openmind.ezdg.generate.library.file.service.JavaFileLibraryGenerateService;
import com.openmind.ezdg.generate.server.service.APIServerGenerateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
    private final ObjectMapperUtil objectMapperUtil;
    private final FileUtil fileUtil;

    /**
     * 파일 업로드 페이지 호출
     */
    @GetMapping()
    public String getFileUploadPage() {
        return "views/filesave/file";
    }

    /**
     * 파일 변환
     * 파일과 공공데이터 코드 입력 후 변환 버튼 클릭
     */
    @PostMapping()
    public String translateFile(@RequestParam("file") MultipartFile file, @RequestParam("code") String code,
                                RedirectAttributes redirectAttributes, Model model) {
        log.info("[FileSaveController] request save file for {}", file.getOriginalFilename());

        // 중복 코드 검증
        ValidateDuplicateCodeDto validateDuplicateCode = csvSaveService.validateDuplicateCode(code);
        if (validateDuplicateCode.getIsDuplicate()) {
            model.addAttribute("isDuplicateCode", true);
            model.addAttribute("regDate", validateDuplicateCode.getRegDate());
            return "views/filesave/duplicate";
        }

        boolean isSuccessFileSaveToTempPath = fileUtil.saveFileToTempPath(file);
        if(!isSuccessFileSaveToTempPath) {
            return "views/filesave/error";
        }

        // 파일 이름 한<->영 번역 및 컨벤션 적용
        String translatedFileName = csvSaveService.getTranslatedFileName(file.getOriginalFilename());
        log.info("translated file name = {}", translatedFileName);

        // view 전달 파라미터 설정
        redirectAttributes.addFlashAttribute("originFileName", file.getOriginalFilename());
        redirectAttributes.addFlashAttribute("translatedFileName", translatedFileName);

        // read csv
        List<String[]> datas = csvUtil.readCsvFile(file);

        // 칼럼 이름 한<->영 번역 및 컨벤션 적용
        List<String> originalColumns = csvSaveService.getOriginalColumns(datas);
        List<String> translatedColumns = csvSaveService.getTranslatedColumns(originalColumns);

        log.info("original columns = {}", originalColumns);
        log.info("translated columns = {}", translatedColumns);

        // view 전달 파라미터 설정
        redirectAttributes.addFlashAttribute("originalColumns", originalColumns);
        redirectAttributes.addFlashAttribute("translatedColumns", translatedColumns);

        // List<String[]> 타입을 view로 전달하고, 다른 컨트롤러로 전달하기 위해 json String type으로 변경
//        String dataToJson = objectMapperUtil.dataToString(datas);

//        redirectAttributes.addFlashAttribute("datas", dataToJson);
//        redirectAttributes.addFlashAttribute("file", file);
        redirectAttributes.addFlashAttribute("fileName", file.getOriginalFilename());
        redirectAttributes.addFlashAttribute("code", code);

        return "redirect:/file/save";
    }

    /**
     * 파일 저장 페이지 호출
     */
    @GetMapping("/save")
    public String getFileSavePage(Model model) {
        log.info("파일 저장 페이지 호출");
//        model.addAttribute("file", model.getAttribute("file"));
        model.addAttribute("fileName", model.getAttribute("fileName"));
        model.addAttribute("code", model.getAttribute("code"));

        return "views/filesave/save";
    }

    /**
     * 파일 저장
     */
    @PostMapping("/save")
    public String saveFile(@RequestParam(value = "translatedFileName") String translatedFileName,
                           @RequestParam(value = "translatedColumns") List<String> translatedColumns,
//                           @RequestParam(value = "file") MultipartFile file,
                           @RequestParam(value = "fileName") String fileName,
                           @RequestParam(value = "code") String code,
                           RedirectAttributes redirectAttributes) {
        log.info("save file request for {}", translatedFileName);
        log.info("translatedColumns = {}", translatedColumns);

        // 파일 변환 단계에서 json String으로 변환한 데이터를 다시 List<String[]> 타입으로 변환
//        List<String[]> datas = objectMapperUtil.stringToData(dataToJson);
        MultipartFile file = fileUtil.readFileFromTempPath(fileName);

        // read csv
        List<String[]> datas = csvUtil.readCsvFile(file);

        // 파일 삭제
        fileUtil.deleteFileFromTempPath(fileName);

        // mongoDB에 저장
        csvSaveService.saveFile(datas, translatedFileName, translatedColumns);

        // public data code 저장
        csvSaveService.insertCode(code);

        // library 자동화를 위한 정보를 담은 Dto
        AutoLibraryInfoDto autoLibraryInfoDto = sendAutoLibraryInfoService.makeAutoLibraryInfo(translatedFileName, translatedColumns, datas);

        apiServerGenerateService.generate(autoLibraryInfoDto);
        javaFileLibraryGenerateService.generate(autoLibraryInfoDto);

        // view 전달 파라미터
        redirectAttributes.addFlashAttribute("collection", translatedFileName);
        redirectAttributes.addFlashAttribute("code", code);

        return "redirect:/file/result";
    }

    /**
     * 저장 결과
     */
    @GetMapping("/result")
    public String getResultPage(Model model) {
        String collectionName = (String) model.getAttribute("collection");

        // db에 잘 들어갔는지, db에서 조회해서 결과 출력
        List<List<MongoBsonValueDto>> result = csvSaveService.getSavedData(collectionName);

        model.addAttribute("result", result);

        return "views/filesave/result";
    }
}
