package com.openmind.ezdg.busan_manufacturing_factory_registration_status;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;

public class BusanManufacturingFactoryRegistrationStatusAPI extends AbstractAPI<BusanManufacturingFactoryRegistrationStatus> {

    public BusanManufacturingFactoryRegistrationStatusAPI() {
        super("/busan_manufacturing_factory_registration_status");
    }

    public BusanManufacturingFactoryRegistrationStatusAPI page(int page) {
        return (BusanManufacturingFactoryRegistrationStatusAPI) super.page(page);
    }

    public BusanManufacturingFactoryRegistrationStatusAPI perPage(int perPage) {
        return (BusanManufacturingFactoryRegistrationStatusAPI) super.perPage(perPage);
    }

    public BusanManufacturingFactoryRegistrationStatusAPI order(Long order) {
        uriBuilder.setParameter("order", String.valueOf(order));
        return this;
    }

    public BusanManufacturingFactoryRegistrationStatusAPI orderLt(Long orderLt) {
        uriBuilder.setParameter("orderLt", String.valueOf(orderLt));
        return this;
    }

    public BusanManufacturingFactoryRegistrationStatusAPI orderLte(Long orderLte) {
        uriBuilder.setParameter("orderLte", String.valueOf(orderLte));
        return this;
    }

    public BusanManufacturingFactoryRegistrationStatusAPI orderGt(Long orderGt) {
        uriBuilder.setParameter("orderGt", String.valueOf(orderGt));
        return this;
    }

    public BusanManufacturingFactoryRegistrationStatusAPI orderGte(Long orderGte) {
        uriBuilder.setParameter("orderGte", String.valueOf(orderGte));
        return this;
    }
    public BusanManufacturingFactoryRegistrationStatusAPI companyName(String companyName) {
        uriBuilder.setParameter("companyName", String.valueOf(companyName));
        return this;
    }

    public BusanManufacturingFactoryRegistrationStatusAPI companyNameContaining(String companyName) {
        uriBuilder.setParameter("companyNameContaining", companyName);
        return this;
    }

    public BusanManufacturingFactoryRegistrationStatusAPI factoryRepresentativeAddress(String factoryRepresentativeAddress) {
        uriBuilder.setParameter("factoryRepresentativeAddress", String.valueOf(factoryRepresentativeAddress));
        return this;
    }

    public BusanManufacturingFactoryRegistrationStatusAPI factoryRepresentativeAddressContaining(String factoryRepresentativeAddress) {
        uriBuilder.setParameter("factoryRepresentativeAddressContaining", factoryRepresentativeAddress);
        return this;
    }

    public BusanManufacturingFactoryRegistrationStatusAPI businessName(String businessName) {
        uriBuilder.setParameter("businessName", String.valueOf(businessName));
        return this;
    }

    public BusanManufacturingFactoryRegistrationStatusAPI businessNameContaining(String businessName) {
        uriBuilder.setParameter("businessNameContaining", businessName);
        return this;
    }

    public BusanManufacturingFactoryRegistrationStatusAPI phoneNumber(String phoneNumber) {
        uriBuilder.setParameter("phoneNumber", String.valueOf(phoneNumber));
        return this;
    }

    public BusanManufacturingFactoryRegistrationStatusAPI phoneNumberContaining(String phoneNumber) {
        uriBuilder.setParameter("phoneNumberContaining", phoneNumber);
        return this;
    }

}