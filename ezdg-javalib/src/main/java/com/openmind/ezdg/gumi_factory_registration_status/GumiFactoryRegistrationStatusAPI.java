package com.openmind.ezdg.gumi_factory_registration_status;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;

public class GumiFactoryRegistrationStatusAPI extends AbstractAPI<GumiFactoryRegistrationStatus> {

    public GumiFactoryRegistrationStatusAPI() {
        super("/gumi_factory_registration_status");
    }

    public GumiFactoryRegistrationStatusAPI page(int page) {
        return (GumiFactoryRegistrationStatusAPI) super.page(page);
    }

    public GumiFactoryRegistrationStatusAPI perPage(int perPage) {
        return (GumiFactoryRegistrationStatusAPI) super.perPage(perPage);
    }

    public GumiFactoryRegistrationStatusAPI classification(String classification) {
        uriBuilder.setParameter("classification", String.valueOf(classification));
        return this;
    }

    public GumiFactoryRegistrationStatusAPI classificationContaining(String classification) {
        uriBuilder.setParameter("classificationContaining", classification);
        return this;
    }

    public GumiFactoryRegistrationStatusAPI companyName(String companyName) {
        uriBuilder.setParameter("companyName", String.valueOf(companyName));
        return this;
    }

    public GumiFactoryRegistrationStatusAPI companyNameContaining(String companyName) {
        uriBuilder.setParameter("companyNameContaining", companyName);
        return this;
    }

    public GumiFactoryRegistrationStatusAPI phoneNumber(String phoneNumber) {
        uriBuilder.setParameter("phoneNumber", String.valueOf(phoneNumber));
        return this;
    }

    public GumiFactoryRegistrationStatusAPI phoneNumberContaining(String phoneNumber) {
        uriBuilder.setParameter("phoneNumberContaining", phoneNumber);
        return this;
    }

    public GumiFactoryRegistrationStatusAPI factoryRepresentativeAddress(String factoryRepresentativeAddress) {
        uriBuilder.setParameter("factoryRepresentativeAddress", String.valueOf(factoryRepresentativeAddress));
        return this;
    }

    public GumiFactoryRegistrationStatusAPI factoryRepresentativeAddressContaining(String factoryRepresentativeAddress) {
        uriBuilder.setParameter("factoryRepresentativeAddressContaining", factoryRepresentativeAddress);
        return this;
    }

    public GumiFactoryRegistrationStatusAPI businessName(String businessName) {
        uriBuilder.setParameter("businessName", String.valueOf(businessName));
        return this;
    }

    public GumiFactoryRegistrationStatusAPI businessNameContaining(String businessName) {
        uriBuilder.setParameter("businessNameContaining", businessName);
        return this;
    }

    public GumiFactoryRegistrationStatusAPI numberOfEmployees(Long numberOfEmployees) {
        uriBuilder.setParameter("numberOfEmployees", String.valueOf(numberOfEmployees));
        return this;
    }

    public GumiFactoryRegistrationStatusAPI numberOfEmployeesLt(Long numberOfEmployeesLt) {
        uriBuilder.setParameter("numberOfEmployeesLt", String.valueOf(numberOfEmployeesLt));
        return this;
    }

    public GumiFactoryRegistrationStatusAPI numberOfEmployeesLte(Long numberOfEmployeesLte) {
        uriBuilder.setParameter("numberOfEmployeesLte", String.valueOf(numberOfEmployeesLte));
        return this;
    }

    public GumiFactoryRegistrationStatusAPI numberOfEmployeesGt(Long numberOfEmployeesGt) {
        uriBuilder.setParameter("numberOfEmployeesGt", String.valueOf(numberOfEmployeesGt));
        return this;
    }

    public GumiFactoryRegistrationStatusAPI numberOfEmployeesGte(Long numberOfEmployeesGte) {
        uriBuilder.setParameter("numberOfEmployeesGte", String.valueOf(numberOfEmployeesGte));
        return this;
    }
    public GumiFactoryRegistrationStatusAPI managementAgencyName(String managementAgencyName) {
        uriBuilder.setParameter("managementAgencyName", String.valueOf(managementAgencyName));
        return this;
    }

    public GumiFactoryRegistrationStatusAPI managementAgencyNameContaining(String managementAgencyName) {
        uriBuilder.setParameter("managementAgencyNameContaining", managementAgencyName);
        return this;
    }

    public GumiFactoryRegistrationStatusAPI managementAgencyPhoneNumber(String managementAgencyPhoneNumber) {
        uriBuilder.setParameter("managementAgencyPhoneNumber", String.valueOf(managementAgencyPhoneNumber));
        return this;
    }

    public GumiFactoryRegistrationStatusAPI managementAgencyPhoneNumberContaining(String managementAgencyPhoneNumber) {
        uriBuilder.setParameter("managementAgencyPhoneNumberContaining", managementAgencyPhoneNumber);
        return this;
    }

}