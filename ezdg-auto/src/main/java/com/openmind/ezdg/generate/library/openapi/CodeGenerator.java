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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeGenerator {
    private final Configuration cfg;

    public CodeGenerator() throws IOException {
        // Freemarker 설정
        cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setDirectoryForTemplateLoading(new File("src/main/resources/templates/generate/library/openapi"));  // 템플릿 파일 경로 설정
    }

    public void generateCode(String jsonFilePath) throws IOException, TemplateException {
        // JSON 파일 파싱
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(new File(jsonFilePath));

        // JSON 데이터 모델로 변환
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("packageName", rootNode.get("packageName").asText());
        dataModel.put("className", rootNode.get("className").asText());
        dataModel.put("endpoint", rootNode.get("endpoint").asText());

        // DTO 및 API 클래스 생성 경로 설정
        String outputPath = "src/main/java/" + dataModel.get("packageName") + "/";
        new File(outputPath).mkdirs();

        // 요청 DTO 클래스 생성
        Map<String, Object> requestModel = new HashMap<>(dataModel);
        requestModel.put("className", dataModel.get("className") + "Request"); // 클래스명 WeatherRequest로 설정
        requestModel.put("fields", mapper.convertValue(rootNode.get("requestFields"), List.class));
        Template dtoTemplate = cfg.getTemplate("dto_template.ftl");
        try (Writer requestWriter = new FileWriter(new File(outputPath + requestModel.get("className") + ".java"))) {
            dtoTemplate.process(requestModel, requestWriter);
        }

        // 응답 DTO 클래스 생성
        Map<String, Object> responseModel = new HashMap<>(dataModel);
        responseModel.put("className", dataModel.get("className") + "Response"); // 클래스명 WeatherResponse로 설정
        responseModel.put("fields", mapper.convertValue(rootNode.get("responseFields"), List.class));
        try (Writer responseWriter = new FileWriter(new File(outputPath + responseModel.get("className") + ".java"))) {
            dtoTemplate.process(responseModel, responseWriter);
        }

        // API 호출 클래스 생성
        Map<String, Object> apiModel = new HashMap<>(dataModel);
        apiModel.put("requestFields", mapper.convertValue(rootNode.get("requestFields"), List.class));
        Template apiTemplate = cfg.getTemplate("api_template.ftl");
        try (Writer apiWriter = new FileWriter(new File(outputPath + dataModel.get("className") + "API.java"))) {
            apiTemplate.process(apiModel, apiWriter);
        }
    }

    public static void main(String[] args) {
        try {
            CodeGenerator generator = new CodeGenerator();
            generator.generateCode("src/main/resources/api_spec.json");  // JSON 명세 파일 경로
            System.out.println("코드 생성이 완료되었습니다.");
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}
