package com.openmind.ezdg.datalist.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openmind.ezdg.datalist.dto.ApiDataDto;
import com.openmind.ezdg.file.dto.filesave.FileInfoDto;
import com.openmind.ezdg.file.util.CustomStringUtil;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DatalistService {
    private final MongoTemplate mongoTemplate;
    private final CustomStringUtil customStringUtil;
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

        // 라이브러리 상세 정보 추가
        dtoMap.putAll(libraryDetail(dto));

        mongoTemplate.insert(new Document(dtoMap), "data_list");
    }

    private Map<String, Object> libraryDetail(FileInfoDto dto) {
        Map<String, Object> result = new HashMap<>();
        String className = customStringUtil.capitalizeFirstLetter(customStringUtil.snakeCaseToCamelCase(dto.getTranslatedFileName()));

        // method
        List<Map<String, String>> methodList = new ArrayList<>();

        Map<String, String> fetchMethod = new HashMap<>();
        fetchMethod.put("returnType", "List<%s>".formatted(className));
        fetchMethod.put("method", "fetch()");
        fetchMethod.put("description", "조건에 맞는 데이터를 조회합니다");
        methodList.add(fetchMethod);

        Map<String, String> pageMethod = new HashMap<>();
        pageMethod.put("returnType", className + "API");
        pageMethod.put("method", "page(int page)");
        pageMethod.put("description", "조회할 페이지를 지정합니다 최소 0부터 시작합니다");
        methodList.add(pageMethod);

        Map<String, String> perPageMethod = new HashMap<>();
        perPageMethod.put("returnType", className + "API");
        perPageMethod.put("method", "perPage(int perPage)");
        perPageMethod.put("description", "페이지당 조회할 데이터 수를 지정합니다");
        methodList.add(perPageMethod);


        dto.getFields().stream().forEach(field -> {
            Map<String, String> matchMethod = new HashMap<>();
            matchMethod.put("returnType", className + "API");
            matchMethod.put("method", "%s(%s %s)".formatted(field.getTranslatedName(), field.getType(), field.getTranslatedName()));
            matchMethod.put("description", "조회 조건을 \"%s\"가 %s로 일치하는 데이터로 지정합니다".formatted(field.getOriginalName(), field.getTranslatedName()));
            methodList.add(matchMethod);

            switch (field.getType()) {
                case "String":
                    // containing
                    Map<String, String> containingMethod = new HashMap<>();
                    containingMethod.put("returnType", className + "API");
                    containingMethod.put("method", "%sContaining(String %s)".formatted(field.getTranslatedName(), field.getTranslatedName()));
                    containingMethod.put("description", "조회 조건을 \"%s\"가 %s를 포함하는 데이터로 지정합니다".formatted(field.getOriginalName(), field.getTranslatedName()));
                    methodList.add(containingMethod);
                    break;

                case "LocalDate":
                case "LocalDateTime":
                    //before
                    Map<String, String> beforeMethod = new HashMap<>();
                    beforeMethod.put("returnType", className + "API");
                    beforeMethod.put("method", "%sBefore(Date %s)".formatted(field.getTranslatedName(), field.getTranslatedName()));
                    beforeMethod.put("description", "조회 조건을 \"%s\"가 %s 이전인 데이터로 지정합니다".formatted(field.getOriginalName(), field.getTranslatedName()));
                    methodList.add(beforeMethod);

                    //after
                    Map<String, String> afterMethod = new HashMap<>();
                    afterMethod.put("returnType", className + "API");
                    afterMethod.put("method", "%sAfter(Date %s)".formatted(field.getTranslatedName(), field.getTranslatedName()));
                    afterMethod.put("description", "조회 조건을 \"%s\"가 %s 이후인 데이터로 지정합니다".formatted(field.getOriginalName(), field.getTranslatedName()));
                    methodList.add(afterMethod);


                    break;

                case "Integer":
                case "Long":
                case "Double":
                    // gt
                    Map<String, String> gtMethod = new HashMap<>();
                    gtMethod.put("returnType", className + "API");
                    gtMethod.put("method", "%sGt(%s %s)".formatted(field.getTranslatedName(), field.getType(), field.getTranslatedName()));
                    gtMethod.put("description", "조회 조건을 \"%s\"가 %s보다 큰 데이터로 지정합니다".formatted(field.getOriginalName(), field.getTranslatedName()));
                    methodList.add(gtMethod);


                    // gte
                    Map<String, String> gteMethod = new HashMap<>();
                    gteMethod.put("returnType", className + "API");
                    gteMethod.put("method", "%sGte(%s %s)".formatted(field.getTranslatedName(), field.getType(), field.getTranslatedName()));
                    gteMethod.put("description", "조회 조건을 \"%s\"가 %s보다 크거나 같은 데이터로 지정합니다".formatted(field.getOriginalName(), field.getTranslatedName()));
                    methodList.add(gteMethod);


                    // lt
                    Map<String, String> ltMethod = new HashMap<>();
                    ltMethod.put("returnType", className + "API");
                    ltMethod.put("method", "%sLt(%s %s)".formatted(field.getTranslatedName(), field.getType(), field.getTranslatedName()));
                    ltMethod.put("description", "조회 조건을 \"%s\"가 %s보다 작은 데이터로 지정합니다".formatted(field.getOriginalName(), field.getTranslatedName()));
                    methodList.add(ltMethod);


                    // lte
                    Map<String, String> lteMethod = new HashMap<>();
                    lteMethod.put("returnType", className + "API");
                    lteMethod.put("method", "%sLte(%s %s)".formatted(field.getTranslatedName(), field.getType(), field.getTranslatedName()));
                    lteMethod.put("description", "조회 조건을 \"%s\"가 %s보다 작거나 같은 데이터로 지정합니다".formatted(field.getOriginalName(), field.getTranslatedName()));
                    methodList.add(lteMethod);
                    break;
            }
        });

        result.put("methodList", methodList);
        return result;
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
