package com.openmind.ezdg.datalist.controller;

import com.openmind.ezdg.datalist.service.DatalistService;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/guide")
@RequiredArgsConstructor
@RestController
public class GuideController {
    private final DatalistService datalistService;

    @GetMapping("/menu")
    public List<Document> getMenuList() {
        return datalistService.getMenuList();
    }
}
