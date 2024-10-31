package com.openmind.ezdg.file.dto.externalApi.naver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PapagoRequestDto {

    // 원본 텍스트(Source)의 언어 코드
    private String source; // Required

    // 번역할 텍스트(Target)의 언어 코드
    private String target; // Required

    // 번역할 텍스트
    private String text; // Required

    // 용어집 아이디
    private String glossaryKey; // Optional

    // 치환 번역 인덱스
    private String replaceInfo; // Optional

    // 높임말 적용 여부(default = false)
    private Boolean honorific; // Optional
}
