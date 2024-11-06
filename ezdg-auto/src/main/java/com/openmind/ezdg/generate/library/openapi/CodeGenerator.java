package com.openmind.ezdg.generate.library.openapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeGenerator {
    private final Configuration cfg;
    private final ObjectMapper mapper;

    public CodeGenerator() throws IOException {
        cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setDirectoryForTemplateLoading(new File("src/main/resources/templates/generate/library/openapi"));
        mapper = new ObjectMapper();
    }

    /**
     * 디렉토리 내의 모든 JSON 파일에 대해 코드를 생성합니다.
     * @param directoryPath JSON 파일들이 있는 디렉토리 경로
     */
    public void generateCodeForDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.err.println("Invalid directory path: " + directoryPath);
            return;
        }

        File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));
        if (files == null || files.length == 0) {
            System.out.println("No JSON files found in directory: " + directoryPath);
            return;
        }

        for (File file : files) {
            try {
                System.out.println("Processing file: " + file.getName());
                generateCode(file.getAbsolutePath());
            } catch (Exception e) {
                System.err.println("Error processing file " + file.getName() + ": " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /**
     * 단일 JSON 파일에 대해 코드를 생성합니다.
     */
    public void generateCode(String jsonFilePath) throws IOException, TemplateException {
        // JSON 파일 파싱
        JsonNode rootNode = mapper.readTree(new File(jsonFilePath));

        // JSON 데이터 모델로 변환
        String packageName = rootNode.get("packageName").asText();
        String className = rootNode.get("className").asText();

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("packageName", packageName);
        dataModel.put("className", className);
        dataModel.put("baseUrl", rootNode.get("baseUrl").asText());
        dataModel.put("endpoint", rootNode.get("endpoint").asText());
        dataModel.put("apiUrl", rootNode.get("baseUrl").asText() + rootNode.get("endpoint").asText());

        // DTO 및 API 클래스 생성 경로 설정
        String basePackagePath = "src/main/java/" + packageName.replace(".", "/") + "/";
        new File(basePackagePath).mkdirs();

        generateRequestDTO(dataModel, rootNode, basePackagePath, className);
        generateResponseDTO(dataModel, rootNode, basePackagePath, className);
        generateAPIClass(dataModel, rootNode, basePackagePath, className);

        System.out.println("Generated files for " + className + " in: " + new File(basePackagePath).getAbsolutePath());
    }

    private void generateRequestDTO(Map<String, Object> dataModel, JsonNode rootNode, String basePackagePath, String className)
            throws IOException, TemplateException {
        Map<String, Object> requestModel = new HashMap<>(dataModel);
        requestModel.put("className", className + "Request");
        requestModel.put("fields", mapper.convertValue(rootNode.get("requestFields"), List.class));

        Template requestDtoTemplate = cfg.getTemplate("dto_request_template.ftl");
        try (Writer requestWriter = new FileWriter(new File(basePackagePath + className + "Request.java"))) {
            requestDtoTemplate.process(requestModel, requestWriter);
        }
    }

    private void generateResponseDTO(Map<String, Object> dataModel, JsonNode rootNode, String basePackagePath, String className)
            throws IOException, TemplateException {
        Map<String, Object> responseModel = new HashMap<>(dataModel);
        responseModel.put("className", className + "Response");

        List<Map<String, Object>> responseFields = mapper.convertValue(rootNode.get("responseFields"), List.class);
        if (responseFields == null) {
            responseFields = new ArrayList<>();
        }
        responseModel.put("responseFields", responseFields);

        Template responseDtoTemplate = cfg.getTemplate("dto_response_template.ftl");
        try (Writer responseWriter = new FileWriter(new File(basePackagePath + className + "Response.java"))) {
            responseDtoTemplate.process(responseModel, responseWriter);
        }
    }

    private void generateAPIClass(Map<String, Object> dataModel, JsonNode rootNode, String basePackagePath, String className)
            throws IOException, TemplateException {
        Map<String, Object> apiModel = new HashMap<>(dataModel);
        apiModel.put("requestFields", mapper.convertValue(rootNode.get("requestFields"), List.class));
        apiModel.put("responseFields", mapper.convertValue(rootNode.get("responseFields"), List.class));

        Template apiTemplate = cfg.getTemplate("api_template.ftl");
        try (Writer apiWriter = new FileWriter(new File(basePackagePath + className + "API.java"))) {
            apiTemplate.process(apiModel, apiWriter);
        }
    }

    public static void main(String[] args) {
        try {
            CodeGenerator generator = new CodeGenerator();

            // 디렉토리 내의 모든 JSON 파일 처리
            String jsonDirectory = "src/main/resources/";
            generator.generateCodeForDirectory(jsonDirectory);

            System.out.println("코드 생성이 완료되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}