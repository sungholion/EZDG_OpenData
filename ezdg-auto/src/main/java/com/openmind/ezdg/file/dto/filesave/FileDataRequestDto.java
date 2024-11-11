package com.openmind.ezdg.file.dto.filesave;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FileDataRequestDto {
    private String translatedFileName;
    private List<String> translatedColumns;
    private String originFileName;
    private String code;
    private List<String> originColumns;
}
