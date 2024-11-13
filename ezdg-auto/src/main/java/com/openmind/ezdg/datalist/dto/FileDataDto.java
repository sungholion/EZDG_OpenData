package com.openmind.ezdg.datalist.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class FileDataDto {
    private String originalFileName;
    private String translatedFileName;
    private List<Map<String, String>> fields;


}
