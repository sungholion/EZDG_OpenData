package com.openmind.ezdg_api_server.daegu_manufacturer_status;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document(collection = "daegu_manufacturer_status")
public class DaeguManufacturerStatus {
    @Id
    private String id;
    private Long orderNumber;
    private String complexName;
    private String companyName;
    private String factoryRepresentativeAddress;
    private String factoryRepresentativeAddress;
    private String representativeBusinessNumber;
    private String businessNumber;
    private String businessName;
    private String establishmentClassification;
    private String product;
    private String mainMaterial;
}