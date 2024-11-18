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
public class MongoFileDto {
    @Id
    private String id;

    private String originalFileName;
    private String translatedFileName;

    private List<FileFieldInfo> fields;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String type;
    private Boolean deployed;

    private List<MethodFieldInfo> methodList;

    @Getter @Setter
    @AllArgsConstructor
    public class FileFieldInfo {
        private String type;
        private String translatedName;
        private String originalName;
    }

    @Getter @Setter
    @AllArgsConstructor
    public class MethodFieldInfo {
        private String method;
        private String description;
        private String returnType;
    }
}
