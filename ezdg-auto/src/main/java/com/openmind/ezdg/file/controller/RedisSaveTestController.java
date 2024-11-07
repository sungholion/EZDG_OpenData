package com.openmind.ezdg.file.controller;

import com.openmind.ezdg.file.dto.filesave.MongoBsonValueDto;
import com.openmind.ezdg.file.service.CsvSaveService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dataRead")
public class RedisSaveTestController {
    private final CsvSaveService csvSaveService;

    public RedisSaveTestController(CsvSaveService csvSaveService) {
        this.csvSaveService = csvSaveService;
    }


    @GetMapping("redis/{collectionName}")
    public List<List<MongoBsonValueDto>> getSavedDataRedis(@PathVariable String collectionName) {
        return csvSaveService.getSavedDataRedis(collectionName);
    }

    @GetMapping("db/{collectionName}")
    public List<List<MongoBsonValueDto>> getSavedData(
            @PathVariable String collectionName
    ) {
        return csvSaveService.getSavedData(collectionName);
    }

}
