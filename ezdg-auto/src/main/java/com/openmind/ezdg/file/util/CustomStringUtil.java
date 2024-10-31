package com.openmind.ezdg.file.util;

import org.bson.BsonValue;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.StringTokenizer;

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
    public String deleteExtract(String str) {
        int extractInd = str.indexOf(".");
        return str.substring(0, extractInd);
    }

    /**
     * 마지막 언더스코어 제거
     * @param str
     * @return 마지막 언더스코어가 제거된 문자열
     */
    public String deleteLastUnderScore(String str) {
        if(str.endsWith("_")) {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }

    /**
     * snakeCase가 맞는지 검증하고, 맞다면 camel case로 변환
     * @param snakeCaseStr
     * @return 카멜케이스로 변환된 string 반환
     */
    public String snakeCaseToCamelCase(String snakeCaseStr) {
        if(!isSnakeCase(snakeCaseStr)) {
            throw new RuntimeException("input string is not snake case -> " + snakeCaseStr);
        }
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(snakeCaseStr, "_");

        sb.append(st.nextToken());

        while(st.hasMoreTokens()) {
            String word = st.nextToken();
            sb.append(word.substring(0, 1).toUpperCase());
            sb.append(word.substring(1).toLowerCase());
        }

        return sb.toString();
    }

    /**
     * snakeCase가 맞는지 검증
     * @param snakeCaseStr
     * @return snakeCase가 맞다면 true, 아니라면 false 반환
     */
    public boolean isSnakeCase(String snakeCaseStr) {
        return snakeCaseStr.matches("^[a-z]+(_[a-z]+)*$");
    }


}
