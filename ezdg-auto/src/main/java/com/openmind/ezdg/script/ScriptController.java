package com.openmind.ezdg.script;

import com.openmind.ezdg.datalist.service.DatalistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/script")
public class ScriptController {
    private final ScriptService scriptService;
    private final DatalistService datalistService;

    @PostMapping("/release")
    public boolean release() {
        // web hook을 통해 쉘 스크립트를 실행시켜서 master 브랜치에 코드를 올린다.
        boolean uploaded = scriptService.releaseHook();
        System.out.println("uploaded = " + uploaded);
        if (!uploaded) return false;
        datalistService.deployDocument();
        return true;

    }

    @PostMapping("/deploy")
    public boolean deploy() {
        return true;
    }
}