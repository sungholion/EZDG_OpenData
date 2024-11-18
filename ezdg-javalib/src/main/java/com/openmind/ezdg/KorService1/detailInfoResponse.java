package com.openmind.ezdg.KorService1;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class detailInfoResponse {

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
        private String roomimg4;
        private String roomtoiletries;
        private String roomsofa;
        private String roomcook;
        private String roomtable;
        private String roomimg5alt;
        private String contentid;
        private String contenttypeid;
        private String fldgubun;
        private String infoname;
        private String infotext;
        private String serialnum;
        private String subcontentid;
        private String subdetailalt;
        private String subdetailimg;
        private String subdetailoverview;
        private String subname;
        private String subnum;
        private String roomcode;
        private String roomtitle;
        private String roomsize1;
        private String roomcount;
        private String roombasecount;
        private String roommaxcount;
        private String roomoffseasonminfee1;
        private String roomoffseasonminfee2;
        private String roompeakseasonminfee1;
        private String roompeakseasonminfee2;
        private String roomintro;
        private String roombathfacility;
        private String roombath;
        private String roomhometheater;
        private String roomaircondition;
        private String roomtv;
        private String roompc;
        private String roomcable;
        private String roominternet;
        private String roomrefrigerator;
        private String roomimg5;
        private String roomimg3;
        private String roomimg4alt;
        private String roomimg3alt;
        private String roomhairdryer;
        private String roomsize2;
        private String roomimg2alt;
        private String roomimg1;
        private String roomimg1alt;
        private String roomimg2;
        private String cpyrhtDivCd1;
        private String cpyrhtDivCd2;
        private String cpyrhtDivCd3;
        private String cpyrhtDivCd4;
        private String cpyrhtDivCd5;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("Roomimg4: ").append(this.getRoomimg4()).append("\n");
            sb.append("Roomtoiletries: ").append(this.getRoomtoiletries()).append("\n");
            sb.append("Roomsofa: ").append(this.getRoomsofa()).append("\n");
            sb.append("Roomcook: ").append(this.getRoomcook()).append("\n");
            sb.append("Roomtable: ").append(this.getRoomtable()).append("\n");
            sb.append("Roomimg5alt: ").append(this.getRoomimg5alt()).append("\n");
            sb.append("Contentid: ").append(this.getContentid()).append("\n");
            sb.append("Contenttypeid: ").append(this.getContenttypeid()).append("\n");
            sb.append("Fldgubun: ").append(this.getFldgubun()).append("\n");
            sb.append("Infoname: ").append(this.getInfoname()).append("\n");
            sb.append("Infotext: ").append(this.getInfotext()).append("\n");
            sb.append("Serialnum: ").append(this.getSerialnum()).append("\n");
            sb.append("Subcontentid: ").append(this.getSubcontentid()).append("\n");
            sb.append("Subdetailalt: ").append(this.getSubdetailalt()).append("\n");
            sb.append("Subdetailimg: ").append(this.getSubdetailimg()).append("\n");
            sb.append("Subdetailoverview: ").append(this.getSubdetailoverview()).append("\n");
            sb.append("Subname: ").append(this.getSubname()).append("\n");
            sb.append("Subnum: ").append(this.getSubnum()).append("\n");
            sb.append("Roomcode: ").append(this.getRoomcode()).append("\n");
            sb.append("Roomtitle: ").append(this.getRoomtitle()).append("\n");
            sb.append("Roomsize1: ").append(this.getRoomsize1()).append("\n");
            sb.append("Roomcount: ").append(this.getRoomcount()).append("\n");
            sb.append("Roombasecount: ").append(this.getRoombasecount()).append("\n");
            sb.append("Roommaxcount: ").append(this.getRoommaxcount()).append("\n");
            sb.append("Roomoffseasonminfee1: ").append(this.getRoomoffseasonminfee1()).append("\n");
            sb.append("Roomoffseasonminfee2: ").append(this.getRoomoffseasonminfee2()).append("\n");
            sb.append("Roompeakseasonminfee1: ").append(this.getRoompeakseasonminfee1()).append("\n");
            sb.append("Roompeakseasonminfee2: ").append(this.getRoompeakseasonminfee2()).append("\n");
            sb.append("Roomintro: ").append(this.getRoomintro()).append("\n");
            sb.append("Roombathfacility: ").append(this.getRoombathfacility()).append("\n");
            sb.append("Roombath: ").append(this.getRoombath()).append("\n");
            sb.append("Roomhometheater: ").append(this.getRoomhometheater()).append("\n");
            sb.append("Roomaircondition: ").append(this.getRoomaircondition()).append("\n");
            sb.append("Roomtv: ").append(this.getRoomtv()).append("\n");
            sb.append("Roompc: ").append(this.getRoompc()).append("\n");
            sb.append("Roomcable: ").append(this.getRoomcable()).append("\n");
            sb.append("Roominternet: ").append(this.getRoominternet()).append("\n");
            sb.append("Roomrefrigerator: ").append(this.getRoomrefrigerator()).append("\n");
            sb.append("Roomimg5: ").append(this.getRoomimg5()).append("\n");
            sb.append("Roomimg3: ").append(this.getRoomimg3()).append("\n");
            sb.append("Roomimg4alt: ").append(this.getRoomimg4alt()).append("\n");
            sb.append("Roomimg3alt: ").append(this.getRoomimg3alt()).append("\n");
            sb.append("Roomhairdryer: ").append(this.getRoomhairdryer()).append("\n");
            sb.append("Roomsize2: ").append(this.getRoomsize2()).append("\n");
            sb.append("Roomimg2alt: ").append(this.getRoomimg2alt()).append("\n");
            sb.append("Roomimg1: ").append(this.getRoomimg1()).append("\n");
            sb.append("Roomimg1alt: ").append(this.getRoomimg1alt()).append("\n");
            sb.append("Roomimg2: ").append(this.getRoomimg2()).append("\n");
            sb.append("CpyrhtDivCd1: ").append(this.getCpyrhtDivCd1()).append("\n");
            sb.append("CpyrhtDivCd2: ").append(this.getCpyrhtDivCd2()).append("\n");
            sb.append("CpyrhtDivCd3: ").append(this.getCpyrhtDivCd3()).append("\n");
            sb.append("CpyrhtDivCd4: ").append(this.getCpyrhtDivCd4()).append("\n");
            sb.append("CpyrhtDivCd5: ").append(this.getCpyrhtDivCd5()).append("\n");
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