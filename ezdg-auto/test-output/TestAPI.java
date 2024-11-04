package com.ssafy.ezdgTest;

import common.AbstractAPI;
import java.util.Date;
import java.util.List;

public class TestAPI extends AbstractAPI<Test> {

    public TestAPI() {
        super("/test");
    }

    public TestAPI region(String region) {
        uriBuilder.setParameter("region", String.valueOf(region));
        return this;
    }

    public TestAPI regionContaining(String region) {
        uriBuilder.setParameter("regionContaining", region);
        return this;
    }

    public TestAPI temperature(Double temperature) {
        uriBuilder.setParameter("temperature", String.valueOf(temperature));
        return this;
    }

    public TestAPI temperatureLt(Double temperatureLt) {
        uriBuilder.setParameter("temperatureLt", String.valueOf(temperatureLt));
        return this;
    }

    public TestAPI temperatureLte(Double temperatureLte) {
        uriBuilder.setParameter("temperatureLte", String.valueOf(temperatureLte));
        return this;
    }

    public TestAPI temperatureGt(Double temperatureGt) {
        uriBuilder.setParameter("temperatureGt", String.valueOf(temperatureGt));
        return this;
    }

    public TestAPI temperatureGte(Double temperatureGte) {
        uriBuilder.setParameter("temperatureGte", String.valueOf(temperatureGte));
        return this;
    }
}
