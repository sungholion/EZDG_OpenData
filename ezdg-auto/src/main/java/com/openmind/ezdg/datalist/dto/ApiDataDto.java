package com.openmind.ezdg.datalist.dto;

import com.openmind.ezdg.generate.library.openapi.FastApiResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ApiDataDto {
    public String mainTitle;
    public String mainDescription;
    public List<FastApiResponseDto> apiList;
}
