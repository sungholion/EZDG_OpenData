package com.openmind.ezdg_api_server.daegu_local_company_information_status;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document(collection = "daegu_local_company_information_status")
public class DaeguLocalCompanyInformationStatus {
    @Id
    private String id;
    private String companyName;
    private String companySize;
}