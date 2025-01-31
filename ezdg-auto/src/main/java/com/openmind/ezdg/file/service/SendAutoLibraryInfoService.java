package com.openmind.ezdg.file.service;

import com.openmind.ezdg.file.dto.filesave.FileInfoDto;
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

    public FileInfoDto setBasicInfo(String originalFileName, String translatedFileName, List<String> originalColumns, List<String> translatedColumns, List<String[]> datas) {
        List<FileInfoDto.Field> fields = new ArrayList<>();
        Map<String, String> columnDataTypes = new HashMap<>();

        if (datas != null && datas.size() > 1) {
            String[] firstRow = datas.get(1);

            for (int i = 0; i < translatedColumns.size(); i++) {
                String column = translatedColumns.get(i);
                String value = i < firstRow.length ? firstRow[i] : null;
                String dataType = typeConvertUtil.getDataTypeFromString(value);
                columnDataTypes.put(column, dataType);
            }

            // Verify consistency across rows and update column types if necessary
            for (int i = 2; i < datas.size(); i++) {
                String[] row = datas.get(i);
                for (int j = 0; j < translatedColumns.size(); j++) {
                    String column = translatedColumns.get(j);
                    String value = j < row.length ? row[j] : null;
                    String currentDataType = typeConvertUtil.getDataTypeFromString(value);

                    // Update column type to String if any discrepancy is found
                    if (!currentDataType.equals(columnDataTypes.get(column))) {
                        columnDataTypes.put(column, "String");
                        break;
                    }
                }
            }

            for (int i = 0; i < translatedColumns.size(); i++) {
                String type = columnDataTypes.getOrDefault(translatedColumns.get(i), "String");
                String translatedName = customStringUtil.snakeCaseToCamelCase(translatedColumns.get(i));
                String originalName = originalColumns.get(i);
                fields.add(FileInfoDto.Field.builder()
                        .type(type)
                        .originalName(originalName)
                        .translatedName(translatedName)
                        .build());
            }

        }

        return FileInfoDto.builder()
                .originalFileName(originalFileName)
                .translatedFileName(translatedFileName)
                .fields(fields)
                .build();
    }


}
