package com.openmind.ezdg.daegu_restaurant;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;

public class DaeguRestaurantAPI extends AbstractAPI<DaeguRestaurant> {

    public DaeguRestaurantAPI() {
        super("/daegu_restaurant");
    }

    public DaeguRestaurantAPI page(int page) {
        return (DaeguRestaurantAPI) super.page(page);
    }

    public DaeguRestaurantAPI perPage(int perPage) {
        return (DaeguRestaurantAPI) super.perPage(perPage);
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

    public DaeguRestaurantAPI businessStatus(String businessStatus) {
        uriBuilder.setParameter("businessStatus", String.valueOf(businessStatus));
        return this;
    }

    public DaeguRestaurantAPI businessStatusContaining(String businessStatus) {
        uriBuilder.setParameter("businessStatusContaining", businessStatus);
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