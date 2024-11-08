package com.openmind.ezdg.user.controller;

import com.openmind.ezdg.user.dto.DataApplyDto;
import com.openmind.ezdg.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "사용자 관련 API", description = "데이터 추가 신청 / ")
public class UserController {

    private final UserService userService;

    @Operation(summary = "데이터 추가 신청 API", description = "공공 데이터 추가 신청")
    @PostMapping("/dataApply")
    public ResponseEntity<?> applyData(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "이름, 답변 받을 이메일, 소속, 공공 데이터 명칭, 공공 데이터 링크, 활용 목적, 기타 요청 사항",
                    required = true,
                    content = @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "\"name\": \"김싸피\",\n" +
                                            "\"email\": \"eoblue23@gmail.com\",\n" +
                                            "\"association\": \"ezdg Corp\",\n" +
                                            "\"publicDataName\": \"Gunposi Air pollution\",\n" +
                                            "\"publicDataLink\": \"https://data.example.com/gunposi\",\n" +
                                            "\"publicDataType\": \"file\",\n" +
                                            "\"purpose\": \"Research\",\n" +
                                            "\"additionalRequest\": \"없습니다.\"\n" +
                                            "}"
                            )
                    )
            ) DataApplyDto dataApplyDto
    ) {
        log.info("데이터 활용 신청 : {}", dataApplyDto.getName());

        try{

            userService.applyData(dataApplyDto);
            return ResponseEntity.accepted().body("데이터 신청이 완료되었습니다.");
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 에러 입니다");
        }


    }
}
