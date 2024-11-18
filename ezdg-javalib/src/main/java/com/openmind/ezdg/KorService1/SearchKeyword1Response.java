package com.openmind.ezdg.KorService1;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class SearchKeyword1Response {

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
        private String firstimage;
        private String sigungucode;
        private String cat1;
        private String cat2;
        private String cat3;
        private String contentid;
        private String booktour;
        private String tel;
        private String title;
        private String addr1;
        private String areacode;
        private String mapy;
        private String mlevel;
        private String modifiedtime;
        private String firstimage2;
        private String mapx;
        private String contenttypeid;
        private String addr2;
        private String createdtime;
        private String cpyrhtDivCd;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("Firstimage: ").append(this.getFirstimage()).append("\n");
            sb.append("Sigungucode: ").append(this.getSigungucode()).append("\n");
            sb.append("Cat1: ").append(this.getCat1()).append("\n");
            sb.append("Cat2: ").append(this.getCat2()).append("\n");
            sb.append("Cat3: ").append(this.getCat3()).append("\n");
            sb.append("Contentid: ").append(this.getContentid()).append("\n");
            sb.append("Booktour: ").append(this.getBooktour()).append("\n");
            sb.append("Tel: ").append(this.getTel()).append("\n");
            sb.append("Title: ").append(this.getTitle()).append("\n");
            sb.append("Addr1: ").append(this.getAddr1()).append("\n");
            sb.append("Areacode: ").append(this.getAreacode()).append("\n");
            sb.append("Mapy: ").append(this.getMapy()).append("\n");
            sb.append("Mlevel: ").append(this.getMlevel()).append("\n");
            sb.append("Modifiedtime: ").append(this.getModifiedtime()).append("\n");
            sb.append("Firstimage2: ").append(this.getFirstimage2()).append("\n");
            sb.append("Mapx: ").append(this.getMapx()).append("\n");
            sb.append("Contenttypeid: ").append(this.getContenttypeid()).append("\n");
            sb.append("Addr2: ").append(this.getAddr2()).append("\n");
            sb.append("Createdtime: ").append(this.getCreatedtime()).append("\n");
            sb.append("CpyrhtDivCd: ").append(this.getCpyrhtDivCd()).append("\n");
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