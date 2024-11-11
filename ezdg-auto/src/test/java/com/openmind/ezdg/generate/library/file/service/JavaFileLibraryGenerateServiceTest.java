//package com.openmind.ezdg.generate.library.file.service;
//
//import freemarker.template.TemplateException;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.test.util.ReflectionTestUtils;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class JavaFileLibraryGenerateServiceTest {
//
//    private JavaFileLibraryGenerateService javaFileLibraryGenerateService;
//
//    @BeforeEach
//    void setUp() {
//        javaFileLibraryGenerateService = new JavaFileLibraryGenerateService();
//
//        // 테스트용 임시 경로 설정
//        ReflectionTestUtils.setField(javaFileLibraryGenerateService, "javaLibraryProjectPath", "test-output/");
//
//        // 테스트용 디렉토리 생성
//        new File("test-output/").mkdirs();
//    }
//
//    @Test
//    void testGenerateDTOFile() throws IOException, TemplateException {
//        // 테스트 데이터 설정
//        Map<String, Object> data = new HashMap<>();
//        data.put("className", "Test");
//        data.put("fields", List.of(
//                Map.of("type", "String", "name", "region"),
//                Map.of("type", "Double", "name", "temperature")
//        ));
//
//        // 파일 생성 테스트
//        javaFileLibraryGenerateService.generate(data);
//
//        // DTO 파일이 생성되었는지 확인
//        File dtoFile = new File("test-output/TestDTO.java");
//        assertTrue(dtoFile.exists());
//
//        // API 파일이 생성되었는지 확인
//        File apiFile = new File("test-output/TestAPI.java");
//        assertTrue(apiFile.exists());
//
//        // 생성된 파일 내용 출력
//        System.out.println("DTO 파일 내용:");
//        Files.readAllLines(dtoFile.toPath()).forEach(System.out::println);
//
//        System.out.println("API 파일 내용:");
//        Files.readAllLines(apiFile.toPath()).forEach(System.out::println);
//
//        // 테스트가 끝난 후 파일 삭제
//        dtoFile.delete();
//        apiFile.delete();
//    }
//}
