package com.openmind.ezdg.busan_beach_visit_status;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;

public class BusanBeachVisitStatusAPI extends AbstractAPI<BusanBeachVisitStatus> {

    public BusanBeachVisitStatusAPI() {
        super("/busan_beach_visit_status");
    }

    public BusanBeachVisitStatusAPI page(int page) {
        return (BusanBeachVisitStatusAPI) super.page(page);
    }

    public BusanBeachVisitStatusAPI perPage(int perPage) {
        return (BusanBeachVisitStatusAPI) super.perPage(perPage);
    }

    public BusanBeachVisitStatusAPI byYear(Long byYear) {
        uriBuilder.setParameter("byYear", String.valueOf(byYear));
        return this;
    }

    public BusanBeachVisitStatusAPI byYearLt(Long byYearLt) {
        uriBuilder.setParameter("byYearLt", String.valueOf(byYearLt));
        return this;
    }

    public BusanBeachVisitStatusAPI byYearLte(Long byYearLte) {
        uriBuilder.setParameter("byYearLte", String.valueOf(byYearLte));
        return this;
    }

    public BusanBeachVisitStatusAPI byYearGt(Long byYearGt) {
        uriBuilder.setParameter("byYearGt", String.valueOf(byYearGt));
        return this;
    }

    public BusanBeachVisitStatusAPI byYearGte(Long byYearGte) {
        uriBuilder.setParameter("byYearGte", String.valueOf(byYearGte));
        return this;
    }
    public BusanBeachVisitStatusAPI sido(String sido) {
        uriBuilder.setParameter("sido", String.valueOf(sido));
        return this;
    }

    public BusanBeachVisitStatusAPI sidoContaining(String sido) {
        uriBuilder.setParameter("sidoContaining", sido);
        return this;
    }

    public BusanBeachVisitStatusAPI gugun(String gugun) {
        uriBuilder.setParameter("gugun", String.valueOf(gugun));
        return this;
    }

    public BusanBeachVisitStatusAPI gugunContaining(String gugun) {
        uriBuilder.setParameter("gugunContaining", gugun);
        return this;
    }

    public BusanBeachVisitStatusAPI beachName(String beachName) {
        uriBuilder.setParameter("beachName", String.valueOf(beachName));
        return this;
    }

    public BusanBeachVisitStatusAPI beachNameContaining(String beachName) {
        uriBuilder.setParameter("beachNameContaining", beachName);
        return this;
    }

    public BusanBeachVisitStatusAPI scale(Long scale) {
        uriBuilder.setParameter("scale", String.valueOf(scale));
        return this;
    }

    public BusanBeachVisitStatusAPI scaleLt(Long scaleLt) {
        uriBuilder.setParameter("scaleLt", String.valueOf(scaleLt));
        return this;
    }

    public BusanBeachVisitStatusAPI scaleLte(Long scaleLte) {
        uriBuilder.setParameter("scaleLte", String.valueOf(scaleLte));
        return this;
    }

    public BusanBeachVisitStatusAPI scaleGt(Long scaleGt) {
        uriBuilder.setParameter("scaleGt", String.valueOf(scaleGt));
        return this;
    }

    public BusanBeachVisitStatusAPI scaleGte(Long scaleGte) {
        uriBuilder.setParameter("scaleGte", String.valueOf(scaleGte));
        return this;
    }
    public BusanBeachVisitStatusAPI numberOfVisitors(String numberOfVisitors) {
        uriBuilder.setParameter("numberOfVisitors", String.valueOf(numberOfVisitors));
        return this;
    }

    public BusanBeachVisitStatusAPI numberOfVisitorsContaining(String numberOfVisitors) {
        uriBuilder.setParameter("numberOfVisitorsContaining", numberOfVisitors);
        return this;
    }

    public BusanBeachVisitStatusAPI openingDate(String openingDate) {
        uriBuilder.setParameter("openingDate", String.valueOf(openingDate));
        return this;
    }

    public BusanBeachVisitStatusAPI openingDateContaining(String openingDate) {
        uriBuilder.setParameter("openingDateContaining", openingDate);
        return this;
    }

    public BusanBeachVisitStatusAPI closingDate(String closingDate) {
        uriBuilder.setParameter("closingDate", String.valueOf(closingDate));
        return this;
    }

    public BusanBeachVisitStatusAPI closingDateContaining(String closingDate) {
        uriBuilder.setParameter("closingDateContaining", closingDate);
        return this;
    }

    public BusanBeachVisitStatusAPI notice(String notice) {
        uriBuilder.setParameter("notice", String.valueOf(notice));
        return this;
    }

    public BusanBeachVisitStatusAPI noticeContaining(String notice) {
        uriBuilder.setParameter("noticeContaining", notice);
        return this;
    }

}