package com.openmind.ezdg.file.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ObjectMapperUtil { // view <-> controller 간 List<String[]> 전달

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * data를 json String으로 변환
     * @param data
     * @return json String으로 변환된 data 반환
     */
    public String dataToString(Object data) {
        try {
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * json string을 List<String[]>으로 변경
     * @param dataToJson
     * @return List<String[]>
     */
    public List<String[]> stringToData(String dataToJson) {
        try {
            return objectMapper.readValue(dataToJson, new TypeReference<>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
