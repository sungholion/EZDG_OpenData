package com.daegu.travel.service;

import com.daegu.travel.entity.DaeguTravelEntity;
import com.daegu.travel.repository.DaeguTravelRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class CsvService {

    private final DaeguTravelRepository daeguTravelRepository;

    public CsvService(DaeguTravelRepository daeguTravelRepository) {
        this.daeguTravelRepository = daeguTravelRepository;
    }

    public void saveCsvData(String filePath) throws IOException {
        try (CSVReader csvReader = new CSVReader(
                Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8))) {
            String[] splitted;
            csvReader.readNext();

            while ((splitted = csvReader.readNext()) != null) {
                DaeguTravelEntity daeguTravelEntity = new DaeguTravelEntity();
                daeguTravelEntity.setType(splitted[0]);                        // 분류 (Type)
                daeguTravelEntity.setTitle(splitted[1]);                       // 코스 타이틀 (Course Title)
                daeguTravelEntity.setCourseNum(Integer.parseInt(splitted[2])); // 코스 번호 (Course Number)
                daeguTravelEntity.setTopic(splitted[3]);                       // 코스 주제 (Course Topic)
                daeguTravelEntity.setTopicDescription(splitted[4]);            // 코스 주제 설명 (Course Topic Description)
                daeguTravelEntity.setRegion(splitted[5]);                      // 지역 (Region)
                daeguTravelEntity.setSpot(splitted[6]);                        // 관광지 (Tourist Attraction)
                daeguTravelEntity.setCourseDescription(splitted[7]);           // 코스 설명 (Course Description)
                daeguTravelEntity.setAddress(splitted[8]);                     // 주소 (Address)
                daeguTravelEntity.setPhone(splitted[9]);                       // 전화번호 (Phone Number)
                daeguTravelEntity.setHomepage(splitted[10]);                   // 홈페이지 (Homepage)

                daeguTravelRepository.save(daeguTravelEntity);
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
