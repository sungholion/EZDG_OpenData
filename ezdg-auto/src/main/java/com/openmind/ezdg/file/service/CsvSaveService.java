package com.openmind.ezdg.file.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.openmind.ezdg.file.dto.filesave.MongoBsonValueDto;
import com.openmind.ezdg.file.dto.filesave.ValidateDuplicateCodeDto;
import com.openmind.ezdg.file.entity.PublicDataCode;
import com.openmind.ezdg.file.repository.CsvSaveRepository;
import com.openmind.ezdg.file.repository.PublicDataCodeRepository;
import com.openmind.ezdg.file.util.CustomStringUtil;
import com.openmind.ezdg.file.util.PapagoUtil;
import com.openmind.ezdg.file.util.TypeConvertUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.BsonDocument;
import org.bson.BsonType;
import org.bson.BsonValue;
import org.bson.Document;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
@Cacheable(cacheNames = "myCache")
public class CsvSaveService {

    private final PapagoUtil papagoUtil;
    private final CustomStringUtil customStringUtil;
    private final PublicDataCodeRepository publicDataCodeRepository;
    private final TypeConvertUtil typeConvertUtil;
    private final CsvSaveRepository csvSaveRepository;
    private final MongoTemplate mongoTemplate;
    private final RedisTemplate<String, String> redisTemplate;

    /**
     * mongoDB에 insert
     * FIXME 많은 데이터가 들어가면 시간이 오래 걸려서 최적화 필요(멀티스레드 or mongoTemplate에서 제공하는 메서드 등)
     */
    @Transactional
    public void saveFile(List<String[]> datas, String translatedFileName, List<String> translatedColumns) {
        csvSaveRepository.createCollection(translatedFileName);
        MongoCollection<Document> collection = csvSaveRepository.getCollection(translatedFileName);
        List<Document> documents = getDocuments(datas, translatedColumns);
        csvSaveRepository.insertDocuments(collection, documents);
    }

    private List<Document> getDocuments(List<String[]> datas, List<String> translatedColumns) {
        List<Document> documents = new ArrayList<>();
        if (datas == null || datas.size() <= 1) return documents;

        Map<String, String> columnDataTypes = new HashMap<>();
        String[] firstRow = datas.get(1);
        for (int j = 0; j < translatedColumns.size(); j++) {
            String columnName = translatedColumns.get(j);
            String value = j < firstRow.length ? firstRow[j] : null;
            String dataType = typeConvertUtil.getDataTypeFromString(value);
            columnDataTypes.put(columnName, dataType);
        }

        for (int i = 2; i < datas.size(); i++) {
            String[] row = datas.get(i);
            for (int j = 0; j < row.length; j++) {
                String columnName = translatedColumns.get(j);
                String value = row[j];
                String currentDataType = typeConvertUtil.getDataTypeFromString(value);
                if (!"String".equals(columnDataTypes.get(columnName)) &&
                        !currentDataType.equals(columnDataTypes.get(columnName))) {
                    log.info("Expected Type : " + columnDataTypes.get(columnName));
                    columnDataTypes.put(columnName, "String");
                    log.info("Current Type : " + columnDataTypes.get(columnName));
                    log.info("Because : " + columnName);
                    break;
                }
            }
        }

        for (int i = 1; i < datas.size(); i++) {
            String[] row = datas.get(i);
            Map<String, Object> documentMap = new HashMap<>();
            for (int j = 0; j < row.length; j++) {
                String columnName = translatedColumns.get(j);
                String value = row[j];
                String dataType = columnDataTypes.get(columnName);
                putDocumentByDataType(dataType, documentMap, columnName, value);
            }
            documents.add(new Document(documentMap));
        }
        return documents;
    }

