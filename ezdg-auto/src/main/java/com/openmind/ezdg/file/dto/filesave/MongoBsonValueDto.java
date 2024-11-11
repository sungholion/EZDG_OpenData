package com.openmind.ezdg.file.dto.filesave;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MongoBsonValueDto {

    // document 내 field 이름
    private String fieldName;

    // document 내 field 값
    private String fieldValue;

    // document 내 field 타입
    private String fieldType;
}
