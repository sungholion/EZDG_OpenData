package com.openmind.ezdg.script;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/script")
public class ScriptController {

    @Value("${path.release-sh-path}")
    private String releaseShPath;

    @GetMapping("/run")
    public ResponseEntity<String> runScript() {
        try {
            // 호스트 OS의 스크립트 경로
            ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash", releaseShPath);
            processBuilder.start();
            return ResponseEntity.ok("Script executed successfully!");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error executing script.");
        }
    }
}