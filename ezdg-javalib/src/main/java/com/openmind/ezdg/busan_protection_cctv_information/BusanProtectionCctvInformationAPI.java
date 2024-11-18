package com.openmind.ezdg.busan_protection_cctv_information;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;

public class BusanProtectionCctvInformationAPI extends AbstractAPI<BusanProtectionCctvInformation> {

    public BusanProtectionCctvInformationAPI() {
        super("/busan_protection_cctv_information");
    }

    public BusanProtectionCctvInformationAPI page(int page) {
        return (BusanProtectionCctvInformationAPI) super.page(page);
    }

    public BusanProtectionCctvInformationAPI perPage(int perPage) {
        return (BusanProtectionCctvInformationAPI) super.perPage(perPage);
    }

    public BusanProtectionCctvInformationAPI cctvName(String cctvName) {
        uriBuilder.setParameter("cctvName", String.valueOf(cctvName));
        return this;
    }

    public BusanProtectionCctvInformationAPI cctvNameContaining(String cctvName) {
        uriBuilder.setParameter("cctvNameContaining", cctvName);
        return this;
    }

    public BusanProtectionCctvInformationAPI cctvCoordinates(String cctvCoordinates) {
        uriBuilder.setParameter("cctvCoordinates", String.valueOf(cctvCoordinates));
        return this;
    }

    public BusanProtectionCctvInformationAPI cctvCoordinatesContaining(String cctvCoordinates) {
        uriBuilder.setParameter("cctvCoordinatesContaining", cctvCoordinates);
        return this;
    }

    public BusanProtectionCctvInformationAPI cctvGroup(String cctvGroup) {
        uriBuilder.setParameter("cctvGroup", String.valueOf(cctvGroup));
        return this;
    }

    public BusanProtectionCctvInformationAPI cctvGroupContaining(String cctvGroup) {
        uriBuilder.setParameter("cctvGroupContaining", cctvGroup);
        return this;
    }

}