package com.openmind.ezdg.daegu_restaurant;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DaeguRestaurantAPI extends AbstractAPI<DaeguRestaurant> {

    public DaeguRestaurantAPI() {
        super("/daegu_restaurant");
    }

    public DaeguRestaurantAPI number(String number) {
        uriBuilder.setParameter("number", String.valueOf(number));
        return this;
    }

    public DaeguRestaurantAPI numberContaining(String number) {
        uriBuilder.setParameter("numberContaining", number);
        return this;
    }

    public DaeguRestaurantAPI businessName(String businessName) {
        uriBuilder.setParameter("businessName", String.valueOf(businessName));
        return this;
    }

    public DaeguRestaurantAPI businessNameContaining(String businessName) {
        uriBuilder.setParameter("businessNameContaining", businessName);
        return this;
    }

    public DaeguRestaurantAPI businessType(String businessType) {
        uriBuilder.setParameter("businessType", String.valueOf(businessType));
        return this;
    }

    public DaeguRestaurantAPI businessTypeContaining(String businessType) {
        uriBuilder.setParameter("businessTypeContaining", businessType);
        return this;
    }

    public DaeguRestaurantAPI businessAddress(String businessAddress) {
        uriBuilder.setParameter("businessAddress", String.valueOf(businessAddress));
        return this;
    }

    public DaeguRestaurantAPI businessAddressContaining(String businessAddress) {
        uriBuilder.setParameter("businessAddressContaining", businessAddress);
        return this;
    }

}