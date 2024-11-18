package com.openmind.ezdg.datalist.controller;

import com.openmind.ezdg.datalist.service.DatalistService;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public Document getDetail(@PathVariable String id) {

        return datalistService.getDetail(id);
    }

    @GetMapping("/{id}/{className}")
    public Document getDetail(@PathVariable String id, @PathVariable String className) {
        return datalistService.getDetail(id, className);
    }
}
