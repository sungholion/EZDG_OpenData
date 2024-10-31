package com.openmind.ezdg.file.dto.externalApi.naver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PapagoMessageDto {
    private PapagoResultDto result;

    public String getTranslatedText() {
        return result.getTranslatedText();
    }
}
