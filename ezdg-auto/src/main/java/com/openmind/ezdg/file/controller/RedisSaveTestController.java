package com.openmind.ezdg.file.controller;

import com.openmind.ezdg.file.dto.filesave.MongoBsonValueDto;
import com.openmind.ezdg.file.service.CsvSaveService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/redis")
public class RedisSaveTestController {
    private final CsvSaveService csvSaveService;

    public  RedisSaveTestController(CsvSaveService csvSaveService) {
        this.csvSaveService = csvSaveService;
    }

    @GetMapping("redis/{collectionName}")
    public List<List<MongoBsonValueDto>> getSavedData(@PathVariable String collectionName) {
        return csvSaveService.getSavedData(collectionName);
    }

    @GetMapping("db/{collectionNameOld}")
    public List<List<MongoBsonValueDto>> getSavedDataOld(@PathVariable String collectionNameOld) {
        return csvSaveService.getSavedDataOld(collectionNameOld);
    }

    @GetMapping("/memory-info")
    public Map<String, String> getRedisMemoryInfo() {
        return csvSaveService.getMemoryInfo();
    }
}
