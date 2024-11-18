package com.openmind.ezdg_api_server.gumi_factory_registration_status;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document(collection = "gumi_factory_registration_status")
public class GumiFactoryRegistrationStatus {
    @Id
    private String id;
    private String classification;
    private String companyName;
    private String phoneNumber;
    private String factoryRepresentativeAddress;
    private String businessName;
    private Long numberOfEmployees;
    private String managementAgencyName;
    private String managementAgencyPhoneNumber;
}