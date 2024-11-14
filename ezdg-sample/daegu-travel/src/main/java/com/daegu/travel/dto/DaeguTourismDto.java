package com.daegu.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DaeguTourismDto {
    private String id;
    private String classification;
    private String courseTitle;
    private int courseNumber;
    private String courseTopic;
    private String courseTopicDescription;
    private String region;
    private String touristDestination;
    private String courseDescription;
    private String address;
    private String phoneNumber;
    private String homepage;
}
