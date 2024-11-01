package com.openmind.ezdg.file.service;

import com.openmind.ezdg.file.dto.filesave.AutoLibraryInfoDto;
import com.openmind.ezdg.file.util.CustomStringUtil;
import com.openmind.ezdg.file.util.TypeConvertUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SendAutoLibraryInfoService {

    private final TypeConvertUtil typeConvertUtil;
    private final CustomStringUtil customStringUtil;

    public AutoLibraryInfoDto makeAutoLibraryInfo(String translatedFileName, List<String> translatedColumns, List<String[]> datas) {
        AutoLibraryInfoDto autoLibraryInfoDto = new AutoLibraryInfoDto();

        String convertClassName = customStringUtil.snakeCaseToCamelCase(translatedFileName);
        autoLibraryInfoDto.setClassInfo(convertClassName);

        List<AutoLibraryInfoDto.ColumnInfo> columnInfoList = new ArrayList<>();

        // 첫 번째 행을 이용해 각 column의 데이터 타입 결정
        if (datas != null && datas.size() > 1) { // 첫 행을 데이터로 활용하지 않고 두 번째 행부터 사용
            String[] firstRow = datas.get(1);

            for (int i = 0; i < translatedColumns.size(); i++) {
                String column = translatedColumns.get(i);
                String value = i < firstRow.length ? firstRow[i] : null;

                // 데이터 타입 결정
                String dataType = typeConvertUtil.getDataTypeFromString(value);
                System.out.println(column + " 데이터 변환 : " + dataType);

                String convertColumnName = customStringUtil.snakeCaseToCamelCase(column);
                AutoLibraryInfoDto.ColumnInfo columnInfo = new AutoLibraryInfoDto.ColumnInfo(dataType, convertColumnName);
                columnInfoList.add(columnInfo);
            }
        }

        // columnInfo 리스트를 AutoLibraryInfoDto에 설정
        autoLibraryInfoDto.setColumnInfo(columnInfoList);

        return autoLibraryInfoDto;
    }



}
