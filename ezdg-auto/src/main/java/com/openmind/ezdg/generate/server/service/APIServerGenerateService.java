package com.openmind.ezdg.generate.server.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Value;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class APIServerGenerateService {
    @Value("${path.api-server-project-path}")
    private String apiServerProjectPath;

    public void generate(Map<String, Object> data) throws IOException, TemplateException {
        generateEntityFile(data);
        generateServiceFile(data);
        generateControllerFile(data);
    }

    private void generateControllerFile(Map<String, Object> data) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(APIServerGenerateService.class, "/templates/generate/server");

        // java library 프로젝트의 패키지명
        data.put("packageName", "com.ssafy.ezdg." + data.get("className"));

        Template controllerTemplate = cfg.getTemplate("controllerTemplate.ftl");
        String controllerPath = apiServerProjectPath + data.get("className") + "Controller.java";
        controllerTemplate.process(data, new FileWriter(controllerPath));
    }

    private void generateServiceFile(Map<String, Object> data) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(APIServerGenerateService.class, "/templates/generate/server");

        // java library 프로젝트의 패키지명
        data.put("packageName", "com.ssafy.ezdg." + data.get("className"));

        Template serviceTemplate = cfg.getTemplate("serviceTemplate.ftl");
        String servicePath = apiServerProjectPath + data.get("className") + "Service.java";
        serviceTemplate.process(data, new FileWriter(servicePath));
    }

    private void generateEntityFile(Map<String, Object> data) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(APIServerGenerateService.class, "/templates/generate/server");

        // java library 프로젝트의 패키지명
        data.put("packageName", "com.ssafy.ezdg." + data.get("className"));

        Template entityTemplate = cfg.getTemplate("entityTemplate.ftl");
        String entityPath = apiServerProjectPath + data.get("className") + ".java";
        entityTemplate.process(data, new FileWriter(entityPath));
    }

}
