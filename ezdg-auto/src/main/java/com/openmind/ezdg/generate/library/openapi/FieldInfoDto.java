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
    private String required;
    private String sampleData;
}