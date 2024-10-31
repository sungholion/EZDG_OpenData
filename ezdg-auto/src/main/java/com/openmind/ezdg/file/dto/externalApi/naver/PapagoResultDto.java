package com.openmind.ezdg.file.dto.externalApi.naver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PapagoResultDto {
    private String srcLangType;
    private String tarLangType;
    private String translatedText;
}
