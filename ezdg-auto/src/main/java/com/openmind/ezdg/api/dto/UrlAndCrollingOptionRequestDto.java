package com.openmind.ezdg.api.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UrlAndCrollingOptionRequestDto {
    private String url;
    private String crollerOption;
}
