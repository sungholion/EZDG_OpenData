package com.openmind.ezdg.file.dto.filesave;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ValidateDuplicateCodeDto {

    // 중복인지 여부
    private Boolean isDuplicate;

    // 코드 등록 일시
    private LocalDateTime regDate;
}
