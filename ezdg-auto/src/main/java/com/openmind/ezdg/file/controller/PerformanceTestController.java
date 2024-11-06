package com.openmind.ezdg.file.controller;

import com.openmind.ezdg.file.dto.filesave.MongoBsonValueDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/performance")
public class PerformanceTestController {

    @GetMapping("getDataFromMongo/{collectionName}")
    public List<List<MongoBsonValueDto>> getDataFromMongo(@PathVariable String collectionName) {
        return csvSaveService.getSavedDataOld(collectionName);
    }
}
