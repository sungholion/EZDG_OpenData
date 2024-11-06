package com.openmind.ezdg.file.service;

import com.openmind.ezdg.file.dto.filesave.AutoLibraryInfoDto;
import com.openmind.ezdg.file.util.CustomStringUtil;
import com.openmind.ezdg.file.util.TypeConvertUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class SendAutoLibraryInfoService {

    private final TypeConvertUtil typeConvertUtil;
    private final CustomStringUtil customStringUtil;

    public AutoLibraryInfoDto makeAutoLibraryInfo(String translatedFileName, String originFileName, List<String> translatedColumns, List<String[]> datas) {

        List<AutoLibraryInfoDto.ColumnInfo> columnInfoList = new ArrayList<>(); // Column 저장
        Map<String, String> columnDataTypes = new HashMap<>(); // 초기 데이터 타입 저장용

        // 첫 번째 행을 기준으로 각 컬럼의 초기 데이터 타입 설정
        if (datas != null && datas.size() > 1) { // 데이터가 있을 경우
            String[] firstRow = datas.get(1);
            for (int i = 0; i < translatedColumns.size(); i++) {
                String column = translatedColumns.get(i);
                String value = i < firstRow.length ? firstRow[i] : null;
                String dataType = typeConvertUtil.getDataTypeFromString(value);
                columnDataTypes.put(column, dataType);
            }

            // 이후 행들을 순회하며 각 열의 데이터 타입 검사
            for (int i = 2; i < datas.size(); i++) { // 두 번째 행부터 시작
                String[] row = datas.get(i);
                for (int j = 0; j < translatedColumns.size(); j++) {
                    String column = translatedColumns.get(j);
                    String value = j < row.length ? row[j] : null;
                    String currentDataType = typeConvertUtil.getDataTypeFromString(value);

                    // 만약 초기 타입과 다른 타입이 발견되면 해당 컬럼 타입을 String 으로 변경
                    if (!currentDataType.equals(columnDataTypes.get(column))) {
                        log.info("Expected Type : " + columnDataTypes.get(column));
                        columnDataTypes.put(column, "String");
                        log.info("Current Type : " + columnDataTypes.get(column));
                        log.info("Because : " + column);
                        break;
                    }
                }
            }

            // 결정된 타입을 기반으로 ColumnInfo 객체 생성
            for (String column : translatedColumns) {
                String convertColumnName = customStringUtil.snakeCaseToCamelCase(column);
                String finalDataType = columnDataTypes.getOrDefault(column, "String");
                AutoLibraryInfoDto.ColumnInfo columnInfo = new AutoLibraryInfoDto.ColumnInfo(finalDataType, convertColumnName);
                columnInfoList.add(columnInfo);
            }
        }

        return new AutoLibraryInfoDto(translatedFileName, originFileName, columnInfoList);
    }

}
