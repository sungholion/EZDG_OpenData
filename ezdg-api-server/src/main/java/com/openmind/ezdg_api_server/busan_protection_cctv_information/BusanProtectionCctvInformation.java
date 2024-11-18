package com.openmind.ezdg_api_server.busan_protection_cctv_information;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document(collection = "busan_protection_cctv_information")
public class BusanProtectionCctvInformation {
    @Id
    private String id;
    private String cctvName;
    private String cctvCoordinates;
    private String cctvGroup;
}