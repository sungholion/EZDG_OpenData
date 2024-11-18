package com.openmind.ezdg.PubDataOpnStdService;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class DataSetOpnStdBidPblancInfoResponse {

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
        private String bidNtceNo;
        private String bidNtceOrd;
        private String refNtceNo;
        private String refNtceOrd;
        private String ppsNtceYn;
        private String bidNtceNm;
        private String bidNtceSttusNm;
        private String bidNtceDate;
        private String bidNtceBgn;
        private String bsnsDivNm;
        private String intrntnlBidYn;
        private String cmmnCntrctYn;
        private String cmmnReciptMethdNm;
        private String elctrnBidYn;
        private String cntrctCnclsSttusNm;
        private String cntrctCnclsMthdNm;
        private String bidwinrDcsnMthdNm;
        private String ntceInsttNm;
        private String ntceInsttCd;
        private String ntceInsttOfclDeptNm;
        private String ntceInsttOfclNm;
        private String ntceInsttOfclTel;
        private String ntceInsttOfclEmailAdrs;
        private String dmndInsttNm;
        private String dmndInsttCd;
        private String dmndInsttOfclDeptNm;
        private String dmndInsttOfclNm;
        private String dmndInsttOfclTel;
        private String dmndInsttOfclEmailAdrs;
        private String presnatnOprtnYn;
        private String presnatnOprtnDate;
        private String presnatnOprtnTm;
        private String presnatnOprtnPlce;
        private String bidPrtcptQlfctRgstClseDate;
        private String bidPrtcptQlfctRgstClseTm;
        private String cmmnReciptAgrmntClseDate;
        private String cmmnReciptAgrmntClseTm;
        private String bidBeginDate;
        private String bidBeginTm;
        private String bidClseDate;
        private String bidClseTm;
        private String opengDate;
        private String opengTm;
        private String opengPlce;
        private String asignBdgtAmt;
        private String presmptPrce;
        private String rsrvtnPrceDcsnMthdNm;
        private String rgnLmtYn;
        private String prtcptPsblRgnNm;
        private String indstrytyLmtYn;
        private String bidprcPsblIndstrytyNm;
        private String bidNtceUrl;
        private String dataBssDate;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("BidNtceNo: ").append(this.getBidNtceNo()).append("\n");
            sb.append("BidNtceOrd: ").append(this.getBidNtceOrd()).append("\n");
            sb.append("RefNtceNo: ").append(this.getRefNtceNo()).append("\n");
            sb.append("RefNtceOrd: ").append(this.getRefNtceOrd()).append("\n");
            sb.append("PpsNtceYn: ").append(this.getPpsNtceYn()).append("\n");
            sb.append("BidNtceNm: ").append(this.getBidNtceNm()).append("\n");
            sb.append("BidNtceSttusNm: ").append(this.getBidNtceSttusNm()).append("\n");
            sb.append("BidNtceDate: ").append(this.getBidNtceDate()).append("\n");
            sb.append("BidNtceBgn: ").append(this.getBidNtceBgn()).append("\n");
            sb.append("BsnsDivNm: ").append(this.getBsnsDivNm()).append("\n");
            sb.append("IntrntnlBidYn: ").append(this.getIntrntnlBidYn()).append("\n");
            sb.append("CmmnCntrctYn: ").append(this.getCmmnCntrctYn()).append("\n");
            sb.append("CmmnReciptMethdNm: ").append(this.getCmmnReciptMethdNm()).append("\n");
            sb.append("ElctrnBidYn: ").append(this.getElctrnBidYn()).append("\n");
            sb.append("CntrctCnclsSttusNm: ").append(this.getCntrctCnclsSttusNm()).append("\n");
            sb.append("CntrctCnclsMthdNm: ").append(this.getCntrctCnclsMthdNm()).append("\n");
            sb.append("BidwinrDcsnMthdNm: ").append(this.getBidwinrDcsnMthdNm()).append("\n");
            sb.append("NtceInsttNm: ").append(this.getNtceInsttNm()).append("\n");
            sb.append("NtceInsttCd: ").append(this.getNtceInsttCd()).append("\n");
            sb.append("NtceInsttOfclDeptNm: ").append(this.getNtceInsttOfclDeptNm()).append("\n");
            sb.append("NtceInsttOfclNm: ").append(this.getNtceInsttOfclNm()).append("\n");
            sb.append("NtceInsttOfclTel: ").append(this.getNtceInsttOfclTel()).append("\n");
            sb.append("NtceInsttOfclEmailAdrs: ").append(this.getNtceInsttOfclEmailAdrs()).append("\n");
            sb.append("DmndInsttNm: ").append(this.getDmndInsttNm()).append("\n");
            sb.append("DmndInsttCd: ").append(this.getDmndInsttCd()).append("\n");
            sb.append("DmndInsttOfclDeptNm: ").append(this.getDmndInsttOfclDeptNm()).append("\n");
            sb.append("DmndInsttOfclNm: ").append(this.getDmndInsttOfclNm()).append("\n");
            sb.append("DmndInsttOfclTel: ").append(this.getDmndInsttOfclTel()).append("\n");
            sb.append("DmndInsttOfclEmailAdrs: ").append(this.getDmndInsttOfclEmailAdrs()).append("\n");
            sb.append("PresnatnOprtnYn: ").append(this.getPresnatnOprtnYn()).append("\n");
            sb.append("PresnatnOprtnDate: ").append(this.getPresnatnOprtnDate()).append("\n");
            sb.append("PresnatnOprtnTm: ").append(this.getPresnatnOprtnTm()).append("\n");
            sb.append("PresnatnOprtnPlce: ").append(this.getPresnatnOprtnPlce()).append("\n");
            sb.append("BidPrtcptQlfctRgstClseDate: ").append(this.getBidPrtcptQlfctRgstClseDate()).append("\n");
            sb.append("BidPrtcptQlfctRgstClseTm: ").append(this.getBidPrtcptQlfctRgstClseTm()).append("\n");
            sb.append("CmmnReciptAgrmntClseDate: ").append(this.getCmmnReciptAgrmntClseDate()).append("\n");
            sb.append("CmmnReciptAgrmntClseTm: ").append(this.getCmmnReciptAgrmntClseTm()).append("\n");
            sb.append("BidBeginDate: ").append(this.getBidBeginDate()).append("\n");
            sb.append("BidBeginTm: ").append(this.getBidBeginTm()).append("\n");
            sb.append("BidClseDate: ").append(this.getBidClseDate()).append("\n");
            sb.append("BidClseTm: ").append(this.getBidClseTm()).append("\n");
            sb.append("OpengDate: ").append(this.getOpengDate()).append("\n");
            sb.append("OpengTm: ").append(this.getOpengTm()).append("\n");
            sb.append("OpengPlce: ").append(this.getOpengPlce()).append("\n");
            sb.append("AsignBdgtAmt: ").append(this.getAsignBdgtAmt()).append("\n");
            sb.append("PresmptPrce: ").append(this.getPresmptPrce()).append("\n");
            sb.append("RsrvtnPrceDcsnMthdNm: ").append(this.getRsrvtnPrceDcsnMthdNm()).append("\n");
            sb.append("RgnLmtYn: ").append(this.getRgnLmtYn()).append("\n");
            sb.append("PrtcptPsblRgnNm: ").append(this.getPrtcptPsblRgnNm()).append("\n");
            sb.append("IndstrytyLmtYn: ").append(this.getIndstrytyLmtYn()).append("\n");
            sb.append("BidprcPsblIndstrytyNm: ").append(this.getBidprcPsblIndstrytyNm()).append("\n");
            sb.append("BidNtceUrl: ").append(this.getBidNtceUrl()).append("\n");
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