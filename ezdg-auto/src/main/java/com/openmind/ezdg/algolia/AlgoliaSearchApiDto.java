package com.openmind.ezdg.algolia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlgoliaSearchApiDto {
    private String originalName;
    private String routeTitle;
    private String routeSub;
}
