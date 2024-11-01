package com.openmind.ezdg.generate.server.service;

import com.openmind.ezdg.file.dto.filesave.AutoLibraryInfoDto;
import com.openmind.ezdg.file.util.CustomStringUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

        generateEntityFile(data);
        generateServiceFile(data);
        generateControllerFile(data);
    }

    private void generateControllerFile(Map<String, Object> data) {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(APIServerGenerateService.class, "/templates/generate/server");

        // java library 프로젝트의 패키지명
        data.put("packageName", "com.ssafy.ezdg." + data.get("collectionName"));


        Template controllerTemplate = null;
        try {
            controllerTemplate = cfg.getTemplate("controllerTemplate.ftl");
            String controllerPath = apiServerProjectPath + data.get("className") + "Controller.java";
            controllerTemplate.process(data, new FileWriter(controllerPath));
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }

    }

    private void generateServiceFile(Map<String, Object> data) {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(APIServerGenerateService.class, "/templates/generate/server");

        // java library 프로젝트의 패키지명
        data.put("packageName", "com.ssafy.ezdg." + data.get("collectionName"));

        try {
            Template serviceTemplate = cfg.getTemplate("serviceTemplate.ftl");
            String servicePath = apiServerProjectPath + data.get("className") + "Service.java";
            serviceTemplate.process(data, new FileWriter(servicePath));
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }


    }

    private void generateEntityFile(Map<String, Object> data) {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(APIServerGenerateService.class, "/templates/generate/server");

        // java library 프로젝트의 패키지명
        data.put("packageName", "com.ssafy.ezdg." + data.get("collectionName"));

        try {
            Template entityTemplate = cfg.getTemplate("entityTemplate.ftl");
            String entityPath = apiServerProjectPath + data.get("className") + ".java";
            entityTemplate.process(data, new FileWriter(entityPath));
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }

    }

}
