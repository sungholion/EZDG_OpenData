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
import com.openmind.ezdg.file.util.KryoSerializer;
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

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class CsvSaveService {

    private final PapagoUtil papagoUtil;
    private final CustomStringUtil customStringUtil;
    private final PublicDataCodeRepository publicDataCodeRepository;
    private final TypeConvertUtil typeConvertUtil;
    private final CsvSaveRepository csvSaveRepository;
    private final MongoTemplate mongoTemplate;
    private final RedisTemplate<String, String> redisTemplate;
    private final StringRedisTemplate stringRedisTemplate;
    private final RedisTemplate<String, byte[]> byteRedisTemplate;

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

    public List<List<MongoBsonValueDto>> getSavedData(String collectionName) {
        String cacheKey = "collectionName::" + collectionName;
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ObjectMapper objectMapper = new ObjectMapper();
        String cacheData = ops.get(cacheKey);

        if (cacheData != null) {
            log.info("Redis cache hit for collection: {}", collectionName);
            try {
                return objectMapper.readValue(cacheData, new TypeReference<>() {});
            } catch (JsonProcessingException e) {
                log.error("Error parsing JSON from Redis", e);
            }
        }

        List<List<MongoBsonValueDto>> result = fetchFromMongoDB(collectionName);
        try {
            String jsonData = objectMapper.writeValueAsString(result);
            ops.set(cacheKey, jsonData, 12, TimeUnit.HOURS);
        } catch (JsonProcessingException e) {
            log.error("Error serializing data to JSON for Redis", e);
        }

        return result;
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

//    /**
//     * 데이터가 잘 들어갔는지 확인하기 위해 db에서 조회한 뒤 결과 리턴
//     */
//    public List<List<MongoBsonValueDto>> getSavedData(String collectionName) {
//        ValueOperations<String, String> ops = redisTemplate.opsForValue();
//        ObjectMapper objectMapper = new ObjectMapper();
//
////        String cacheKey = "collectionName::" + collectionName;
//        String cacheData = ops.get("collectionName::" + collectionName);
//
////        // 캐시의 현재 남은 TTL 확인 및 출력
////        Long remainingTtl = redisTemplate.getExpire(cacheKey, TimeUnit.SECONDS);
////        if (remainingTtl != null && remainingTtl > 0) {
////            System.out.println("현재 캐시 유효 시간: " + remainingTtl + "초");
////        } else {
////            System.out.println("캐시가 존재하지 않거나 만료되었습니다.");
////        }
//
//
//        if(cacheData != null) {
//            System.out.println("redis에서 꺼낸 데이터 : " + cacheData);
//            try {
//                // JSON 데이터를 MongoBsonValueDto 리스트로 변환
////                redisTemplate.expire(cacheKey, Duration.ofHours(12));
//
////                // 갱신된 TTL 확인 및 출력
////                Long newTtl = redisTemplate.getExpire(cacheKey, TimeUnit.SECONDS);
////                System.out.println("갱신된 캐시 유효 시간: " + newTtl + "초");
////                log.info("캐시 히트\n");
//                return objectMapper.readValue(cacheData, new TypeReference<List<List<MongoBsonValueDto>>>() {});
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//        }
//
//        List<List<MongoBsonValueDto>> result = new ArrayList<>();
//
//        MongoCollection<Document> collection = csvSaveRepository.getCollection(collectionName);
//
//        try (MongoCursor<Document> cursor = collection.find().limit(1).iterator()) {
//            List<MongoBsonValueDto> documents = new ArrayList<>();
//            while(cursor.hasNext()) {
//                Document document = cursor.next();
//
//                BsonDocument bsonDoc = document.toBsonDocument(BsonDocument.class, mongoTemplate.getConverter().getCodecRegistry());
//
//                for(Map.Entry<String, BsonValue> entry : bsonDoc.entrySet()) {
//                    String fieldName = entry.getKey();
//                    if(fieldName.equals("_id")) continue;
//
//                    BsonValue fieldValue = entry.getValue();
//                    BsonType fieldType = fieldValue.getBsonType();
//
//                    documents.add(new MongoBsonValueDto(fieldName, customStringUtil.bsonValueToStr(fieldValue), fieldType.toString()));
//                }
//            }
//            result.add(documents);
//
//            // MongoDB에서 가져온 데이터를 Redis에 캐싱
//            try {
//                String jsonData = objectMapper.writeValueAsString(result);
//                ops.set("collectionName::" + collectionName, jsonData, Duration.ofHours(12));
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//        }
//
//        System.out.println("redis에 없는 데이터 : " + result);
//        return result;
//    }

//    public List<List<MongoBsonValueDto>> getSavedData(String collectionName) {
//        ValueOperations<String, byte[]> ops = byteRedisTemplate.opsForValue();
//        String cacheKey = "collectionName::" + collectionName;
//
//        // Try to get cached data
//        byte[] cacheData = ops.get(cacheKey);
//        if (cacheData != null) {
//            System.out.println("Using serialized data from Redis cache");
//            // Use Kryo deserialization
//            return KryoSerializer.deserialize(cacheData);
//        }
//
//        // If no cache, fetch data from MongoDB and serialize for caching
//        List<List<MongoBsonValueDto>> result = fetchFromMongoDB(collectionName);
//        byte[] serializedData = KryoSerializer.serialize(result);
//        ops.set(cacheKey, serializedData, Duration.ofHours(12));  // Set with a TTL of 12 hours
//
//        return result;
//    }


//    public List<List<MongoBsonValueDto>> getSavedData(String collectionName) {
//        List<List<MongoBsonValueDto>> result = new ArrayList<>();
//        MongoCollection<Document> collection = csvSaveRepository.getCollection(collectionName);
//        ValueOperations<String, byte[]> ops = byteRedisTemplate.opsForValue();
//
//        // MongoDB의 모든 문서를 순회하면서 Redis에 개별 저장
//        try (MongoCursor<Document> cursor = collection.find().iterator()) {
//            while (cursor.hasNext()) {
//                Document document = cursor.next();
//                String documentId = document.getObjectId("_id").toHexString();  // MongoDB의 _id를 사용
//                String cacheKey = collectionName + ":" + documentId;
//
//                // Redis에서 개별 문서 데이터를 가져오거나 캐시되지 않았다면 MongoDB 데이터 사용
//                byte[] cacheData = ops.get(cacheKey);
//                List<MongoBsonValueDto> documentData;
//
//                if (cacheData != null) {
//                    System.out.println("Using cached document from Redis for ID: " + documentId);
//                    documentData = KryoSerializer.deserialize(cacheData);
//                } else {
//                    // MongoDB에서 데이터 조회 후 Redis에 개별 캐시로 저장
//                    documentData = convertDocumentToDtoList(document);
//                    byte[] serializedData = KryoSerializer.serialize(documentData);
//                    ops.set(cacheKey, serializedData, Duration.ofHours(12));  // TTL 설정
//                }
//
//                result.add(documentData);
//            }
//        }
//        return result;
//    }
//
//    // 문서를 MongoBsonValueDto 목록으로 변환하는 헬퍼 메서드
//    private List<MongoBsonValueDto> convertDocumentToDtoList(Document document) {
//        List<MongoBsonValueDto> documents = new ArrayList<>();
//        BsonDocument bsonDoc = document.toBsonDocument(BsonDocument.class, mongoTemplate.getConverter().getCodecRegistry());
//
//        for (Map.Entry<String, BsonValue> entry : bsonDoc.entrySet()) {
//            String fieldName = entry.getKey();
//            if (fieldName.equals("_id")) continue;  // _id 필드는 제외
//
//            BsonValue fieldValue = entry.getValue();
//            BsonType fieldType = fieldValue.getBsonType();
//            documents.add(new MongoBsonValueDto(fieldName, customStringUtil.bsonValueToStr(fieldValue), fieldType.toString()));
//        }
//        return documents;
//    }

    private List<List<MongoBsonValueDto>> fetchFromMongoDB(String collectionName) {
        List<List<MongoBsonValueDto>> result = new ArrayList<>();
        MongoCollection<Document> collection = csvSaveRepository.getCollection(collectionName);

        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                List<MongoBsonValueDto> documentList = new ArrayList<>();
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


    /**
     * 데이터가 잘 들어갔는지 확인하기 위해 db에서 조회한 뒤 결과 리턴
     */
    public List<List<MongoBsonValueDto>> getSavedDataOld(String collectionNameOld) {
        List<List<MongoBsonValueDto>> result = new ArrayList<>();

        MongoCollection<Document> collection = csvSaveRepository.getCollection(collectionNameOld);

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
        return result;

    }




    public Map<String, String> getMemoryInfo() {
        // INFO memory 명령 실행
        String memoryInfo = stringRedisTemplate.execute((RedisCallback<Object>) (connection) -> connection.info("memory")).toString();

        // 메모리 정보를 파싱하여 Map으로 반환
        return Stream.of(memoryInfo.split(","))
                .map(entry -> entry.split("="))
                .filter(entry -> entry.length == 2)
                .collect(Collectors.toMap(entry -> entry[0].trim(), entry -> entry[1].trim()));
    }

    public void printMemoryUsage() {
        Map<String, String> memoryInfo = getMemoryInfo();

        String usedMemory = memoryInfo.get("used_memory_human");
        String maxMemory = memoryInfo.get("maxmemory_human");

        System.out.println("Redis Used Memory: " + usedMemory);
        System.out.println("Redis Max Memory: " + (maxMemory != null ? maxMemory : "Unlimited"));
    }

}
