package com.openmind.ezdg.generate.library.file.service;

import com.openmind.ezdg.file.dto.filesave.AutoLibraryInfoDto;
import com.openmind.ezdg.file.util.CustomStringUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JavaFileLibraryGenerateService {

    private final CustomStringUtil customStringUtil;


    @Value("${path.java-library-project-path}")
    private String javaLibraryProjectPath;

    public void generate(AutoLibraryInfoDto dto) {
        Map<String, Object> data = new HashMap<>();
        data.put("collectionName", dto.getClassInfo());
        data.put("className", customStringUtil.capitalizeFirstLetter(customStringUtil.snakeCaseToCamelCase(dto.getClassInfo())));
        List<Map<String, String>> fields = new ArrayList<>();
        dto.getColumnInfo().forEach(columnInfo -> {
            Map<String, String> field = new HashMap<>();
            field.put("type", columnInfo.getColumnType());
            field.put("name", columnInfo.getColumnName());
            fields.add(field);
        });
        data.put("fields", fields);

        File directory = new File(javaLibraryProjectPath + data.get("collectionName"));

        // 폴더가 존재하지 않으면 생성
        if (!directory.exists()) {
            directory.mkdirs(); // 중첩된 디렉토리 구조도 생성
        }

        generateDTOFile(data);
        generateAPIFile(data);
    }

    private void generateDTOFile(Map<String, Object> data) {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(JavaFileLibraryGenerateService.class, "/templates/generate/library/file");

        // java library 프로젝트의 패키지명
        data.put("packageName", "com.openmind.ezdg." + data.get("collectionName"));

        try {
            Template dtoTemplate = cfg.getTemplate("dtoTemplate.ftl");
            String dtoPath = new StringBuilder()
                    .append(javaLibraryProjectPath)
                    .append(data.get("collectionName"))
                    .append(System.getProperty("os.name").startsWith("Windows") ? "\\" : "/")
                    .append(data.get("className"))
                    .append("DTO.java")
                    .toString();

            FileWriter writer = new FileWriter(dtoPath);
            dtoTemplate.process(data, writer);
            writer.close();
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }

    }

    private void generateAPIFile(Map<String, Object> data) {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(JavaFileLibraryGenerateService.class, "/templates/generate/library/file");

        // java library 프로젝트의 패키지명
        data.put("packageName", "com.openmind.ezdg." + data.get("collectionName"));
        try {
            Template apiTemplate = cfg.getTemplate("apiTemplate.ftl");
            String apiPath = new StringBuilder()
                    .append(javaLibraryProjectPath)
                    .append(data.get("collectionName"))
                    .append(System.getProperty("os.name").startsWith("Windows") ? "\\" : "/")
                    .append(data.get("className"))
                    .append("API.java")
                    .toString();

            FileWriter writer = new FileWriter(apiPath);
            apiTemplate.process(data, writer);
            writer.close();
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }

    }
}
