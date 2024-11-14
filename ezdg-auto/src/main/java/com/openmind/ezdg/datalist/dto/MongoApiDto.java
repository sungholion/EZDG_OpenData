package com.openmind.ezdg.datalist.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@Document(collection = "data_list")
public class MongoApiDto {
    @Id
    private String id;
    private String mainTitle;
    private String mainDescription;
    private List<ApiListInfo> apiList;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String type;
    private Boolean deployed;

    @Getter @Setter
    @AllArgsConstructor
    public class ApiListInfo {
        private String title;
        private String description;
        private String packageName;
        private String className;
        private String baseUrl;
        private String endpoint;
        private List<ApiFieldInfo> requestFields;
        private List<ApiFieldInfo> responseFields;
    }

    @Getter @Setter
    @AllArgsConstructor
    public class ApiFieldInfo {
        private String type;
        private String name;
        private String description;
        private String required;
        private String sampleData;
    }
}
