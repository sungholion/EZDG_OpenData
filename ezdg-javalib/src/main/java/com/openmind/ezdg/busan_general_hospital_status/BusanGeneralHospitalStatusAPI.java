package com.openmind.ezdg.busan_general_hospital_status;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;

public class BusanGeneralHospitalStatusAPI extends AbstractAPI<BusanGeneralHospitalStatus> {

    public BusanGeneralHospitalStatusAPI() {
        super("/busan_general_hospital_status");
    }

    public BusanGeneralHospitalStatusAPI page(int page) {
        return (BusanGeneralHospitalStatusAPI) super.page(page);
    }

    public BusanGeneralHospitalStatusAPI perPage(int perPage) {
        return (BusanGeneralHospitalStatusAPI) super.perPage(perPage);
    }

    public BusanGeneralHospitalStatusAPI number(Long number) {
        uriBuilder.setParameter("number", String.valueOf(number));
        return this;
    }

    public BusanGeneralHospitalStatusAPI numberLt(Long numberLt) {
        uriBuilder.setParameter("numberLt", String.valueOf(numberLt));
        return this;
    }

    public BusanGeneralHospitalStatusAPI numberLte(Long numberLte) {
        uriBuilder.setParameter("numberLte", String.valueOf(numberLte));
        return this;
    }

    public BusanGeneralHospitalStatusAPI numberGt(Long numberGt) {
        uriBuilder.setParameter("numberGt", String.valueOf(numberGt));
        return this;
    }

    public BusanGeneralHospitalStatusAPI numberGte(Long numberGte) {
        uriBuilder.setParameter("numberGte", String.valueOf(numberGte));
        return this;
    }
    public BusanGeneralHospitalStatusAPI nameOfMedicalInstitution(String nameOfMedicalInstitution) {
        uriBuilder.setParameter("nameOfMedicalInstitution", String.valueOf(nameOfMedicalInstitution));
        return this;
    }

    public BusanGeneralHospitalStatusAPI nameOfMedicalInstitutionContaining(String nameOfMedicalInstitution) {
        uriBuilder.setParameter("nameOfMedicalInstitutionContaining", nameOfMedicalInstitution);
        return this;
    }

    public BusanGeneralHospitalStatusAPI representative(String representative) {
        uriBuilder.setParameter("representative", String.valueOf(representative));
        return this;
    }

    public BusanGeneralHospitalStatusAPI representativeContaining(String representative) {
        uriBuilder.setParameter("representativeContaining", representative);
        return this;
    }

    public BusanGeneralHospitalStatusAPI roadNameAddress(String roadNameAddress) {
        uriBuilder.setParameter("roadNameAddress", String.valueOf(roadNameAddress));
        return this;
    }

    public BusanGeneralHospitalStatusAPI roadNameAddressContaining(String roadNameAddress) {
        uriBuilder.setParameter("roadNameAddressContaining", roadNameAddress);
        return this;
    }

    public BusanGeneralHospitalStatusAPI longitude(Double longitude) {
        uriBuilder.setParameter("longitude", String.valueOf(longitude));
        return this;
    }

    public BusanGeneralHospitalStatusAPI longitudeLt(Double longitudeLt) {
        uriBuilder.setParameter("longitudeLt", String.valueOf(longitudeLt));
        return this;
    }

    public BusanGeneralHospitalStatusAPI longitudeLte(Double longitudeLte) {
        uriBuilder.setParameter("longitudeLte", String.valueOf(longitudeLte));
        return this;
    }

    public BusanGeneralHospitalStatusAPI longitudeGt(Double longitudeGt) {
        uriBuilder.setParameter("longitudeGt", String.valueOf(longitudeGt));
        return this;
    }

    public BusanGeneralHospitalStatusAPI longitudeGte(Double longitudeGte) {
        uriBuilder.setParameter("longitudeGte", String.valueOf(longitudeGte));
        return this;
    }
    public BusanGeneralHospitalStatusAPI latitude(Double latitude) {
        uriBuilder.setParameter("latitude", String.valueOf(latitude));
        return this;
    }

    public BusanGeneralHospitalStatusAPI latitudeLt(Double latitudeLt) {
        uriBuilder.setParameter("latitudeLt", String.valueOf(latitudeLt));
        return this;
    }

