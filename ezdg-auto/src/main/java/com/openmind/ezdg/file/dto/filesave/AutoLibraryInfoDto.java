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
public class AutoLibraryInfoDto {

    @NonNull
    private String classInfo;

    @NonNull
    private List<ColumnInfo> columnInfo;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class ColumnInfo{
        private String columnType;
        private String columnName;
    }
}
