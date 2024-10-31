package com.openmind.ezdg.file.util;

import org.bson.BsonValue;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CustomStringUtil {

    /**
     * 파일 이름 정규화
     * @param originalFileName
     * @return 정규화된 파일 이름
     */
    public String normalizeFileName(String originalFileName) {
        originalFileName = normalizeString(originalFileName);
        originalFileName = deleteExtract(originalFileName);
        originalFileName = deleteLastUnderScore(originalFileName);

        return originalFileName;
    }

    /**
     * 칼럼 이름 정규화
     * @param columnNames
     * @return 정규화된 칼럼 이름
     */
    public String[] normalizeColumnNames(String[] columnNames) {
        for (int i = 0; i < columnNames.length; i++) {
            columnNames[i] = normalizeString(columnNames[i]);
            columnNames[i] = deleteLastUnderScore(columnNames[i]);
        }
        return columnNames;
    }

    /**
     * value를 감싸고 있는 BsonValue에서 value만 추출
     * @param value
     * @return 추출된 value
     */
    public String bsonValueToStr(BsonValue value) {
        String valueStr = value.toString();
        int equalInd = valueStr.indexOf("=");

        return valueStr.substring(equalInd + 1, valueStr.length() - 1);
    }

    /**
     * 공통 정규화
     * @param str
     * @return 정규화된 문자열
     */
    public String normalizeString(String str) {
        // 양쪽 공백 제거
        String result = str.trim();

        // 괄호 및 값 제거
        result = result.replaceAll("\\(.*?\\)", "");

        // - 제거
        result = result.replaceAll("-", "");

        // , 제거
        result = result.replaceAll(",", "");

        // 숫자 제거
        result = result.replaceAll("\\d", "");

        // 소문자로 변환
        result = result.toLowerCase();

        // 공백, 특수문자 언더스코어 변환
        result = result.replaceAll("[\\s_]+", "_");

        // and 제거
        result = result.replaceAll("and", "");

        // 연속 언더스코어 변환
        result = result.replaceAll("_+", "_");

        return result;
    }

    /**
     * 파일의 확장자 제거
     * @param str
     * @return 확장자가 제거된 파일 이름
     */
    private String deleteExtract(String str) {
        int extractInd = str.indexOf(".");
        return str.substring(0, extractInd);
    }

    /**
     * 마지막 언더스코어 제거
     * @param str
     * @return 마지막 언더스코어가 제거된 문자열
     */
    private String deleteLastUnderScore(String str) {
        if(str.endsWith("_")) {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }
}
