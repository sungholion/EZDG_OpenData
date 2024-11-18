package com.openmind.ezdg_api_server.gumi_factory_registration_status;

import com.openmind.ezdg_api_server.gumi_factory_registration_status.GumiFactoryRegistrationStatusService;
import com.openmind.ezdg_api_server.gumi_factory_registration_status.GumiFactoryRegistrationStatus;
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
@RequestMapping("/gumi_factory_registration_status")
public class GumiFactoryRegistrationStatusController {

    private final GumiFactoryRegistrationStatusService service;

    @GetMapping("")
    public List<GumiFactoryRegistrationStatus> search (
            @RequestParam(required = false) String classification,
            @RequestParam(required = false) String classificationContaining,
        <            @RequestParam(required = false) String companyName,
            @RequestParam(required = false) String companyNameContaining,
        <            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String phoneNumberContaining,
        <            @RequestParam(required = false) String factoryRepresentativeAddress,
            @RequestParam(required = false) String factoryRepresentativeAddressContaining,
        <            @RequestParam(required = false) String businessName,
            @RequestParam(required = false) String businessNameContaining,
        <            @RequestParam(required = false) Long numberOfEmployees,
        <            @RequestParam(required = false) Long numberOfEmployeesLt,
            @RequestParam(required = false) Long numberOfEmployeesLte,
            @RequestParam(required = false) Long numberOfEmployeesGt,
            @RequestParam(required = false) Long numberOfEmployeesGte,
            @RequestParam(required = false) String managementAgencyName,
            @RequestParam(required = false) String managementAgencyNameContaining,
        <            @RequestParam(required = false) String managementAgencyPhoneNumber,
            @RequestParam(required = false) String managementAgencyPhoneNumberContaining,
        <            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int perPage) {

        Map <String, Object> params = new HashMap<>();

        params.put("classification", classification);
        params.put("classificationContaining", classificationContaining);
        params.put("companyName", companyName);
        params.put("companyNameContaining", companyNameContaining);
        params.put("phoneNumber", phoneNumber);
        params.put("phoneNumberContaining", phoneNumberContaining);
        params.put("factoryRepresentativeAddress", factoryRepresentativeAddress);
        params.put("factoryRepresentativeAddressContaining", factoryRepresentativeAddressContaining);
        params.put("businessName", businessName);
        params.put("businessNameContaining", businessNameContaining);
        params.put("numberOfEmployees", numberOfEmployees);
        params.put("numberOfEmployeesLt", numberOfEmployeesLt);
        params.put("numberOfEmployeesLte", numberOfEmployeesLte);
        params.put("numberOfEmployeesGt", numberOfEmployeesGt);
        params.put("numberOfEmployeesGte", numberOfEmployeesGte);
        params.put("managementAgencyName", managementAgencyName);
        params.put("managementAgencyNameContaining", managementAgencyNameContaining);
        params.put("managementAgencyPhoneNumber", managementAgencyPhoneNumber);
        params.put("managementAgencyPhoneNumberContaining", managementAgencyPhoneNumberContaining);

        return service.search(params, page, perPage);
    }
}
