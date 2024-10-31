package com.ssafy.ezdg.Test;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "test")
@Getter
@Setter
public class Test {
    @Id
    private String id;
    private String region;
    private Double temperature;
    // Getters and Setters
}