package com.openmind.ezdg.file.dto.externalApi.naver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PapagoResponseDto {
    private PapagoMessageDto message;

    /**
     * @return 번역된 Text를 반환한다.
     */
    public String getTranslatedText() {
        return message.getTranslatedText();
    }
}
