package com.openmind.ezdg.script;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ScriptService {

    @Value("${url.release-webhook}")
    private String releaseWebhookUrl;

    public boolean releaseHook() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.postForObject(releaseWebhookUrl, null, String.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
