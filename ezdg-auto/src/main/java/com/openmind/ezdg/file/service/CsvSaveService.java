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

        if (datas == null || datas.size() <= 1) {
            return documents; // 데이터가 없을 경우 빈 리스트 반환
        }

        Map<String, String> columnDataTypes = new HashMap<>(); // 각 열의 최종 데이터 타입 저장용
        String[] firstRow = datas.get(1); // 첫 번째 행 사용

        // 첫 번째 행의 데이터를 기준으로 초기 타입 설정
        for (int j = 0; j < translatedColumns.size(); j++) {
            String columnName = translatedColumns.get(j);
            String camelColumnName = customStringUtil.snakeCaseToCamelCase(columnName);
            String value = j < firstRow.length ? firstRow[j] : null;
            String dataType = typeConvertUtil.getDataTypeFromString(value);
            columnDataTypes.put(camelColumnName, dataType); // 초기 데이터 타입 설정
        }

        // 두 번째 행부터 타입 검증 시작
        for (int i = 2; i < datas.size(); i++) {
            String[] row = datas.get(i);

            for (int j = 0; j < row.length; j++) {
                String columnName = translatedColumns.get(j);
                String value = row[j];
                String currentDataType = typeConvertUtil.getDataTypeFromString(value);

                // 기존 타입과 다른 타입이 있으면 해당 열의 타입을 String으로 고정하고 더 이상 검사하지 않음
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

        // 결정된 데이터 타입을 사용하여 각 행을 Document로 변환
        for (int i = 1; i < datas.size(); i++) {
            String[] row = datas.get(i);
            Map<String, Object> documentMap = new HashMap<>();

            for (int j = 0; j < row.length; j++) {
                String columnName = translatedColumns.get(j);
                String camelColumnName = customStringUtil.snakeCaseToCamelCase(columnName);
                String value = row[j];
                String dataType = columnDataTypes.get(camelColumnName); // 최종 타입 가져오기


                // 결정된 타입으로 map에 put
                putDocumentByDataType(dataType, documentMap, camelColumnName, value);
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
                documentMap.put(columnName, TypeConvertUtil.parseToLocalDate(value));   // 03-09와 같은 형식이 아니라 3-9 이런 형식으로 넘어오면, 0채우고 LocalDate로 변환
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
                