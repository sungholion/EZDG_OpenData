package com.openmind.ezdg.daegu_manufacturer_status;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;

public class DaeguManufacturerStatusAPI extends AbstractAPI<DaeguManufacturerStatus> {

    public DaeguManufacturerStatusAPI() {
        super("/daegu_manufacturer_status");
    }

    public DaeguManufacturerStatusAPI page(int page) {
        return (DaeguManufacturerStatusAPI) super.page(page);
    }

    public DaeguManufacturerStatusAPI perPage(int perPage) {
        return (DaeguManufacturerStatusAPI) super.perPage(perPage);
    }

    public DaeguManufacturerStatusAPI orderNumber(Long orderNumber) {
        uriBuilder.setParameter("orderNumber", String.valueOf(orderNumber));
        return this;
    }

    public DaeguManufacturerStatusAPI orderNumberLt(Long orderNumberLt) {
        uriBuilder.setParameter("orderNumberLt", String.valueOf(orderNumberLt));
        return this;
    }

    public DaeguManufacturerStatusAPI orderNumberLte(Long orderNumberLte) {
        uriBuilder.setParameter("orderNumberLte", String.valueOf(orderNumberLte));
        return this;
    }

    public DaeguManufacturerStatusAPI orderNumberGt(Long orderNumberGt) {
        uriBuilder.setParameter("orderNumberGt", String.valueOf(orderNumberGt));
        return this;
    }

    public DaeguManufacturerStatusAPI orderNumberGte(Long orderNumberGte) {
        uriBuilder.setParameter("orderNumberGte", String.valueOf(orderNumberGte));
        return this;
    }
    public DaeguManufacturerStatusAPI complexName(String complexName) {
        uriBuilder.setParameter("complexName", String.valueOf(complexName));
        return this;
    }

    public DaeguManufacturerStatusAPI complexNameContaining(String complexName) {
        uriBuilder.setParameter("complexNameContaining", complexName);
        return this;
    }

    public DaeguManufacturerStatusAPI companyName(String companyName) {
        uriBuilder.setParameter("companyName", String.valueOf(companyName));
        return this;
    }

    public DaeguManufacturerStatusAPI companyNameContaining(String companyName) {
        uriBuilder.setParameter("companyNameContaining", companyName);
        return this;
    }

    public DaeguManufacturerStatusAPI factoryRepresentativeDoroAddress(String factoryRepresentativeDoroAddress) {
        uriBuilder.setParameter("factoryRepresentativeDoroAddress", String.valueOf(factoryRepresentativeDoroAddress));
        return this;
    }

    public DaeguManufacturerStatusAPI factoryRepresentativeDoroAddressContaining(String factoryRepresentativeDoroAddress) {
        uriBuilder.setParameter("factoryRepresentativeDoroAddressContaining", factoryRepresentativeDoroAddress);
        return this;
    }

    public DaeguManufacturerStatusAPI factoryRepresentativeJibunAddress(String factoryRepresentativeJibunAddress) {
        uriBuilder.setParameter("factoryRepresentativeJibunAddress", String.valueOf(factoryRepresentativeJibunAddress));
        return this;
    }

    public DaeguManufacturerStatusAPI factoryRepresentativeJibunAddressContaining(String factoryRepresentativeJibunAddress) {
        uriBuilder.setParameter("factoryRepresentativeJibunAddressContaining", factoryRepresentativeJibunAddress);
        return this;
    }

    public DaeguManufacturerStatusAPI representativeBusinessNumber(String representativeBusinessNumber) {
        uriBuilder.setParameter("representativeBusinessNumber", String.valueOf(representativeBusinessNumber));
        return this;
    }

    public DaeguManufacturerStatusAPI representativeBusinessNumberContaining(String representativeBusinessNumber) {
        uriBuilder.setParameter("representativeBusinessNumberContaining", representativeBusinessNumber);
        return this;
    }

    public DaeguManufacturerStatusAPI businessNumber(String businessNumber) {
        uriBuilder.setParameter("businessNumber", String.valueOf(businessNumber));
        return this;
    }

    public DaeguManufacturerStatusAPI businessNumberContaining(String businessNumber) {
        uriBuilder.setParameter("businessNumberContaining", businessNumber);
        return this;
    }

    public DaeguManufacturerStatusAPI businessName(String businessName) {
        uriBuilder.setParameter("businessName", String.valueOf(businessName));
        return this;
    }

    public DaeguManufacturerStatusAPI businessNameContaining(String businessName) {
        uriBuilder.setParameter("businessNameContaining", businessName);
        return this;
    }

    public DaeguManufacturerStatusAPI establishmentClassification(String establishmentClassification) {
        uriBuilder.setParameter("establishmentClassification", String.valueOf(establishmentClassification));
        return this;
    }

    public DaeguManufacturerStatusAPI establishmentClassificationContaining(String establishmentClassification) {
        uriBuilder.setParameter("establishmentClassificationContaining", establishmentClassification);
        return this;
    }

    public DaeguManufacturerStatusAPI product(String product) {
        uriBuilder.setParameter("product", String.valueOf(product));
        return this;
    }

    public DaeguManufacturerStatusAPI productContaining(String product) {
        uriBuilder.setParameter("productContaining", product);
        return this;
    }

    public DaeguManufacturerStatusAPI mainMaterial(String mainMaterial) {
        uriBuilder.setParameter("mainMaterial", String.valueOf(mainMaterial));
        return this;
    }

    public DaeguManufacturerStatusAPI mainMaterialContaining(String mainMaterial) {
        uriBuilder.setParameter("mainMaterialContaining", mainMaterial);
        return this;
    }

}