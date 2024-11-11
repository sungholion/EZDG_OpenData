package com.daegu.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DaeguTravelDto {
    private String id;
    private String type;
    private String title;
    private int courseNum;
    private String topic;
    private String topicDescription;
    private String region;
    private String spot;
    private String courseDescription;
    private String address;
    private String phone;
    private String homepage;
}
