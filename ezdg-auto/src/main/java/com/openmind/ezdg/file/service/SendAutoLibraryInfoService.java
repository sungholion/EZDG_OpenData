package com.openmind.ezdg.file.service;

import com.openmind.ezdg.file.dto.filesave.AutoLibraryInfoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendAutoLibraryInfoService {

    private static void sendAutoLibraryInfo(String translatedFileName, List<String> translatedColumns) {
        AutoLibraryInfoDto autoLibraryInfoDto = new AutoLibraryInfoDto(translatedFileName, translatedColumns);
    }

}
