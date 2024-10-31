package com.openmind.ezdg.generate.library.file.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

@Service
public class JavaFileLibraryGenerateService {

    @Value("${path.java-library-project-path}")
    private String javaLibraryProjectPath;

    public void generate(Map<String, Object> data) throws IOException, TemplateException {
        generateDTOFile(data);
        generateAPIFile(data);
    }

    private void generateDTOFile(Map<String, Object> data) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(JavaFileLibraryGenerateService.class, "/templates/generate/library/file");

        // java library 프로젝트의 패키지명
        data.put("packageName", "com.ssafy.ezdg." + data.get("className"));

        Template dtoTemplate = cfg.getTemplate("dtoTemplate.ftl");
        String dtoPath = javaLibraryProjectPath + data.get("className") + "DTO.java";
        dtoTemplate.process(data, new FileWriter(dtoPath));
    }

    private void generateAPIFile(Map<String, Object> data) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(JavaFileLibraryGenerateService.class, "/templates/generate/library/file");

        // java library 프로젝트의 패키지명
        data.put("packageName", "com.ssafy.ezdg." + data.get("className"));

        Template apiTemplate = cfg.getTemplate("apiTemplate.ftl");
        String apiPath = javaLibraryProjectPath + data.get("className") + "API.java";
        apiTemplate.process(data, new FileWriter(apiPath));
    }
}