    public BusanGeneralHospitalStatusAPI latitudeLte(Double latitudeLte) {
        uriBuilder.setParameter("latitudeLte", String.valueOf(latitudeLte));
        return this;
    }

    public BusanGeneralHospitalStatusAPI latitudeGt(Double latitudeGt) {
        uriBuilder.setParameter("latitudeGt", String.valueOf(latitudeGt));
        return this;
    }

    public BusanGeneralHospitalStatusAPI latitudeGte(Double latitudeGte) {
        uriBuilder.setParameter("latitudeGte", String.valueOf(latitudeGte));
        return this;
    }
    public BusanGeneralHospitalStatusAPI phoneNumber(String phoneNumber) {
        uriBuilder.setParameter("phoneNumber", String.valueOf(phoneNumber));
        return this;
    }

    public BusanGeneralHospitalStatusAPI phoneNumberContaining(String phoneNumber) {
        uriBuilder.setParameter("phoneNumberContaining", phoneNumber);
        return this;
    }

    public BusanGeneralHospitalStatusAPI system(Long system) {
        uriBuilder.setParameter("system", String.valueOf(system));
        return this;
    }

    public BusanGeneralHospitalStatusAPI systemLt(Long systemLt) {
        uriBuilder.setParameter("systemLt", String.valueOf(systemLt));
        return this;
    }

    public BusanGeneralHospitalStatusAPI systemLte(Long systemLte) {
        uriBuilder.setParameter("systemLte", String.valueOf(systemLte));
        return this;
    }

    public BusanGeneralHospitalStatusAPI systemGt(Long systemGt) {
        uriBuilder.setParameter("systemGt", String.valueOf(systemGt));
        return this;
    }

    public BusanGeneralHospitalStatusAPI systemGte(Long systemGte) {
        uriBuilder.setParameter("systemGte", String.valueOf(systemGte));
        return this;
    }
    public BusanGeneralHospitalStatusAPI general(Long general) {
        uriBuilder.setParameter("general", String.valueOf(general));
        return this;
    }

    public BusanGeneralHospitalStatusAPI generalLt(Long generalLt) {
        uriBuilder.setParameter("generalLt", String.valueOf(generalLt));
        return this;
    }

    public BusanGeneralHospitalStatusAPI generalLte(Long generalLte) {
        uriBuilder.setParameter("generalLte", String.valueOf(generalLte));
        return this;
    }

    public BusanGeneralHospitalStatusAPI generalGt(Long generalGt) {
        uriBuilder.setParameter("generalGt", String.valueOf(generalGt));
        return this;
    }

    public BusanGeneralHospitalStatusAPI generalGte(Long generalGte) {
        uriBuilder.setParameter("generalGte", String.valueOf(generalGte));
        return this;
    }
    public BusanGeneralHospitalStatusAPI spirit(Long spirit) {
        uriBuilder.setParameter("spirit", String.valueOf(spirit));
        return this;
    }

    public BusanGeneralHospitalStatusAPI spiritLt(Long spiritLt) {
        uriBuilder.setParameter("spiritLt", String.valueOf(spiritLt));
        return this;
    }

    public BusanGeneralHospitalStatusAPI spiritLte(Long spiritLte) {
        uriBuilder.setParameter("spiritLte", String.valueOf(spiritLte));
        return this;
    }

    public BusanGeneralHospitalStatusAPI spiritGt(Long spiritGt) {
        uriBuilder.setParameter("spiritGt", String.valueOf(spiritGt));
        return this;
    }

    public BusanGeneralHospitalStatusAPI spiritGte(Long spiritGte) {
        uriBuilder.setParameter("spiritGte", String.valueOf(spiritGte));
        return this;
    }
    public BusanGeneralHospitalStatusAPI authorizationDate(LocalDate authorizationDate) {
        uriBuilder.setParameter("authorizationDate", String.valueOf(authorizationDate));
        return this;
    }

    public BusanGeneralHospitalStatusAPI authorizationDateAfter(LocalDate authorizationDateAfter) {
        uriBuilder.setParameter("authorizationDateAfter", authorizationDateAfter.toString());
        return this;
    }

    public BusanGeneralHospitalStatusAPI authorizationDateBefore(LocalDate authorizationDateBefore) {
        uriBuilder.setParameter("authorizationDateBefore", authorizationDateBefore.toString());
        return this;
    }

}