package com.openmind.ezdg.file.util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CsvUtil {

    private final DefaultResourceLoader resourceLoader;

    /**
     * csv 파일을 읽어 한 줄씩 String[]에 담아 List<String[]>으로 반환
     * @param filePath
     * @return List<String[]>
     */
    public List<String[]> readCsvFile(String filePath) {
        if(!filePath.endsWith("csv")) {
            throw new RuntimeException("must can read only csv file");
        }
        List<String[]> csvData = new ArrayList<>();

        try(CSVReader csvReader = new CSVReader(new FileReader(filePath, StandardCharsets.UTF_8))) {
            String[] line;
            while((line = csvReader.readNext()) != null) {
                csvData.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return csvData;
    }
}
