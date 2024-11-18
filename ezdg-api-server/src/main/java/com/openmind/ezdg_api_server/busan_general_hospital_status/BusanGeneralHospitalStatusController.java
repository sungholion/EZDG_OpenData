package com.openmind.ezdg_api_server.busan_general_hospital_status;

import com.openmind.ezdg_api_server.busan_general_hospital_status.BusanGeneralHospitalStatusService;
import com.openmind.ezdg_api_server.busan_general_hospital_status.BusanGeneralHospitalStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/busan_general_hospital_status")
public class BusanGeneralHospitalStatusController {

    private final BusanGeneralHospitalStatusService service;

    @GetMapping("")
    public List<BusanGeneralHospitalStatus> search (
            @RequestParam(required = false) Long number,
            @RequestParam(required = false) Long numberLt,
            @RequestParam(required = false) Long numberLte,
            @RequestParam(required = false) Long numberGt,
            @RequestParam(required = false) Long numberGte,
            @RequestParam(required = false) String nameOfMedicalInstitution,
            @RequestParam(required = false) String nameOfMedicalInstitutionContaining,
            @RequestParam(required = false) String representative,
            @RequestParam(required = false) String representativeContaining,
            @RequestParam(required = false) String roadNameAddress,
            @RequestParam(required = false) String roadNameAddressContaining,
            @RequestParam(required = false) Double longitude,
            @RequestParam(required = false) Double longitudeLt,
            @RequestParam(required = false) Double longitudeLte,
            @RequestParam(required = false) Double longitudeGt,
            @RequestParam(required = false) Double longitudeGte,
            @RequestParam(required = false) Double latitude,
            @RequestParam(required = false) Double latitudeLt,
            @RequestParam(required = false) Double latitudeLte,
            @RequestParam(required = false) Double latitudeGt,
            @RequestParam(required = false) Double latitudeGte,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String phoneNumberContaining,
            @RequestParam(required = false) Long system,
            @RequestParam(required = false) Long systemLt,
            @RequestParam(required = false) Long systemLte,
            @RequestParam(required = false) Long systemGt,
            @RequestParam(required = false) Long systemGte,
            @RequestParam(required = false) Long general,
            @RequestParam(required = false) Long generalLt,
            @RequestParam(required = false) Long generalLte,
            @RequestParam(required = false) Long generalGt,
            @RequestParam(required = false) Long generalGte,
            @RequestParam(required = false) Long spirit,
            @RequestParam(required = false) Long spiritLt,
            @RequestParam(required = false) Long spiritLte,
            @RequestParam(required = false) Long spiritGt,
            @RequestParam(required = false) Long spiritGte,
            @RequestParam(required = false) LocalDate authorizationDate,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int perPage) {

        Map <String, Object> params = new HashMap<>();

        params.put("number", number);
        params.put("numberLt", numberLt);
        params.put("numberLte", numberLte);
        params.put("numberGt", numberGt);
        params.put("numberGte", numberGte);
        params.put("nameOfMedicalInstitution", nameOfMedicalInstitution);
        params.put("nameOfMedicalInstitutionContaining", nameOfMedicalInstitutionContaining);
        params.put("representative", representative);
        params.put("representativeContaining", representativeContaining);
        params.put("roadNameAddress", roadNameAddress);
        params.put("roadNameAddressContaining", roadNameAddressContaining);
        params.put("longitude", longitude);
        params.put("longitudeLt", longitudeLt);
        params.put("longitudeLte", longitudeLte);
        params.put("longitudeGt", longitudeGt);
        params.put("longitudeGte", longitudeGte);
        params.put("latitude", latitude);
        params.put("latitudeLt", latitudeLt);
        params.put("latitudeLte", latitudeLte);
        params.put("latitudeGt", latitudeGt);
        params.put("latitudeGte", latitudeGte);
        params.put("phoneNumber", phoneNumber);
        params.put("phoneNumberContaining", phoneNumberContaining);
        params.put("system", system);
        params.put("systemLt", systemLt);
        params.put("systemLte", systemLte);
        params.put("systemGt", systemGt);
        params.put("systemGte", systemGte);
        params.put("general", general);
        params.put("generalLt", generalLt);
        params.put("generalLte", generalLte);
        params.put("generalGt", generalGt);
        params.put("generalGte", generalGte);
        params.put("spirit", spirit);
        params.put("spiritLt", spiritLt);
        params.put("spiritLte", spiritLte);
        params.put("spiritGt", spiritGt);
        params.put("spiritGte", spiritGte);
        params.put("authorizationDate", authorizationDate);
        params.put("authorizationDateAfter", authorizationDateAfter);
        params.put("authorizationDateBefore", authorizationDateBefore);

        return service.search(params, page, perPage);
    }
}
