package com.openmind.ezdg_api_server.busan_manufacturing_factory_registration_status;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document(collection = "busan_manufacturing_factory_registration_status")
public class BusanManufacturingFactoryRegistrationStatus {
    @Id
    private String id;
    private Long order;
    private String companyName;
    private String factoryRepresentativeAddress;
    private String businessName;
    private String phoneNumber;
}