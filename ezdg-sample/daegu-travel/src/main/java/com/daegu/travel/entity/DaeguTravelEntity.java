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
@Document(collection = "daegu_travel")
public class DaeguTravelEntity {

    @Id
    private String id;

    private String type;    // 분류
    private String title;   // 코스 타이틀
    private int courseNum;  // 코스 번호
    private String topic;   // 코스 주제
    private String topicDescription;    // 코스 주제 설명
    private String region;  // 지역
    private String spot;    //관광지
    private String courseDescription;   // 코스 설명
    private String address; // 주소
    private String phone;   // 전화 번호
    private String homepage;    // 홈페이지


}
