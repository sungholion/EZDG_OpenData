package com.openmind.ezdg.datalist.controller;

import com.openmind.ezdg.datalist.service.DatalistService;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/datalist")
@RequiredArgsConstructor
@RestController
public class DatalistController {
    private final DatalistService datalistService;

    @GetMapping("/duplicate/code")
    public boolean isDuplicatedCode(@RequestParam String code) {
        return datalistService.isDuplicatedCode(code);
    }

    @GetMapping("/duplicate/translatedName")
    public boolean isDuplicatedTranslatedName(@RequestParam String name) {
        return datalistService.isDuplicatedTranslatedName(name);
    }

    @GetMapping("")
    public List<Document> getDatalist() {
        return datalistService.getDataList();
    }

}
