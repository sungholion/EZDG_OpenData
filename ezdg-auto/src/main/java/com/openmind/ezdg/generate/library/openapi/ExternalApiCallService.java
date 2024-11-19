package com.openmind.ezdg.generate.library.openapi;

import java.util.List;

public interface ExternalApiCallService {
    List<FastApiResponseDto> tableFormApi(String s);
    List<FastApiResponseDto> swaggerFormApi(String s);
}