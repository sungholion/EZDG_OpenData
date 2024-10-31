package com.openmind.ezdg.generate.server.service;

import freemarker.template.TemplateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class APIServerGenerateServiceTest {
    private APIServerGenerateService aPIServerGenerateService;

    @BeforeEach
    void setUp() {
        aPIServerGenerateService = new APIServerGenerateService();

        // 테스트용 임시 경로 설정
        ReflectionTestUtils.setField(aPIServerGenerateService, "apiServerProjectPath", "test-output/");

        // 테스트용 디렉토리 생성
        new File("test-output/").mkdirs();
    }

    @Test
    void testGenerateDTOFile() throws IOException, TemplateException {
        // 테스트 데이터 설정
        Map<String, Object> data = new HashMap<>();
        data.put("className", "Test");
        data.put("fields", List.of(
                Map.of("type", "String", "name", "region"),
                Map.of("type", "Double", "name", "temperature")
        ));

        // 파일 생성 테스트
        aPIServerGenerateService.generate(data);

        // Controller 파일이 생성되었는지 확인
        File controllerFile = new File("test-output/TestController.java");
        assertTrue(controllerFile.exists());

        // Service 파일이 생성되었는지 확인
        File serviceFile = new File("test-output/TestService.java");
        assertTrue(serviceFile.exists());

        // Entity 파일이 생성되었는지 확인
        File entityFile = new File("test-output/Test.java");
        assertTrue(entityFile.exists());

        // 생성된 파일 내용 출력
        System.out.println("Controller 파일 내용:");
        Files.readAllLines(controllerFile.toPath()).forEach(System.out::println);

        System.out.println("Service 파일 내용:");
        Files.readAllLines(serviceFile.toPath()).forEach(System.out::println);

        System.out.println("Entity 파일 내용:");
        Files.readAllLines(entityFile.toPath()).forEach(System.out::println);

        // 테스트가 끝난 후 파일 삭제
        controllerFile.delete();
        serviceFile.delete();
        entityFile.delete();

    }
}
