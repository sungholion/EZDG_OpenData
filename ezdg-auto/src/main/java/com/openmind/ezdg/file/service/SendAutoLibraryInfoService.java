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

    public AutoLibraryInfoDto makeAutoLibraryInfo(String translatedFileName, List<String> translatedColumns) {
        AutoLibraryInfoDto autoLibraryInfoDto = new AutoLibraryInfoDto();

        String convertClassName = customStringUtil.snakeCaseToCamelCase(translatedFileName);

        autoLibraryInfoDto.setClassInfo(convertClassName);

        List<AutoLibraryInfoDto.ColumnInfo> columnInfoList = new ArrayList<>();

        // translatedColumns를 순회하며 데이터 타입을 알아내고 ColumnInfo를 생성
        for (String column : translatedColumns) {
            String dataType = typeConvertUtil.getDataTypeFromString(column); // 데이터 타입 확인
            String convertColumnName = customStringUtil.snakeCaseToCamelCase(column);
            AutoLibraryInfoDto.ColumnInfo columnInfo = new AutoLibraryInfoDto.ColumnInfo(dataType, convertColumnName); // ColumnInfo 객체 생성
            columnInfoList.add(columnInfo); // 리스트에 추가
        }

        // columnInfo 리스트를 AutoLibraryInfoDto에 설정
        autoLibraryInfoDto.setColumnInfo(columnInfoList);

        return autoLibraryInfoDto;
    }

    public void sendAutoLibraryInfo(AutoLibraryInfoDto autoLibraryInfo) {

    }

}
