package com.openmind.ezdg.datalist.service;

import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DatalistService {
    private final MongoTemplate mongoTemplate;

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
}
