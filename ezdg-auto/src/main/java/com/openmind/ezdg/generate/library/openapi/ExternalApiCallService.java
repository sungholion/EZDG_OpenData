package com.openmind.ezdg.generate.library.openapi;

import java.util.List;

public interface ExternalApiCallService {
    String tableFormApi(String url);
    List<String> swaggerFormApi(String url);
}