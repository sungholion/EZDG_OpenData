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

    public CodeGenerator() throws IOException {
        cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setDirectoryForTemplateLoading(new File("src/main/resources/templates/generate/library/openapi"));
    }

    public void generateCode(String jsonFilePath) throws IOException, TemplateException {
        // JSON 파일 파싱
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(new File(jsonFilePath));

        // JSON 데이터 모델로 변환
        String packageName = rootNode.get("packageName").asText();
        String className = rootNode.get("className").asText();

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("packageName", packageName);
        dataModel.put("className", className);
        dataModel.put("baseUrl", rootNode.get("baseUrl").asText());
        dataModel.put("endpoint", rootNode.get("endpoint").asText());

        // API 전체 URL 구성 (baseUrl + endpoint)
        dataModel.put("apiUrl", rootNode.get("baseUrl").asText() + rootNode.get("endpoint").asText());

        // DTO 및 API 클래스 생성 경로 설정
        String basePackagePath = "src/main/java/" + packageName.replace(".", "/") + "/";
        new File(basePackagePath).mkdirs();

        // 요청 DTO 클래스 생성
        Map<String, Object> requestModel = new HashMap<>(dataModel);
        requestModel.put("className", className + "Request");
        requestModel.put("fields", mapper.convertValue(rootNode.get("requestFields"), List.class));

        Template requestDtoTemplate = cfg.getTemplate("dto_request_template.ftl");
        try (Writer requestWriter = new FileWriter(new File(basePackagePath + className + "Request.java"))) {
            requestDtoTemplate.process(requestModel, requestWriter);
        }

        // 응답 DTO 클래스 생성
        Map<String, Object> responseModel = new HashMap<>(dataModel);
        responseModel.put("className", className + "Response");

        // JSON에서 responseFields를 가져오고, 없을 경우 빈 리스트로 설정
        List<Map<String, Object>> responseFields = mapper.convertValue(rootNode.get("responseFields"), List.class);
        if (responseFields == null) {
            responseFields = new ArrayList<>();
        }
        responseModel.put("responseFields", responseFields);

        Template responseDtoTemplate = cfg.getTemplate("dto_response_template.ftl");
        try (Writer responseWriter = new FileWriter(new File(basePackagePath + className + "Response.java"))) {
            responseDtoTemplate.process(responseModel, responseWriter);
        }

        // API 호출 클래스 생성
        Map<String, Object> apiModel = new HashMap<>(dataModel);
        apiModel.put("requestFields", mapper.convertValue(rootNode.get("requestFields"), List.class));
        apiModel.put("responseFields", responseFields);

        Template apiTemplate = cfg.getTemplate("api_template.ftl");
        try (Writer apiWriter = new FileWriter(new File(basePackagePath + className + "API.java"))) {
            apiTemplate.process(apiModel, apiWriter);
        }

        System.out.println("Generated files in: " + new File(basePackagePath).getAbsolutePath());
    }

    public static void main(String[] args) {
        try {
            CodeGenerator generator = new CodeGenerator();
            generator.generateCode("src/main/resources/api_spec.json");
            System.out.println("코드 생성이 완료되었습니다.");
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}
