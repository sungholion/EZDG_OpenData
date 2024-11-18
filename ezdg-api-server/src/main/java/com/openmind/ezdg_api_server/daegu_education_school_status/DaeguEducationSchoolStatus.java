package com.openmind.ezdg_api_server.daegu_education_school_status;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document(collection = "daegu_education_school_status")
public class DaeguEducationSchoolStatus {
    @Id
    private String id;
    private String schoolName;
    private String districtCountyOffice;
    private String address;
    private Long postcode;
    private String phoneNumber;
    private String faxNumber;
}