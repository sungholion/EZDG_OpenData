package com.openmind.ezdg.generate.library.openapi;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FieldInfoDto {
    private String type;
    private String name;
    private String description;
    private String required;      // 추가
    private String sampleData;    // 추가
}