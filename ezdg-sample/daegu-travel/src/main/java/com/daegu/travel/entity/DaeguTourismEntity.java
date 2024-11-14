package com.daegu.travel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Document(collection = "daegu_tourism")
public class DaeguTourismEntity {
    @Id
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
