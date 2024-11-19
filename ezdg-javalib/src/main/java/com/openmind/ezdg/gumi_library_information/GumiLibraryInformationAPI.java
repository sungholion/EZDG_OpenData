package com.openmind.ezdg.gumi_library_information;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;

public class GumiLibraryInformationAPI extends AbstractAPI<GumiLibraryInformation> {

    public GumiLibraryInformationAPI() {
        super("/gumi_library_information");
    }

    public GumiLibraryInformationAPI page(int page) {
        return (GumiLibraryInformationAPI) super.page(page);
    }

    public GumiLibraryInformationAPI perPage(int perPage) {
        return (GumiLibraryInformationAPI) super.perPage(perPage);
    }

    public GumiLibraryInformationAPI order(Long order) {
        uriBuilder.setParameter("order", String.valueOf(order));
        return this;
    }

    public GumiLibraryInformationAPI orderLt(Long orderLt) {
        uriBuilder.setParameter("orderLt", String.valueOf(orderLt));
        return this;
    }

    public GumiLibraryInformationAPI orderLte(Long orderLte) {
        uriBuilder.setParameter("orderLte", String.valueOf(orderLte));
        return this;
    }

    public GumiLibraryInformationAPI orderGt(Long orderGt) {
        uriBuilder.setParameter("orderGt", String.valueOf(orderGt));
        return this;
    }

    public GumiLibraryInformationAPI orderGte(Long orderGte) {
        uriBuilder.setParameter("orderGte", String.valueOf(orderGte));
        return this;
    }
    public GumiLibraryInformationAPI magazineName(String magazineName) {
        uriBuilder.setParameter("magazineName", String.valueOf(magazineName));
        return this;
    }

    public GumiLibraryInformationAPI magazineNameContaining(String magazineName) {
        uriBuilder.setParameter("magazineNameContaining", magazineName);
        return this;
    }

    public GumiLibraryInformationAPI placeOfIssue(String placeOfIssue) {
        uriBuilder.setParameter("placeOfIssue", String.valueOf(placeOfIssue));
        return this;
    }

    public GumiLibraryInformationAPI placeOfIssueContaining(String placeOfIssue) {
        uriBuilder.setParameter("placeOfIssueContaining", placeOfIssue);
        return this;
    }

    public GumiLibraryInformationAPI period(String period) {
        uriBuilder.setParameter("period", String.valueOf(period));
        return this;
    }

    public GumiLibraryInformationAPI periodContaining(String period) {
        uriBuilder.setParameter("periodContaining", period);
        return this;
    }

    public GumiLibraryInformationAPI location(String location) {
        uriBuilder.setParameter("location", String.valueOf(location));
        return this;
    }

    public GumiLibraryInformationAPI locationContaining(String location) {
        uriBuilder.setParameter("locationContaining", location);
        return this;
    }

}