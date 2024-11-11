package com.daegu.travel.controller;

import com.daegu.travel.dto.DaeguTravelDto;
import com.daegu.travel.repository.DaeguTravelRepository;
import com.daegu.travel.service.CsvService;
import com.daegu.travel.service.DaeguTravelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/daeguTravel")
@Tag(name = "대구 여행 코스 조회 API", description = "대구 여행 코스를 조회하는 공공 데이터 서비스")
public class DaeguTravelController {

    @Autowired // csv
    CsvService csvService;

    private final DaeguTravelRepository daeguTravelRepository;

    public DaeguTravelController(DaeguTravelRepository daeguTravelRepository) {
        this.daeguTravelRepository = daeguTravelRepository;
    }

    @Operation(summary = "csv import API", description = "CSV 파일이 저장된 로컬 Path를 입력하여 DB에 저장합니다.")
    @PostMapping("/import")
    public String importCsv(@RequestParam String filePath) {
        try {
            csvService.saveCsvData(filePath);
            return "CSV data imported successfully";
        } catch (IOException e) {
            return "Error reading CSV file: " + e.getMessage();
        }
    }

    @Operation(summary = "대구 여행 코스 조회 API", description = "대구광역시_관광코스 정보_20231215.csv 파일 데이터를 조회합니다.")
    @GetMapping("/getAllDaeguTravel")
    public List<DaeguTravelDto> getAllDaeguTravel() {
        return DaeguTravelService.getAllDaeguTravel();
    }

}
