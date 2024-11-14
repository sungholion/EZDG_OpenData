package com.openmind.ezdg.datalist.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openmind.ezdg.algolia.AlgoliaSearchApiDetailDto;
import com.openmind.ezdg.algolia.AlgoliaSearchApiDto;
import com.openmind.ezdg.algolia.AlgoliaSearchFileDto;
import com.openmind.ezdg.algolia.AlgoliaService;
import com.openmind.ezdg.datalist.dto.ApiDataDto;
import com.openmind.ezdg.datalist.dto.MongoApiDto;
import com.openmind.ezdg.datalist.dto.MongoFileDto;
import com.openmind.ezdg.file.dto.filesave.FileInfoDto;
import com.openmind.ezdg.file.util.CustomStringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DatalistService {
    private final MongoTemplate mongoTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final AlgoliaService algoliaService;
    private final CustomStringUtil customStringUtil;

    public Document getDetail(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Document.class, "data_list");
    }

    public Document getDetail(String id, String className) {
        Query query = new Query(Criteria.where("_id").is(id));
        Document document = mongoTemplate.findOne(query, Document.class, "data_list");

        if (document == null) return null;
        List<Document> apiList = (List<Document>) document.get("apiList");
        return apiList.stream()
                .filter(apiDoc -> className.equals(apiDoc.getString("className")))
                .findFirst()
                .orElse(null);
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
        log.info("배포 시작");
        Query query = new Query(Criteria.where("deployed").is(false));

        // algolia 데이터 삽입
        addFileData();
        addApiData();

        // deployed -> true로 변경
        Update update = new Update().set("deployed", true);
        mongoTemplate.updateMulti(query, update, "data_list");
    }

    public void addDataTest() {
        // algolia 데이터 삽입
        addFileData();
        addApiData();
    }

    private void addApiData() {
        Criteria fileCriteria = Criteria.where("type").is("api").and("deployed").is(false);
        Query fileQuery = new Query(fileCriteria);
        List<MongoApiDto> apiDtos = mongoTemplate.find(fileQuery, MongoApiDto.class, "data_list");
        for (MongoApiDto apiDto : apiDtos) {
            for (MongoApiDto.ApiListInfo apiListInfo : apiDto.getApiList()) {
                AlgoliaSearchApiDto dto = new AlgoliaSearchApiDto(
                        customStringUtil.normalizeOriginalName(apiDto.getMainTitle()) + "_" + apiListInfo.getTitle(),
                        apiDto.getId(),
                        apiListInfo.getClassName()
                );
                log.info("insert algolia api data for {}", dto);
                algoliaService.addEzdgGuideSearchObject(dto);
            }
        }
    }

    private void addFileData() {
        Criteria fileCriteria = Criteria.where("type").is("file").and("deployed").is(false);
        Query fileQuery = new Query(fileCriteria);
        List<MongoFileDto> fileDtos = mongoTemplate.find(fileQuery, MongoFileDto.class, "data_list");
        for (MongoFileDto fileDto : fileDtos) {
            AlgoliaSearchFileDto dto = new AlgoliaSearchFileDto(
                    customStringUtil.normalizeOriginalName(fileDto.getOriginalFileName()),
                    fileDto.getId()
//                    customStringUtil.snakeCaseToCamelCase(fileDto.getTranslatedFileName())
            );
            log.info("insert algolia file data for {}", dto);
            algoliaService.addEzdgGuideSearchObject(dto);
        }
    }
}

