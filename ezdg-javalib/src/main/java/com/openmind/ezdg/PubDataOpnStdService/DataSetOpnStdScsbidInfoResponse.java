package com.openmind.ezdg.PubDataOpnStdService;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class DataSetOpnStdScsbidInfoResponse {

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
        private String bidNtceNm;
        private String bsnsDivNm;
        private String cntrctCnclsSttusNm;
        private String cntrctCnclsMthdNm;
        private String bidwinrDcsnMthdNm;
        private String ntceInsttNm;
        private String ntceInsttCd;
        private String dmndInsttNm;
        private String dmndInsttCd;
        private String sucsfLwstlmtRt;
        private String presmptPrce;
        private String rsrvtnPrce;
        private String bssAmt;
        private String opengDate;
        private String opengTm;
        private String opengRsltDivNm;
        private String opengRank;
        private String bidprcCorpBizrno;
        private String bidprcCorpNm;
        private String bidprcCorpCeoNm;
        private String bidprcAmt;
        private String bidprcRt;
        private String bidprcDate;
        private String bidprcTm;
        private String sucsfYn;
        private String dqlfctnRsn;
        private String fnlSucsfAmt;
        private String fnlSucsfRt;
        private String fnlSucsfDate;
        private String fnlSucsfCorpNm;
        private String fnlSucsfCorpCeoNm;
        private String fnlSucsfCorpOfclNm;
        private String fnlSucsfCorpBizrno;
        private String fnlSucsfCorpAdrs;
        private String fnlSucsfCorpContactTel;
        private String dataBssDate;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("BidNtceNo: ").append(this.getBidNtceNo()).append("\n");
            sb.append("BidNtceOrd: ").append(this.getBidNtceOrd()).append("\n");
            sb.append("BidNtceNm: ").append(this.getBidNtceNm()).append("\n");
            sb.append("BsnsDivNm: ").append(this.getBsnsDivNm()).append("\n");
            sb.append("CntrctCnclsSttusNm: ").append(this.getCntrctCnclsSttusNm()).append("\n");
            sb.append("CntrctCnclsMthdNm: ").append(this.getCntrctCnclsMthdNm()).append("\n");
            sb.append("BidwinrDcsnMthdNm: ").append(this.getBidwinrDcsnMthdNm()).append("\n");
            sb.append("NtceInsttNm: ").append(this.getNtceInsttNm()).append("\n");
            sb.append("NtceInsttCd: ").append(this.getNtceInsttCd()).append("\n");
            sb.append("DmndInsttNm: ").append(this.getDmndInsttNm()).append("\n");
            sb.append("DmndInsttCd: ").append(this.getDmndInsttCd()).append("\n");
            sb.append("SucsfLwstlmtRt: ").append(this.getSucsfLwstlmtRt()).append("\n");
            sb.append("PresmptPrce: ").append(this.getPresmptPrce()).append("\n");
            sb.append("RsrvtnPrce: ").append(this.getRsrvtnPrce()).append("\n");
            sb.append("BssAmt: ").append(this.getBssAmt()).append("\n");
            sb.append("OpengDate: ").append(this.getOpengDate()).append("\n");
            sb.append("OpengTm: ").append(this.getOpengTm()).append("\n");
            sb.append("OpengRsltDivNm: ").append(this.getOpengRsltDivNm()).append("\n");
            sb.append("OpengRank: ").append(this.getOpengRank()).append("\n");
            sb.append("BidprcCorpBizrno: ").append(this.getBidprcCorpBizrno()).append("\n");
            sb.append("BidprcCorpNm: ").append(this.getBidprcCorpNm()).append("\n");
            sb.append("BidprcCorpCeoNm: ").append(this.getBidprcCorpCeoNm()).append("\n");
            sb.append("BidprcAmt: ").append(this.getBidprcAmt()).append("\n");
            sb.append("BidprcRt: ").append(this.getBidprcRt()).append("\n");
            sb.append("BidprcDate: ").append(this.getBidprcDate()).append("\n");
            sb.append("BidprcTm: ").append(this.getBidprcTm()).append("\n");
            sb.append("SucsfYn: ").append(this.getSucsfYn()).append("\n");
            sb.append("DqlfctnRsn: ").append(this.getDqlfctnRsn()).append("\n");
            sb.append("FnlSucsfAmt: ").append(this.getFnlSucsfAmt()).append("\n");
            sb.append("FnlSucsfRt: ").append(this.getFnlSucsfRt()).append("\n");
            sb.append("FnlSucsfDate: ").append(this.getFnlSucsfDate()).append("\n");
            sb.append("FnlSucsfCorpNm: ").append(this.getFnlSucsfCorpNm()).append("\n");
            sb.append("FnlSucsfCorpCeoNm: ").append(this.getFnlSucsfCorpCeoNm()).append("\n");
            sb.append("FnlSucsfCorpOfclNm: ").append(this.getFnlSucsfCorpOfclNm()).append("\n");
            sb.append("FnlSucsfCorpBizrno: ").append(this.getFnlSucsfCorpBizrno()).append("\n");
            sb.append("FnlSucsfCorpAdrs: ").append(this.getFnlSucsfCorpAdrs()).append("\n");
            sb.append("FnlSucsfCorpContactTel: ").append(this.getFnlSucsfCorpContactTel()).append("\n");
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