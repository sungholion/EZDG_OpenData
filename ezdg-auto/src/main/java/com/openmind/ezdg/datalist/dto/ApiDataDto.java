package com.openmind.ezdg.datalist.dto;

import com.openmind.ezdg.generate.library.openapi.FastApiResponseDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ApiDataDto {
    public String mainTitle;
    public String mainDescription;
    public List<FastApiResponseDto> apiList;
}