    private static void putDocumentByDataType(String dataType, Map<String, Object> documentMap, String columnName, String value) {
        switch (dataType) {
            case "Long":
                documentMap.put(columnName, Long.parseLong(value));
                break;
            case "Double":
                documentMap.put(columnName, Double.parseDouble(value));
                break;
            case "LocalDate":
                documentMap.put(columnName, TypeConvertUtil.parseToLocalDate(value));
                break;
            case "LocalDateTime":
                documentMap.put(columnName, TypeConvertUtil.parseToLocalDateTime(value));
                break;
            default:
                documentMap.put(columnName, value);
                break;
        }
    }

    /**
     * 네이버 papago api를 활용해서 한글 파일명을 영어로 변환 및 문자열 정리
     * FIXME 예외 케이스 처리 추가 필요
     */
    public String getTranslatedFileName(String originalFilename) {
        String translatedFileName = papagoUtil.translateFileName(originalFilename);
        return customStringUtil.normalizeFileName(translatedFileName);
    }

    /**
     * 읽은 csv 파일에서 칼럼 정보만 추출
     */
    public List<String> getOriginalColumns(List<String[]> datas) {
        return Arrays.stream(datas.get(0))
                .map(String::trim)
                .toList();
    }

    /**
     * 네이버 papago api를 활용해서 한글 칼럼명을 영어로 변환 및 문자열 정리
     * FIXME 예외 케이스 처리 추가 필요
     */
    public List<String> getTranslatedColumns(List<String> originalColumns) {
        String[] translatedColumns = papagoUtil.translateColumns(originalColumns.toArray(new String[0])).split(",");
        translatedColumns = customStringUtil.normalizeColumnNames(translatedColumns);
//        customStringUtil.deleteLastAnd(translatedColumns);
        return Arrays.asList(translatedColumns);
    }

    /**
     * 중복된 데이터인지 확인
     */
    public ValidateDuplicateCodeDto validateDuplicateCode(String code) {
        Optional<PublicDataCode> publicDataCodeOpt = publicDataCodeRepository.findByCode(code);

        if(publicDataCodeOpt.isEmpty()) {
            return new ValidateDuplicateCodeDto(false, null);
        }
        return new ValidateDuplicateCodeDto(true, publicDataCodeOpt.orElseThrow().getRegDate());
    }

    /**
     * 중복 검사를 하기 위해 새로운 데이터 삽입 시 공공데이터 code 값 mongoDB에 저장
     *
     */
    public void insertCode(String code) {
        publicDataCodeRepository.save(PublicDataCode.builder()
                .code(code)
                .regDate(LocalDateTime.now())
                .build());
    }

    /**
     * db에서 데이터 조회
     */
    public List<List<MongoBsonValueDto>> getSavedData(String collectionName) {
        List<List<MongoBsonValueDto>> result = new ArrayList<>();

        MongoCollection<Document> collection = csvSaveRepository.getCollection(collectionName);

        try (MongoCursor<Document> cursor = collection.find().limit(1).iterator()) {
            List<MongoBsonValueDto> documents = new ArrayList<>();
            while(cursor.hasNext()) {
                Document document = cursor.next();

                BsonDocument bsonDoc = document.toBsonDocument(BsonDocument.class, mongoTemplate.getConverter().getCodecRegistry());

                for(Map.Entry<String, BsonValue> entry : bsonDoc.entrySet()) {
                    String fieldName = entry.getKey();
                    if(fieldName.equals("_id")) continue;

                    BsonValue fieldValue = entry.getValue();
                    BsonType fieldType = fieldValue.getBsonType();

                    documents.add(new MongoBsonValueDto(fieldName, customStringUtil.bsonValueToStr(fieldValue), fieldType.toString()));
                }
            }
            result.add(documents);
        }
        System.out.println("db search");
        return result;

    }

