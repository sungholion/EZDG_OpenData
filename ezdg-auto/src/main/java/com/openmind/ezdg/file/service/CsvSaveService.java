package com.openmind.ezdg.file.service;

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
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.BsonDocument;
import org.bson.BsonType;
import org.bson.BsonValue;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

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

    /**
     * mongoDB에 insert
     * FIXME 많은 데이터가 들어가면 시간이 오래 걸려서 최적화 필요(멀티스레드 or mongoTemplate에서 제공하는 메서드 등)
     */
    @Transactional
    public void saveFile(List<String[]> datas, String translatedFileName, List<String> translatedColumns) {
        // insert mongoDB
        csvSaveRepository.createCollection(translatedFileName);
        MongoCollection<Document> collection = csvSaveRepository.getCollection(translatedFileName);

        // document 생성
        List<Document> documents = getDocuments(datas, translatedColumns);

        // 삽입
        csvSaveRepository.insertDocuments(collection, documents);
    }

    private List<Document> getDocuments(List<String[]> datas, List<String> translatedColumns) {
        List<Document> documents = new ArrayList<>();

        for (int i = 1; i < datas.size(); i++) {
            String[] row = datas.get(i);
            Map<String, Object> documentMap = new HashMap<>();

            for(int j = 0; j < row.length; j++) {
                String columnName = translatedColumns.get(j);
                String value = row[j];
                String dataType = typeConvertUtil.getDataTypeFromString(value);

                // 결정된 타입으로 map에 put
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
                // yyyy-M-d 또는 yy-M-d 형식의 경우 M과 d 앞에 0을 추가
                if (value.matches("^\\d{4}-\\d{1}-\\d{1}$") || value.matches("^\\d{2}-\\d{1}-\\d{1}$")) {
                    String[] parts = value.split("-");
                    String year = parts[0];
                    String month = parts[1].length() == 1 ? "0" + parts[1] : parts[1];
                    String day = parts[2].length() == 1 ? "0" + parts[2] : parts[2];
                    String formattedDate = year + "-" + month + "-" + day;
                    documentMap.put(columnName, LocalDate.parse(formattedDate)); // 포맷된 날짜로 LocalDate 변환
                } else {
                    documentMap.put(columnName, LocalDate.parse(value)); // 기존 형식 유지
                }
                break;
            case "LocalDateTime":
                // yyyy-M-d 또는 yy-M-d 형식의 경우 M과 d 앞에 0을 추가
                if (value.matches("^\\d{4}-\\d{1}-\\d{1}.*") || value.matches("^\\d{2}-\\d{1}-\\d{1}.*")) {
                    String[] parts = value.split("[-T ]");
                    String year = parts[0];
                    String month = parts[1].length() == 1 ? "0" + parts[1] : parts[1];
                    String day = parts[2].length() == 1 ? "0" + parts[2] : parts[2];
                    String timePart = value.contains("T") ? value.split("T")[1] : value.split(" ")[1];
                    String formattedDateTime = year + "-" + month + "-" + day + "T" + timePart;
                    documentMap.put(columnName, LocalDateTime.parse(formattedDateTime)); // 포맷된 날짜로 LocalDateTime 변환
                } else {
                    documentMap.put(columnName, LocalDateTime.parse(value)); // 기존 형식 유지
                }
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
     * 데이터가 잘 들어갔는지 확인하기 위해 db에서 조회한 뒤 결과 리턴
     */
    public List<List<MongoBsonValueDto>> getSavedData(String collectionName) {
        List<List<MongoBsonValueDto>> result = new ArrayList<>();

        MongoCollection<Document> collection = csvSaveRepository.getCollection(collectionName);

        try (MongoCursor<Document> cursor = collection.find().limit(5).iterator()) {
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

}
