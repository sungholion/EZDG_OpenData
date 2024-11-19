package com.openmind.ezdg_api_server.gumi_library_information;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document(collection = "gumi_library_information")
public class GumiLibraryInformation {
    @Id
    private String id;
    private Long order;
    private String magazineName;
    private String placeOfIssue;
    private String period;
    private String location;
}