    /**
     *
     * redis를 사용해서 데이터 조회
     *
     */
//    public List<List<MongoBsonValueDto>> getSavedDataRedis(String collectionName) {
//        String cacheKey = "collectionName::" + collectionName;
//        ValueOperations<String, String> ops = redisTemplate.opsForValue();
//        ObjectMapper objectMapper = new ObjectMapper();
//        String cacheData = ops.get(cacheKey);
//
//        if (cacheData != null) {
//            System.out.println("hit");
//            log.info("Redis cache hit for collection: {}", collectionName);
//            try {
//                return objectMapper.readValue(cacheData, new TypeReference<>() {});
//            } catch (JsonProcessingException e) {
//                log.error("Error parsing JSON from Redis", e);
//            }
//        }
//
//        List<List<MongoBsonValueDto>> result = fetchFromMongoDB(collectionName);
//        try {
//            String jsonData = objectMapper.writeValueAsString(result);
//            ops.set(cacheKey, jsonData, 12, TimeUnit.HOURS);
//        } catch (JsonProcessingException e) {
//            log.error("Error serializing data to JSON for Redis", e);
//        }
//
//        return result;
//    }
//
//    private List<List<MongoBsonValueDto>> fetchFromMongoDB(String collectionName) {
//        List<List<MongoBsonValueDto>> result = new ArrayList<>();
//        MongoCollection<Document> collection = csvSaveRepository.getCollection(collectionName);
//
//        // 한 페이지씩 데이터를 가져오기 위해 limit(1)로 설정
//        try (MongoCursor<Document> cursor = collection.find().limit(1).iterator()) {
//            while (cursor.hasNext()) {
//                List<MongoBsonValueDto> documentList = new ArrayList<>();
//                Document document = cursor.next();
//                BsonDocument bsonDoc = document.toBsonDocument(BsonDocument.class, mongoTemplate.getConverter().getCodecRegistry());
//
//                for (Map.Entry<String, BsonValue> entry : bsonDoc.entrySet()) {
//                    String fieldName = entry.getKey();
//                    if (!fieldName.equals("_id")) {
//                        BsonValue fieldValue = entry.getValue();
//                        BsonType fieldType = fieldValue.getBsonType();
//                        documentList.add(new MongoBsonValueDto(fieldName, customStringUtil.bsonValueToStr(fieldValue), fieldType.toString()));
//                    }
//                }
//                result.add(documentList);
//            }
//        }
//        return result;
//    }

//    public List<List<MongoBsonValueDto>> getSavedDataRedis(String collectionName) {
//        List<List<MongoBsonValueDto>> result = new ArrayList<>();
//        ObjectMapper objectMapper = new ObjectMapper();
//        ValueOperations<String, String> ops = redisTemplate.opsForValue();
//
//        int pageSize = 1; // 페이지 당 문서 수 설정
//        int currentPage = 1;
//
//        while (true) {
//            String cacheKey = "collectionName::" + collectionName + "::page::" + currentPage;
//            String cacheData = ops.get(cacheKey);
//
//            if (cacheData != null) {
//
//                log.info("Redis cache hit for collection: {} on page: {}", collectionName, currentPage);
//                try {
//                    List<List<MongoBsonValueDto>> pageData = objectMapper.readValue(cacheData, new TypeReference<>() {});
//                    result.addAll(pageData);
//                } catch (JsonProcessingException e) {
//                    log.error("Error parsing JSON from Redis", e);
//                }
//            } else {
//                // Redis에 해당 페이지 데이터가 없을 때, MongoDB에서 조회하여 캐시에 저장
//                List<List<MongoBsonValueDto>> pageData = fetchFromMongoDB(collectionName, currentPage, pageSize);
//                if (pageData.isEmpty()) {
//                    break; // MongoDB에서 더 이상 가져올 데이터가 없으면 종료
//                }
//                try {
//                    String jsonData = objectMapper.writeValueAsString(pageData);
//                    ops.set(cacheKey, jsonData, 12, TimeUnit.HOURS); // 페이지 데이터를 캐시에 저장
//                    result.addAll(pageData);
//                } catch (JsonProcessingException e) {
//                    log.error("Error serializing data to JSON for Redis", e);
//                }
//            }
//            currentPage++;
//        }
//
//        return result;
//    }
//
//    // MongoDB에서 페이지별로 데이터를 가져오는 메서드
//    private List<List<MongoBsonValueDto>> fetchFromMongoDB(String collectionName, int page, int pageSize) {
//        List<List<MongoBsonValueDto>> result = new ArrayList<>();
//        MongoCollection<Document> collection = csvSaveRepository.getCollection(collectionName);
//
//        int skip = (page - 1) * pageSize;
//        try (MongoCursor<Document> cursor = collection.find().skip(skip).limit(pageSize).iterator()) {
//            while (cursor.hasNext()) {
//                List<MongoBsonValueDto> documentList = new ArrayList<>();
//                Document document = cursor.next();
//                BsonDocument bsonDoc = document.toBsonDocument(BsonDocument.class, mongoTemplate.getConverter().getCodecRegistry());
//
//                for (Map.Entry<String, BsonValue> entry : bsonDoc.entrySet()) {
//                    String fieldName = entry.getKey();
//                    if (!fieldName.equals("_id")) {
//                        BsonValue fieldValue = entry.getValue();
//                        BsonType fieldType = fieldValue.getBsonType();
//                        documentList.add(new MongoBsonValueDto(fieldName, customStringUtil.bsonValueToStr(fieldValue), fieldType.toString()));
//                    }
//                }
//                result.add(documentList);
//            }
//        }
//        return result;
//    }

