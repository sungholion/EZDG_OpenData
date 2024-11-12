package com.openmind.ezdg.script;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/script")
public class ScriptController {

    private static final Logger log = LoggerFactory.getLogger(ScriptController.class);
    @Value("${path.release-sh-path}")
    private String releaseShPath;

    @GetMapping("/run")
    public ResponseEntity<String> runScript() {
        try {
            // 호스트 OS의 스크립트 경로
            ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash", releaseShPath);
            Process process = processBuilder.start();
            log.info("releasePath : {}", releaseShPath);
            // 프로세스의 출력 읽기
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                log.info("shell output : {}", line);  // "HELLO WORLD" 출력
            }

            // 프로세스 종료 코드 확인
            int exitCode = process.waitFor();
            System.out.println("Exit Code: " + exitCode);
            return ResponseEntity.ok("Script executed successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error executing script.");
        }
    }
}