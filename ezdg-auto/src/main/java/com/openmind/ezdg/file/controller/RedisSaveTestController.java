package com.openmind.ezdg.file.controller;

import com.openmind.ezdg.file.dto.filesave.MongoBsonValueDto;
import com.openmind.ezdg.file.service.CsvSaveService;
import com.openmind.ezdg.file.service.RedisService;
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
    private final RedisService redisService;

    public  RedisSaveTestController(CsvSaveService csvSaveService, RedisService redisService) {
        this.csvSaveService = csvSaveService;
        this.redisService = redisService;
    }

    @GetMapping("redis/{collectionName}")
    public List<List<MongoBsonValueDto>> getSavedData(@PathVariable String collectionName) {
        return redisService.getSavedData(collectionName);
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