    public List<List<MongoBsonValueDto>> getSavedDataRedis(String collectionName) {
        List<List<MongoBsonValueDto>> result = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        ValueOperations<String, String> ops = redisTemplate.opsForValue();

        int pageSize = 1; // 페이지 당 문서 수 설정
        int currentPage = 1;

        while (true) {
            String cacheKey = "collectionName::" + collectionName + "::page::" + currentPage;
            String cacheData = ops.get(cacheKey);

            if (cacheData != null) {
                log.info("Redis cache hit for collection: {} on page: {}", collectionName, currentPage);
                try {
                    List<List<MongoBsonValueDto>> pageData = objectMapper.readValue(cacheData, new TypeReference<>() {});
                    result.addAll(pageData);
                } catch (JsonProcessingException e) {
                    log.error("Error parsing JSON from Redis", e);
                }
            } else {
                List<List<MongoBsonValueDto>> pageData = fetchFromMongoDB(collectionName, currentPage, pageSize);
                if (pageData.isEmpty()) {
                    break; // MongoDB에서 더 이상 가져올 데이터가 없으면 종료
                }
                try {
                    String jsonData = objectMapper.writeValueAsString(pageData);
                    ops.set(cacheKey, jsonData, 12, TimeUnit.HOURS); // 페이지 데이터를 캐시에 저장
                    result.addAll(pageData);
                } catch (JsonProcessingException e) {
                    log.error("Error serializing data to JSON for Redis", e);
                }
            }
            currentPage++;
        }

        return result;
    }

    // MongoDB에서 페이지별로 데이터를 가져오는 메서드
    private List<List<MongoBsonValueDto>> fetchFromMongoDB(String collectionName, int page, int pageSize) {
        List<List<MongoBsonValueDto>> result = new ArrayList<>();
        MongoCollection<Document> collection = csvSaveRepository.getCollection(collectionName);

        int skip = (page - 1) * pageSize;
        try (MongoCursor<Document> cursor = collection.find().skip(skip).limit(pageSize).iterator()) {
            while (cursor.hasNext()) {
                List<MongoBsonValueDto> documentList = new ArrayList<>();
                Document document = cursor.next();
                BsonDocument bsonDoc = document.toBsonDocument(BsonDocument.class, mongoTemplate.getConverter().getCodecRegistry());

                for (Map.Entry<String, BsonValue> entry : bsonDoc.entrySet()) {
                    String fieldName = entry.getKey();
                    if (!fieldName.equals("_id")) {
                        BsonValue fieldValue = entry.getValue();
                        BsonType fieldType = fieldValue.getBsonType();
                        documentList.add(new MongoBsonValueDto(fieldName, customStringUtil.bsonValueToStr(fieldValue), fieldType.toString()));
                    }
                }
                result.add(documentList);
            }
        }
        return result;
    }


}
