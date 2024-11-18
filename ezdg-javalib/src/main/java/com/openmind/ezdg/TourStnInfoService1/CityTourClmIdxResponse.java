package com.openmind.ezdg.TourStnInfoService1;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class CityTourClmIdxResponse {

    private Response response;

    @Getter
    @Setter
    public static class Response {
        private Header header;
        private Body body;
    }

    @Getter
    @Setter
    public static class Header {
        private Integer resultCode;
        private String resultMsg;
    }

    @Getter
    @Setter
    public static class Body {
        private String dataType;
        private Items items;
        private String pageNo;
        private String numOfRows;
        private String totalCount;
    }

    @Getter
    @Setter
    public static class Items {
        private List<Item> item;
    }

    @Getter
    @Setter
    public static class Item {
        private String tm;
        private String totalCityName;
        private String doName;
        private String cityName;
        private String cityAreaId;
        private String kmaTci;
        private String TCI_GRADE;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("Tm: ").append(this.getTm()).append("\n");
            sb.append("TotalCityName: ").append(this.getTotalCityName()).append("\n");
            sb.append("DoName: ").append(this.getDoName()).append("\n");
            sb.append("CityName: ").append(this.getCityName()).append("\n");
            sb.append("CityAreaId: ").append(this.getCityAreaId()).append("\n");
            sb.append("KmaTci: ").append(this.getKmaTci()).append("\n");
            sb.append("TCI_GRADE: ").append(this.getTCI_GRADE()).append("\n");
            sb.append("-----------------------\n");
            return sb.toString();
        }
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
             return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return super.toString();
        }
    }
}