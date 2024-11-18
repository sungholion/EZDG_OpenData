package com.openmind.ezdg.PubDataOpnStdService;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class DataSetOpnStdCntrctInfoResponse {

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
        private String cntrctNo;
        private String untyCntrctNo;
        private String cntrctOrd;
        private String cntrctNm;
        private String bsnsDivNm;
        private String cntrctCnclsSttusNm;
        private String cntrctCnclsMthdNm;
        private String lngtrmCtnuDivNm;
        private String cmmnCntrctYn;
        private String cntrctCnclsDate;
        private String cntrctPrd;
        private String cntrctAmt;
        private String ttalCntrctAmt;
        private String cntrctInfoUrl;
        private String bidNtceNo;
        private String bidNtceOrd;
        private String bidNtceNm;
        private String opengDate;
        private String opengTm;
        private String rsrvtnPrce;
        private String prvtcntrctRsn;
        private String bidNtceUrl;
        private String cntrctInsttDivNm;
        private String cntrctInsttNm;
        private String cntrctInsttCd;
        private String cntrctInsttChrgDeptNm;
        private String cntrctInsttOfclNm;
        private String cntrctInsttOfclTel;
        private String cntrctInsttOfcl;
        private String dmndInsttDivNm;
        private String dmndInsttNm;
        private String dmndInsttCd;
        private String dmndInsttOfclDeptNm;
        private String dmndInsttOfclNm;
        private String dmndInsttOfclTel;
        private String dmndInsttOfclEmailAdrs;
        private String rprsntCorpNm;
        private String dmstcCorpYn;
        private String rprsntCorpCeoNm;
        private String rprsntCorpOfclNm;
        private String rprsntCorpBizrno;
        private String rprsntCorpAdrs;
        private String rprsntCorpContactTel;
        private String dataBssDate;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("CntrctNo: ").append(this.getCntrctNo()).append("\n");
            sb.append("UntyCntrctNo: ").append(this.getUntyCntrctNo()).append("\n");
            sb.append("CntrctOrd: ").append(this.getCntrctOrd()).append("\n");
            sb.append("CntrctNm: ").append(this.getCntrctNm()).append("\n");
            sb.append("BsnsDivNm: ").append(this.getBsnsDivNm()).append("\n");
            sb.append("CntrctCnclsSttusNm: ").append(this.getCntrctCnclsSttusNm()).append("\n");
            sb.append("CntrctCnclsMthdNm: ").append(this.getCntrctCnclsMthdNm()).append("\n");
            sb.append("LngtrmCtnuDivNm: ").append(this.getLngtrmCtnuDivNm()).append("\n");
            sb.append("CmmnCntrctYn: ").append(this.getCmmnCntrctYn()).append("\n");
            sb.append("CntrctCnclsDate: ").append(this.getCntrctCnclsDate()).append("\n");
            sb.append("CntrctPrd: ").append(this.getCntrctPrd()).append("\n");
            sb.append("CntrctAmt: ").append(this.getCntrctAmt()).append("\n");
            sb.append("TtalCntrctAmt: ").append(this.getTtalCntrctAmt()).append("\n");
            sb.append("CntrctInfoUrl: ").append(this.getCntrctInfoUrl()).append("\n");
            sb.append("BidNtceNo: ").append(this.getBidNtceNo()).append("\n");
            sb.append("BidNtceOrd: ").append(this.getBidNtceOrd()).append("\n");
            sb.append("BidNtceNm: ").append(this.getBidNtceNm()).append("\n");
            sb.append("OpengDate: ").append(this.getOpengDate()).append("\n");
            sb.append("OpengTm: ").append(this.getOpengTm()).append("\n");
            sb.append("RsrvtnPrce: ").append(this.getRsrvtnPrce()).append("\n");
            sb.append("PrvtcntrctRsn: ").append(this.getPrvtcntrctRsn()).append("\n");
            sb.append("BidNtceUrl: ").append(this.getBidNtceUrl()).append("\n");
            sb.append("CntrctInsttDivNm: ").append(this.getCntrctInsttDivNm()).append("\n");
            sb.append("CntrctInsttNm: ").append(this.getCntrctInsttNm()).append("\n");
            sb.append("CntrctInsttCd: ").append(this.getCntrctInsttCd()).append("\n");
            sb.append("CntrctInsttChrgDeptNm: ").append(this.getCntrctInsttChrgDeptNm()).append("\n");
            sb.append("CntrctInsttOfclNm: ").append(this.getCntrctInsttOfclNm()).append("\n");
            sb.append("CntrctInsttOfclTel: ").append(this.getCntrctInsttOfclTel()).append("\n");
            sb.append("CntrctInsttOfcl: ").append(this.getCntrctInsttOfcl()).append("\n");
            sb.append("DmndInsttDivNm: ").append(this.getDmndInsttDivNm()).append("\n");
            sb.append("DmndInsttNm: ").append(this.getDmndInsttNm()).append("\n");
            sb.append("DmndInsttCd: ").append(this.getDmndInsttCd()).append("\n");
            sb.append("DmndInsttOfclDeptNm: ").append(this.getDmndInsttOfclDeptNm()).append("\n");
            sb.append("DmndInsttOfclNm: ").append(this.getDmndInsttOfclNm()).append("\n");
            sb.append("DmndInsttOfclTel: ").append(this.getDmndInsttOfclTel()).append("\n");
            sb.append("DmndInsttOfclEmailAdrs: ").append(this.getDmndInsttOfclEmailAdrs()).append("\n");
            sb.append("RprsntCorpNm: ").append(this.getRprsntCorpNm()).append("\n");
            sb.append("DmstcCorpYn: ").append(this.getDmstcCorpYn()).append("\n");
            sb.append("RprsntCorpCeoNm: ").append(this.getRprsntCorpCeoNm()).append("\n");
            sb.append("RprsntCorpOfclNm: ").append(this.getRprsntCorpOfclNm()).append("\n");
            sb.append("RprsntCorpBizrno: ").append(this.getRprsntCorpBizrno()).append("\n");
            sb.append("RprsntCorpAdrs: ").append(this.getRprsntCorpAdrs()).append("\n");
            sb.append("RprsntCorpContactTel: ").append(this.getRprsntCorpContactTel()).append("\n");
            sb.append("DataBssDate: ").append(this.getDataBssDate()).append("\n");
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