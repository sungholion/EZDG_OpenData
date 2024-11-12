package com.openmind.ezdg.generate.library.openapi;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class FastApiResponseDto {
    private String title;
    private String description;
    private String packageName;
    private String className;
    private String baseUrl;
    private String endpoint;
    private List<FieldInfoDto> requestFields;
    private List<FieldInfoDto> responseFields;
}