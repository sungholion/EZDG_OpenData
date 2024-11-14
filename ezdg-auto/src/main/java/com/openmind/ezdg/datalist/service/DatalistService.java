package com.openmind.ezdg.datalist.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openmind.ezdg.datalist.dto.ApiDataDto;
import com.openmind.ezdg.file.dto.filesave.FileInfoDto;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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

    public Document getDetail(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Document.class, "data_list");
    }

    public Document getDetail(String id, String className) {
        Query query = new Query(Criteria.where("_id").is(id));
        Document document = mongoTemplate.findOne(query, Document.class, "data_list");

        if (document == null) return null;

        Document api = ((List<Document>) document.get("apiList")).stream()
                .filter(apiDoc -> className.equals(apiDoc.getString("className")))
                .findFirst()
                .orElse(null);
        document.put("api", api);
        document.remove("apiList");
        return document;
    }

    public List<Document> getMenuList() {
        Query query = new Query();

        // "type" 필드가 "file"인 경우
        Criteria fileCriteria = Criteria.where("type").is("file").and("deployed").is(true);
        Query fileQuery = new Query(fileCriteria);
        fileQuery.fields().exclude("fields");

        // "type" 필드가 "api"인 경우
        Criteria apiCriteria = Criteria.where("type").is("api").and("deployed").is(true);
        Query apiQuery = new Query(apiCriteria);

        // 두 개의 쿼리 결과 합치기
        List<Document> fileResults = mongoTemplate.find(fileQuery, Document.class, "data_list").stream().map(doc -> {
            doc.put("_id", new ObjectId(doc.get("_id").toString()).toHexString());
            return doc;
        }).collect(Collectors.toList());
        List<Document> apiResults = mongoTemplate.find(apiQuery, Document.class, "data_list")
                .stream().map(doc -> {
                    doc.put("_id", new ObjectId(doc.get("_id").toString()).toHexString());
                    List<Document> filteredApiList = ((List<Document>) doc.get("apiList"))
                            .stream()
                            .map(apiDoc -> {
                                Document filteredDoc = new Document();
                                filteredDoc.put("title", apiDoc.getString("title"));
                                filteredDoc.put("className", apiDoc.getString("className"));
                                return filteredDoc;
                            })
                            .collect(Collectors.toList());
                    doc.put("apiList", filteredApiList);
                    return doc;
                }).collect(Collectors.toList());

        // 두 결과를 합쳐서 반환
        fileResults.addAll(apiResults);
        return fileResults;
    }

    /**
     * 관리자 배포현황 조회용
     *
     * @return
     */
    public List<Document> getDataList() {
        return mongoTemplate.findAll(Document.class, "data_list").stream().map(doc -> {
            doc.put("_id", new ObjectId(doc.get("_id").toString()).toHexString());
            return doc;
        }).collect(Collectors.toList());
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

    public void saveDocument(FileInfoDto dto) {
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


    public void deployDocument() {
        System.out.println("배포 시작");
        Query query = new Query(Criteria.where("deployed").is(false));
        Update update = new Update().set("deployed", true);
        mongoTemplate.updateMulti(query, update, "data_list");

    }
}
