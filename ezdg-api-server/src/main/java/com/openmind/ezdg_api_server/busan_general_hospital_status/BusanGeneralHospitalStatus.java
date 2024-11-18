package com.openmind.ezdg_api_server.busan_general_hospital_status;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;


@Getter
@Setter
@Document(collection = "busan_general_hospital_status")
public class BusanGeneralHospitalStatus {
    @Id
    private String id;
    private Long number;
    private String nameOfMedicalInstitution;
    private String representative;
    private String roadNameAddress;
    private Double longitude;
    private Double latitude;
    private String phoneNumber;
    private Long system;
    private Long general;
    private Long spirit;
    private LocalDate authorizationDate;
}