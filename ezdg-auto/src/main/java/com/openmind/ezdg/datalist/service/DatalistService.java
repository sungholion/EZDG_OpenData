package com.openmind.ezdg.datalist.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openmind.ezdg.datalist.dto.ApiDataDto;
import com.openmind.ezdg.datalist.dto.FileDataDto;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DatalistService {
    private final MongoTemplate mongoTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Document> getMenuList() {
        Query query = new Query();

        // "type" 필드가 "file"인 경우
        Criteria fileCriteria = Criteria.where("type").is("file").and("deployed").is(true);
        Query fileQuery = new Query(fileCriteria);
        fileQuery.fields().exclude("fields");

        // "type" 필드가 "api"인 경우
        Criteria apiCriteria = Criteria.where("type").is("api").and("deployed").is(true);
        Query apiQuery = new Query(apiCriteria);
        apiQuery.fields().include("age").include("type");

        // 두 개의 쿼리 결과 합치기
        List<Document> fileResults = mongoTemplate.find(fileQuery, Document.class, "data_list").stream().map(doc -> {
            doc.put("_id", new ObjectId(doc.get("_id").toString()).toHexString());
            return doc;
        }).collect(Collectors.toList());
        List<Document> apiResults = mongoTemplate.find(apiQuery, Document.class, "data_list")
                .stream().map(doc -> {
                    doc.put("_id", new ObjectId(doc.get("_id").toString()).toHexString());
                    return doc;
                }).collect(Collectors.toList());

        // 두 결과를 합쳐서 반환
        fileResults.addAll(apiResults);
        return fileResults;
    }

    // 코드 중복 확인
    public boolean isDuplicatedCode(String code) {
        Query query = new Query();
        query.addCriteria(Criteria.where("code").is(code));
        return mongoTemplate.exists(query, "data_list");
    }

    // 번역된 이름 중복 확인
    public boolean isDuplicatedTranslatedName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("translatedName").is(name));
        return mongoTemplate.exists(query, "data_list");
    }

    public void saveDocument(FileDataDto dto) {
        // DTO를 Map으로 변환
        Map<String, Object> dtoMap = objectMapper.convertValue(dto, Map.class);

        // 추가 필드와 병합
        LocalDateTime currentDateTime = LocalDateTime.now();
        dtoMap.put("createdAt", currentDateTime);
        dtoMap.put("updatedAt", currentDateTime);
        dtoMap.put("type", "file");
        dtoMap.put("deployed", false);

        mongoTemplate.insert(new Document(dtoMap), "data_list");
    }

    public void saveDocument(ApiDataDto dto) {
        // DTO를 Map으로 변환
        Map<String, Object> dtoMap = objectMapper.convertValue(dto, Map.class);

        // 추가 필드와 병합
        LocalDateTime currentDateTime = LocalDateTime.now();
        dtoMap.put("createdAt", currentDateTime);
        dtoMap.put("updatedAt", currentDateTime);
        dtoMap.put("type", "api");
        dtoMap.put("deployed", false);
        mongoTemplate.insert(new Document(dtoMap), "data_list");
    }

    public void saveTest() {
        FileDataDto fileDataDto = new FileDataDto();
        fileDataDto.setOriginalFileName("originalFileName");
        fileDataDto.setTranslatedFileName("translatedFileName");
        List<Map<String, String>> fields = List.of(Map.of("key1", "value1"), Map.of("key2", "value2"));
        fileDataDto.setFields(fields);
        saveDocument(fileDataDto);
    }
}
