package com.openmind.ezdg.algolia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlgoliaSearchApiDetailDto {
    private String name;
    private String route;
}
