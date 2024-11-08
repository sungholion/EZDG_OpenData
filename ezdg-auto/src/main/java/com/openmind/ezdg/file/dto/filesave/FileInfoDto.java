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
    private String originFileName;

    @NonNull
    private String translatedFileName;  // classInfo -> translatedFileName으로 변경

    @NonNull
    private List<String> originalColumns;

    @NonNull
    private List<TranslatedColumn> translatedColumns;   // columnInfo -> translatedColumns로 멤버명 변경

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class TranslatedColumn{   // ColumnInfo -> TranslatedColumn으로 클래스명 변경
        private String columnType;
        private String columnName;
    }

}
