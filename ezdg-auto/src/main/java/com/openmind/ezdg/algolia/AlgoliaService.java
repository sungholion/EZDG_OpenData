package com.openmind.ezdg.algolia;

import com.algolia.api.SearchClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlgoliaService {

    @Value("${external.api.algolia.id}")
    private String applicationId;
    @Value("${external.api.algolia.key}")
    private String applicationKey;

    SearchClient client = new SearchClient(applicationId, applicationKey);

    public void addEzdgGuideSearchObject(AlgoliaSearchFileDto param) {
        log.info("Reuqest add Algolia Object for file {}", param.toString());
        String uniqueId = generateUniqueId();

        Map<String, Object> data = new HashMap<>();
        data.put("originalName", param.getOriginalName());
        data.put("translatedName", param.getTranslatedName());
        data.put("route", param.getRoute());

        client.addOrUpdateObject(
                "ezdg",
                uniqueId,
                data
        );
    }

    public void addEzdgGuideSearchObject(AlgoliaSearchApiDto param) {
        log.info("Reuqest add Algolia Object for api {}", param.toString());
        String uniqueId = generateUniqueId();

        Map<String, Object> data = new HashMap<>();
        data.put("originalName", param.getOriginalName());
        data.put("translatedName", param.getTranslatedName());
        data.put("details", param.getDetails());

        client.addOrUpdateObject(
                "ezdg",
                uniqueId,
                data
        );
    }

    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }
}
