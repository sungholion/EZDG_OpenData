package com.openmind.ezdg.file.dto.filesave;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Data
@ToString
public class FileInfoDto {

    @NonNull
    private String originalFileName;

    @NonNull
    private String translatedFileName;

    @NonNull
    private List<Field> fields;

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Field {
        private String type;
        private String translatedName;
        private String originalName;
    }

}
