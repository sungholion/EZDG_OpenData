package com.openmind.ezdg.AsosHourlyInfoService;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class WthrDataListResponse {

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
        private String stnId;
        private String tm;
        private String stnNm;
        private String rnum;
        private String m03Te;
        private String m02Te;
        private String m01Te;
        private String m005Te;
        private String ts;
        private String dmstMtphNo;
        private String gndSttCd;
        private String vs;
        private String lcsCh;
        private String clfmAbbrCd;
        private String dc10LmcsCa;
        private String dc10Tca;
        private String hr3Fhsc;
        private String dsnw;
        private String icsr;
        private String ss;
        private String ssQcflag;
        private String ps;
        private String psQcflag;
        private String pa;
        private String paQcflag;
        private String td;
        private String pv;
        private String hm;
        private String hmQcflag;
        private String wd;
        private String wdQcflag;
        private String ws;
        private String wsQcflag;
        private String rn;
        private String rnQcflag;
        private String ta;
        private String taQcflag;
        private String tsQcflg;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("StnId: ").append(this.getStnId()).append("\n");
            sb.append("Tm: ").append(this.getTm()).append("\n");
            sb.append("StnNm: ").append(this.getStnNm()).append("\n");
            sb.append("Rnum: ").append(this.getRnum()).append("\n");
            sb.append("M03Te: ").append(this.getM03Te()).append("\n");
            sb.append("M02Te: ").append(this.getM02Te()).append("\n");
            sb.append("M01Te: ").append(this.getM01Te()).append("\n");
            sb.append("M005Te: ").append(this.getM005Te()).append("\n");
            sb.append("Ts: ").append(this.getTs()).append("\n");
            sb.append("DmstMtphNo: ").append(this.getDmstMtphNo()).append("\n");
            sb.append("GndSttCd: ").append(this.getGndSttCd()).append("\n");
            sb.append("Vs: ").append(this.getVs()).append("\n");
            sb.append("LcsCh: ").append(this.getLcsCh()).append("\n");
            sb.append("ClfmAbbrCd: ").append(this.getClfmAbbrCd()).append("\n");
            sb.append("Dc10LmcsCa: ").append(this.getDc10LmcsCa()).append("\n");
            sb.append("Dc10Tca: ").append(this.getDc10Tca()).append("\n");
            sb.append("Hr3Fhsc: ").append(this.getHr3Fhsc()).append("\n");
            sb.append("Dsnw: ").append(this.getDsnw()).append("\n");
            sb.append("Icsr: ").append(this.getIcsr()).append("\n");
            sb.append("Ss: ").append(this.getSs()).append("\n");
            sb.append("SsQcflag: ").append(this.getSsQcflag()).append("\n");
            sb.append("Ps: ").append(this.getPs()).append("\n");
            sb.append("PsQcflag: ").append(this.getPsQcflag()).append("\n");
            sb.append("Pa: ").append(this.getPa()).append("\n");
            sb.append("PaQcflag: ").append(this.getPaQcflag()).append("\n");
            sb.append("Td: ").append(this.getTd()).append("\n");
            sb.append("Pv: ").append(this.getPv()).append("\n");
            sb.append("Hm: ").append(this.getHm()).append("\n");
            sb.append("HmQcflag: ").append(this.getHmQcflag()).append("\n");
            sb.append("Wd: ").append(this.getWd()).append("\n");
            sb.append("WdQcflag: ").append(this.getWdQcflag()).append("\n");
            sb.append("Ws: ").append(this.getWs()).append("\n");
            sb.append("WsQcflag: ").append(this.getWsQcflag()).append("\n");
            sb.append("Rn: ").append(this.getRn()).append("\n");
            sb.append("RnQcflag: ").append(this.getRnQcflag()).append("\n");
            sb.append("Ta: ").append(this.getTa()).append("\n");
            sb.append("TaQcflag: ").append(this.getTaQcflag()).append("\n");
            sb.append("TsQcflg: ").append(this.getTsQcflg()).append("\n");
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