package com.openmind.ezdg.file.controller;

import com.openmind.ezdg.file.dto.filesave.MongoBsonValueDto;
import com.openmind.ezdg.file.service.CsvSaveService;
import com.openmind.ezdg.file.service.RedisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/redis")
public class RedisSaveTestController {
    private final CsvSaveService csvSaveService;

    public  RedisSaveTestController(CsvSaveService csvSaveService, RedisService redisService, CsvSaveService csvSaveService1) {
        this.csvSaveService = csvSaveService1;
    }

    @GetMapping("redis/{collectionName}")
    public List<List<MongoBsonValueDto>> getSavedData(@PathVariable String collectionName) {
        return csvSaveService.getSavedData(collectionName);
    }

//    @GetMapping("db/{collectionNameOld}")
//    public List<List<MongoBsonValueDto>> getSavedDataOld(@PathVariable String collectionNameOld) {
//        return csvSaveService.getSavedDataOld(collectionNameOld, 5, 1);
//    }

    @GetMapping("db/{collectionNameOld}")
    public List<List<MongoBsonValueDto>> getSavedDataOld(
            @PathVariable String collectionNameOld
    ) {
        return csvSaveService.getSavedDataOld(collectionNameOld);
    }

    @GetMapping("/memory-info")
    public Map<String, String> getRedisMemoryInfo() {
        return csvSaveService.getMemoryInfo();
    }
}
