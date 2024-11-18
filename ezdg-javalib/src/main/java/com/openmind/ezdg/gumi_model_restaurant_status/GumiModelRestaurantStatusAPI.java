package com.openmind.ezdg.gumi_model_restaurant_status;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;

public class GumiModelRestaurantStatusAPI extends AbstractAPI<GumiModelRestaurantStatus> {

    public GumiModelRestaurantStatusAPI() {
        super("/gumi_model_restaurant_status");
    }

    public GumiModelRestaurantStatusAPI page(int page) {
        return (GumiModelRestaurantStatusAPI) super.page(page);
    }

    public GumiModelRestaurantStatusAPI perPage(int perPage) {
        return (GumiModelRestaurantStatusAPI) super.perPage(perPage);
    }

    public GumiModelRestaurantStatusAPI number(Long number) {
        uriBuilder.setParameter("number", String.valueOf(number));
        return this;
    }

    public GumiModelRestaurantStatusAPI numberLt(Long numberLt) {
        uriBuilder.setParameter("numberLt", String.valueOf(numberLt));
        return this;
    }

    public GumiModelRestaurantStatusAPI numberLte(Long numberLte) {
        uriBuilder.setParameter("numberLte", String.valueOf(numberLte));
        return this;
    }

    public GumiModelRestaurantStatusAPI numberGt(Long numberGt) {
        uriBuilder.setParameter("numberGt", String.valueOf(numberGt));
        return this;
    }

    public GumiModelRestaurantStatusAPI numberGte(Long numberGte) {
        uriBuilder.setParameter("numberGte", String.valueOf(numberGte));
        return this;
    }
    public GumiModelRestaurantStatusAPI category(String category) {
        uriBuilder.setParameter("category", String.valueOf(category));
        return this;
    }

    public GumiModelRestaurantStatusAPI categoryContaining(String category) {
        uriBuilder.setParameter("categoryContaining", category);
        return this;
    }

    public GumiModelRestaurantStatusAPI businessName(String businessName) {
        uriBuilder.setParameter("businessName", String.valueOf(businessName));
        return this;
    }

    public GumiModelRestaurantStatusAPI businessNameContaining(String businessName) {
        uriBuilder.setParameter("businessNameContaining", businessName);
        return this;
    }

    public GumiModelRestaurantStatusAPI locationRoadNameAddress(String locationRoadNameAddress) {
        uriBuilder.setParameter("locationRoadNameAddress", String.valueOf(locationRoadNameAddress));
        return this;
    }

    public GumiModelRestaurantStatusAPI locationRoadNameAddressContaining(String locationRoadNameAddress) {
        uriBuilder.setParameter("locationRoadNameAddressContaining", locationRoadNameAddress);
        return this;
    }

    public GumiModelRestaurantStatusAPI phoneNumber(String phoneNumber) {
        uriBuilder.setParameter("phoneNumber", String.valueOf(phoneNumber));
        return this;
    }

    public GumiModelRestaurantStatusAPI phoneNumberContaining(String phoneNumber) {
        uriBuilder.setParameter("phoneNumberContaining", phoneNumber);
        return this;
    }

    public GumiModelRestaurantStatusAPI representativeMenu(String representativeMenu) {
        uriBuilder.setParameter("representativeMenu", String.valueOf(representativeMenu));
        return this;
    }

    public GumiModelRestaurantStatusAPI representativeMenuContaining(String representativeMenu) {
        uriBuilder.setParameter("representativeMenuContaining", representativeMenu);
        return this;
    }

}