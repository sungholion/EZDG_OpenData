package com.openmind.ezdg_api_server.daegu_metropolitan_city_tourism_course_information;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "daegu_metropolitan_city_tourism_course_information")
@Getter
@Setter
public class DaeguMetropolitanCityTourismCourseInformation {
@Id
private String id;
    private String classification;
    private String courseTitle;
    private Long courseNumber;
    private String courseTopic;
    private String courseTopicDescription;
    private String region;
    private String touristDestination;
    private String courseDescription;
    private String address;
    private String phoneNumber;
    private String homepage;
// Getters and Setters
}