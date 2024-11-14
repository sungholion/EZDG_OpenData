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

    private String classification;    // 분류
    private String courseTitle;   // 코스 타이틀
    private int courseNumber;  // 코스 번호
    private String courseTopic;   // 코스 주제
    private String courseTopicDescription;    // 코스 주제 설명
    private String region;  // 지역
    private String touristDestination;    //관광지
    private String courseDescription;   // 코스 설명
    private String address; // 주소
    private String phoneNumber;   // 전화 번호
    private String homepage;    // 홈페이지


}
