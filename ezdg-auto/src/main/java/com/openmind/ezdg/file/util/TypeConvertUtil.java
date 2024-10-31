package com.openmind.ezdg.file.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class TypeConvertUtil {

    /**
     * String input을 파라미터로 받아, 데이터 타입을 변환시키는 메서드
     * 정수 -> Long
     * 실수 -> Double
     * 날짜 -> LocalDate
     *        "2024-03-09" / "2024/03/09" / "2024.03.09" / "24-03-09" / "24/03/09 / "24.03.09"
     *        월(M)이나 일(d)에서 0이 빠지면 채워서 LocalDate로 판별
     * 날짜+시간 -> LocalDateTime
     *            LocalDate로 판별 후 뒤에 숫자 있으면 LocalDateTime
     * @param input
     * @return String
     */
    public static String getDataTypeFromString(String input) {
        if (isInteger(input)) {
            return "Long";
        } else if (isFloatingPoint(input)) {
            return "Double";
        } else if (isLocalDate(input)) {
            return "LocalDate";
        } else if (isLocalDateTime(input)) {
            return "LocalDateTime";
        } else {
            return "String";
        }
    }

    /**
     * String input을 파라미터로 받아, 정수인지 판별하는 메서드
     * Long으로 변환 후, 실패하면(오버플로우) String으로 판별
     * 0으로 시작시, String으로 판별
     * @param input
     * @return boolean
     */
    private static boolean isInteger(String input) {
        String integerPattern = "^-?\\d+$"; // 정수 패턴(양수, 음수)
        if (Pattern.matches(integerPattern, input)) {
            if (input.length() > 1 && input.charAt(0) == '0') { // 숫자가 0으로 시작하고 길이가 2 이상이면 false 반환
                return false; // 예: "0123"은 유효하지 않음
            }
            try { // Long으로 변환 시도
                Long.parseLong(input);
                return true; // 변환이 성공하면 true 반환
            } catch (NumberFormatException e) { // Long 범위 넘어가면 String (오버플로우)
                return false;
            }
        }
        return false; // 정수 패턴과 일치하지 않으면 false 반환
    }


    /**
     * String input을 파라미터로 받아, 실수인지 판별하는 메서드
     * 소숫점이 포함된 패턴인지 확인
     * @param input
     * @return boolean
     */
    private static boolean isFloatingPoint(String input) {
        String floatPattern = "^-?\\d*\\.\\d+$";    // 실수 패턴(양수, 음수)
        return Pattern.matches(floatPattern, input);
    }

    /**
     * String input을 파라미터로 받아, LocalDate인지 판별하는 메서드
     * Java LocalDate에 Format 맞춤. 슬래시(/)나 온점(.)은 하이푼(-)으로 변환
     * 여러가지 날짜 형식 판별 가능
     * @param input
     * @return boolean
     */
    private static boolean isLocalDate(String input) {

        String normalizedInput = input.replace("/", "-").replace(".", "-");

        // 날짜 형식 패턴 정의
        String[] datePatterns = {
                "^\\d{4}-\\d{2}-\\d{2}$",   // yyyy-MM-dd
                "^\\d{2}-\\d{2}-\\d{2}$",   // yy-MM-dd
                "^\\d{2}-\\d{2}-\\d{4}$",   // MM-dd-yyyy
                "^\\d{4}-\\d{1}-\\d{1}$",   // yyyy-M-d
                "^\\d{2}-\\d{1}-\\d{1}$"    // yy-M-d
        };

        // 패턴을 검사합니다.
        for (String pattern : datePatterns) {
            if (Pattern.matches(pattern, normalizedInput)) {
                try {
                    // yyyy-M-d 형식의 경우 앞에 0을 채웁니다.
                    switch (pattern) {
                        case "^\\d{4}-\\d{1}-\\d{1}$" -> {
                            String[] parts = normalizedInput.split("-");
                            String year = parts[0];
                            String month = parts[1].length() == 1 ? "0" + parts[1] : parts[1];
                            String day = parts[2].length() == 1 ? "0" + parts[2] : parts[2];
                            String formattedDate = year + "-" + month + "-" + day;
                            LocalDate.parse(formattedDate); // LocalDate로 파싱 시도
                        }
                        // yy-M-d 형식의 경우
                        case "^\\d{2}-\\d{1}-\\d{1}$" -> {

                            String[] parts = normalizedInput.split("-");
                            String year = parts[0];
                            String month = parts[1].length() == 1 ? "0" + parts[1] : parts[1];
                            String day = parts[2].length() == 1 ? "0" + parts[2] : parts[2];
                            String formattedDate = year + "-" + month + "-" + day;
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
                            LocalDate.parse(formattedDate, formatter);
                        }
                        case "^\\d{2}-\\d{2}-\\d{2}$" -> {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
                            LocalDate.parse(normalizedInput, formatter);
                        }
                        default -> LocalDate.parse(normalizedInput);
                    }
                    return true; // 성공적으로 파싱
                } catch (DateTimeParseException e) {
                    return false; // 파싱 실패
                }
            }
        }
        return false; // 패턴에 맞지 않음
    }

    /**
     * String input을 파라미터로 받아, LocalDateTime인지 판별하는 메서드
     * Java LocalDateTime에 Format 맞춤. LocalDate 뒤에 숫자가 있을 경우, 공백을 T로 바꿈
     * @param input
     * @return boolean
     */
    private static boolean isLocalDateTime(String input) {
        DateTimeFormatter[] formatters = {
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"),
                DateTimeFormatter.ofPattern("yy-MM-dd'T'HH:mm:ss"),
                DateTimeFormatter.ofPattern("yy-MM-dd'T'HH:mm")
        };

        input = input.replace(" ", "T");    // DateTimeFormatter 형식에 맞추기
        for (DateTimeFormatter formatter : formatters) {
            try {
                LocalDateTime.parse(input, formatter);
                return true;
            } catch (DateTimeParseException ignored) {
            }
        }

        String[] parts = input.split("[T ]");
        return parts.length > 1 && isLocalDate(parts[0]);
    }

}
