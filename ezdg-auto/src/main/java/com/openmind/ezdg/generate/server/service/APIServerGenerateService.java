package com.openmind.ezdg.generate.server.service;

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

@RequiredArgsConstructor
@Service
public class APIServerGenerateService {

    private final CustomStringUtil customStringUtil;
    @Value("${path.api-server-project-path}")
    private String apiServerProjectPath;

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

        File directory = new File(apiServerProjectPath + data.get("collectionName"));

        // 폴더가 존재하지 않으면 생성
        if (!directory.exists()) {
            directory.mkdirs(); // 중첩된 디렉토리 구조도 생성
        }

        generateEntityFile(data);
        generateServiceFile(data);
        generateControllerFile(data);
    }

    private void generateControllerFile(Map<String, Object> data) {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(APIServerGenerateService.class, "/templates/generate/server");

        // java library 프로젝트의 패키지명
        data.put("packageName", "com.openmind.ezdg_api_server." + data.get("collectionName"));


        Template controllerTemplate = null;
        try {
            controllerTemplate = cfg.getTemplate("controllerTemplate.ftl");
            String controllerPath = new StringBuilder()
                    .append(apiServerProjectPath)
                    .append(data.get("collectionName"))
                    .append(System.getProperty("os.name").startsWith("Windows") ? "\\" : "/")
                    .append(data.get("className"))
                    .append("Controller.java").toString();

            FileWriter writer = new FileWriter(controllerPath);
            controllerTemplate.process(data, writer);
            writer.close();
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }

    }

    private void generateServiceFile(Map<String, Object> data) {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(APIServerGenerateService.class, "/templates/generate/server");

        // java library 프로젝트의 패키지명
        data.put("packageName", "com.openmind.ezdg_api_server." + data.get("collectionName"));

        try {
            Template serviceTemplate = cfg.getTemplate("serviceTemplate.ftl");
            String servicePath = new StringBuilder()
                    .append(apiServerProjectPath)
                    .append(data.get("collectionName"))
                    .append(System.getProperty("os.name").startsWith("Windows") ? "\\" : "/")
                    .append(data.get("className"))
                    .append("Service.java").toString();
            FileWriter writer = new FileWriter(servicePath);
            serviceTemplate.process(data, writer);
            writer.close();
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }


    }

    private void generateEntityFile(Map<String, Object> data) {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(APIServerGenerateService.class, "/templates/generate/server");

        // java library 프로젝트의 패키지명
        data.put("packageName", "com.openmind.ezdg_api_server." + data.get("collectionName"));

        try {
            Template entityTemplate = cfg.getTemplate("entityTemplate.ftl");
            String entityPath = new StringBuilder()
                    .append(apiServerProjectPath)
                    .append(data.get("collectionName"))
                    .append(System.getProperty("os.name").startsWith("Windows") ? "\\" : "/")
                    .append(data.get("className"))
                    .append(".java").toString();
            FileWriter writer = new FileWriter(entityPath);
            entityTemplate.process(data, writer);
            writer.close();
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }

    }

}
