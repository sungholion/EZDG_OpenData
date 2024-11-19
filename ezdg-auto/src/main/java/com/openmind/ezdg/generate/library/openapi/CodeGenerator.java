package com.openmind.ezdg.generate.library.openapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class CodeGenerator {
    private final Configuration cfg;
    private final ObjectMapper mapper;

    @Value("${path.java-library-project-path}")
    private String javaLibraryProjectPath;

    public CodeGenerator() throws IOException {
        cfg = new Configuration(Configuration.VERSION_2_3_30);
        //cfg.setDirectoryForTemplateLoading(new File("src/main/resources/templates/generate/library/openapi"));
        cfg.setClassLoaderForTemplateLoading(getClass().getClassLoader(), "templates/generate/library/openapi");
        mapper = new ObjectMapper();
    }

    // 단일 API 스펙에 대한 코드 생성
    public void generateCode(FastApiResponseDto apiSpec) {
        log.info("apiSpec = {}", apiSpec.getRequestFields());
        try {
            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("packageName", "com.openmind.ezdg." + apiSpec.getPackageName());
            dataModel.put("className", apiSpec.getClassName());
            dataModel.put("baseUrl", apiSpec.getBaseUrl());
            dataModel.put("endpoint", apiSpec.getEndpoint());

            String basePackagePath = javaLibraryProjectPath
                    + apiSpec.getPackageName().replace(".", "/")
                    + (System.getProperty("os.name").startsWith("Windows") ? "\\" : "/");

            new File(basePackagePath).mkdirs();

            generateRequestDTO(dataModel, apiSpec, basePackagePath);
            generateResponseDTO(dataModel, apiSpec, basePackagePath);
            generateAPIClass(dataModel, apiSpec, basePackagePath);
        } catch (IOException | TemplateException e) {
            log.error("Failed to generate code for endpoint {}: {}", apiSpec.getEndpoint(), e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private void generateRequestDTO(Map<String, Object> dataModel, FastApiResponseDto apiSpec, String basePackagePath)
            throws IOException, TemplateException {
        Map<String, Object> requestModel = new HashMap<>(dataModel);
        requestModel.put("className", apiSpec.getClassName() + "Request");
        requestModel.put("fields", apiSpec.getRequestFields());

        Template template = cfg.getTemplate("dto_request_template.ftl");
        try (Writer writer = new FileWriter(new File(basePackagePath + apiSpec.getClassName() + "Request.java"))) {
            template.process(requestModel, writer);
        }
    }

    private void generateResponseDTO(Map<String, Object> dataModel, FastApiResponseDto apiSpec, String basePackagePath)
            throws IOException, TemplateException {
        Map<String, Object> responseModel = new HashMap<>(dataModel);
        responseModel.put("className", apiSpec.getClassName() + "Response");
        responseModel.put("responseFields", apiSpec.getResponseFields());

        Template template = cfg.getTemplate("dto_response_template.ftl");
        try (Writer writer = new FileWriter(new File(basePackagePath + apiSpec.getClassName() + "Response.java"))) {
            template.process(responseModel, writer);
        }
    }

    private void generateAPIClass(Map<String, Object> dataModel, FastApiResponseDto apiSpec, String basePackagePath)
            throws IOException, TemplateException {
        Map<String, Object> apiModel = new HashMap<>(dataModel);
        apiModel.put("requestFields", apiSpec.getRequestFields());
        apiModel.put("responseFields", apiSpec.getResponseFields());

        Template template = cfg.getTemplate("api_template.ftl");
        try (Writer writer = new FileWriter(new File(basePackagePath + apiSpec.getClassName() + ".java"))) {
            template.process(apiModel, writer);
        }
    }
}
