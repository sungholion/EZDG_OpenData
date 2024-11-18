package com.openmind.ezdg.daegu_education_school_status;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;

public class DaeguEducationSchoolStatusAPI extends AbstractAPI<DaeguEducationSchoolStatus> {

    public DaeguEducationSchoolStatusAPI() {
        super("/daegu_education_school_status");
    }

    public DaeguEducationSchoolStatusAPI page(int page) {
        return (DaeguEducationSchoolStatusAPI) super.page(page);
    }

    public DaeguEducationSchoolStatusAPI perPage(int perPage) {
        return (DaeguEducationSchoolStatusAPI) super.perPage(perPage);
    }

    public DaeguEducationSchoolStatusAPI schoolName(String schoolName) {
        uriBuilder.setParameter("schoolName", String.valueOf(schoolName));
        return this;
    }

    public DaeguEducationSchoolStatusAPI schoolNameContaining(String schoolName) {
        uriBuilder.setParameter("schoolNameContaining", schoolName);
        return this;
    }

    public DaeguEducationSchoolStatusAPI districtCountyOffice(String districtCountyOffice) {
        uriBuilder.setParameter("districtCountyOffice", String.valueOf(districtCountyOffice));
        return this;
    }

    public DaeguEducationSchoolStatusAPI districtCountyOfficeContaining(String districtCountyOffice) {
        uriBuilder.setParameter("districtCountyOfficeContaining", districtCountyOffice);
        return this;
    }

    public DaeguEducationSchoolStatusAPI address(String address) {
        uriBuilder.setParameter("address", String.valueOf(address));
        return this;
    }

    public DaeguEducationSchoolStatusAPI addressContaining(String address) {
        uriBuilder.setParameter("addressContaining", address);
        return this;
    }

    public DaeguEducationSchoolStatusAPI postcode(Long postcode) {
        uriBuilder.setParameter("postcode", String.valueOf(postcode));
        return this;
    }

    public DaeguEducationSchoolStatusAPI postcodeLt(Long postcodeLt) {
        uriBuilder.setParameter("postcodeLt", String.valueOf(postcodeLt));
        return this;
    }

    public DaeguEducationSchoolStatusAPI postcodeLte(Long postcodeLte) {
        uriBuilder.setParameter("postcodeLte", String.valueOf(postcodeLte));
        return this;
    }

    public DaeguEducationSchoolStatusAPI postcodeGt(Long postcodeGt) {
        uriBuilder.setParameter("postcodeGt", String.valueOf(postcodeGt));
        return this;
    }

    public DaeguEducationSchoolStatusAPI postcodeGte(Long postcodeGte) {
        uriBuilder.setParameter("postcodeGte", String.valueOf(postcodeGte));
        return this;
    }
    public DaeguEducationSchoolStatusAPI phoneNumber(String phoneNumber) {
        uriBuilder.setParameter("phoneNumber", String.valueOf(phoneNumber));
        return this;
    }

    public DaeguEducationSchoolStatusAPI phoneNumberContaining(String phoneNumber) {
        uriBuilder.setParameter("phoneNumberContaining", phoneNumber);
        return this;
    }

    public DaeguEducationSchoolStatusAPI faxNumber(String faxNumber) {
        uriBuilder.setParameter("faxNumber", String.valueOf(faxNumber));
        return this;
    }

    public DaeguEducationSchoolStatusAPI faxNumberContaining(String faxNumber) {
        uriBuilder.setParameter("faxNumberContaining", faxNumber);
        return this;
    }

}