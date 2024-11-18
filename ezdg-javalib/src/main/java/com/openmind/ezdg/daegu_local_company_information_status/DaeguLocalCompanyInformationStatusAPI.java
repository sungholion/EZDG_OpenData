package com.openmind.ezdg.daegu_local_company_information_status;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;

public class DaeguLocalCompanyInformationStatusAPI extends AbstractAPI<DaeguLocalCompanyInformationStatus> {

    public DaeguLocalCompanyInformationStatusAPI() {
        super("/daegu_local_company_information_status");
    }

    public DaeguLocalCompanyInformationStatusAPI page(int page) {
        return (DaeguLocalCompanyInformationStatusAPI) super.page(page);
    }

    public DaeguLocalCompanyInformationStatusAPI perPage(int perPage) {
        return (DaeguLocalCompanyInformationStatusAPI) super.perPage(perPage);
    }

    public DaeguLocalCompanyInformationStatusAPI companyName(String companyName) {
        uriBuilder.setParameter("companyName", String.valueOf(companyName));
        return this;
    }

    public DaeguLocalCompanyInformationStatusAPI companyNameContaining(String companyName) {
        uriBuilder.setParameter("companyNameContaining", companyName);
        return this;
    }

    public DaeguLocalCompanyInformationStatusAPI companySize(String companySize) {
        uriBuilder.setParameter("companySize", String.valueOf(companySize));
        return this;
    }

    public DaeguLocalCompanyInformationStatusAPI companySizeContaining(String companySize) {
        uriBuilder.setParameter("companySizeContaining", companySize);
        return this;
    }

}