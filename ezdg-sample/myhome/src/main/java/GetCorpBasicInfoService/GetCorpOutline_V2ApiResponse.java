package GetCorpBasicInfoService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetCorpOutline_V2ApiResponse {
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
            private String actnAudpnNm;
            private String audtRptOpnnCtt;
            private String enpMainBizNm;
            private String enpKrxLstgAbolDt;
            private String smenpYn;
            private String enpMntrBnkNm;
            private String enpEmpeCnt;
            private String empeAvgCnwkTermCtt;
            private String enpPn1AvgSlryAmt;
            private String fstOpegDt;
            private String lastOpegDt;
            private String crno;
            private String corpNm;
            private String corpEnsnNm;
            private String enpPbanCmpyNm;
            private String enpRprFnm;
            private String corpRegMrktDcd;
            private String corpRegMrktDcdNm;
            private String corpDcd;
            private String corpDcdNm;
            private String bzno;
            private String enpOzpno;
            private String enpBsadr;
            private String enpDtadr;
            private String enpHmpgUrl;
            private String enpTlno;
            private String enpFxno;
            private String sicNm;
            private String enpEstbDt;
            private String enpStacMm;
            private String enpXchgLstgDt;
            private String enpXchgLstgAbolDt;
            private String enpKosdaqLstgDt;
            private String enpKosdaqLstgAbolDt;
            private String enpKrxLstgDt;
            private String fssCorpUnqNo;
            private String fssCorpChgDtm;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
                sb.append("ActnAudpnNm: ").append(this.getActnAudpnNm()).append("\n");
                sb.append("AudtRptOpnnCtt: ").append(this.getAudtRptOpnnCtt()).append("\n");
                sb.append("EnpMainBizNm: ").append(this.getEnpMainBizNm()).append("\n");
                sb.append("EnpKrxLstgAbolDt: ").append(this.getEnpKrxLstgAbolDt()).append("\n");
                sb.append("SmenpYn: ").append(this.getSmenpYn()).append("\n");
                sb.append("EnpMntrBnkNm: ").append(this.getEnpMntrBnkNm()).append("\n");
                sb.append("EnpEmpeCnt: ").append(this.getEnpEmpeCnt()).append("\n");
                sb.append("EmpeAvgCnwkTermCtt: ").append(this.getEmpeAvgCnwkTermCtt()).append("\n");
                sb.append("EnpPn1AvgSlryAmt: ").append(this.getEnpPn1AvgSlryAmt()).append("\n");
                sb.append("FstOpegDt: ").append(this.getFstOpegDt()).append("\n");
                sb.append("LastOpegDt: ").append(this.getLastOpegDt()).append("\n");
                sb.append("Crno: ").append(this.getCrno()).append("\n");
                sb.append("CorpNm: ").append(this.getCorpNm()).append("\n");
                sb.append("CorpEnsnNm: ").append(this.getCorpEnsnNm()).append("\n");
                sb.append("EnpPbanCmpyNm: ").append(this.getEnpPbanCmpyNm()).append("\n");
                sb.append("EnpRprFnm: ").append(this.getEnpRprFnm()).append("\n");
                sb.append("CorpRegMrktDcd: ").append(this.getCorpRegMrktDcd()).append("\n");
                sb.append("CorpRegMrktDcdNm: ").append(this.getCorpRegMrktDcdNm()).append("\n");
                sb.append("CorpDcd: ").append(this.getCorpDcd()).append("\n");
                sb.append("CorpDcdNm: ").append(this.getCorpDcdNm()).append("\n");
                sb.append("Bzno: ").append(this.getBzno()).append("\n");
                sb.append("EnpOzpno: ").append(this.getEnpOzpno()).append("\n");
                sb.append("EnpBsadr: ").append(this.getEnpBsadr()).append("\n");
                sb.append("EnpDtadr: ").append(this.getEnpDtadr()).append("\n");
                sb.append("EnpHmpgUrl: ").append(this.getEnpHmpgUrl()).append("\n");
                sb.append("EnpTlno: ").append(this.getEnpTlno()).append("\n");
                sb.append("EnpFxno: ").append(this.getEnpFxno()).append("\n");
                sb.append("SicNm: ").append(this.getSicNm()).append("\n");
                sb.append("EnpEstbDt: ").append(this.getEnpEstbDt()).append("\n");
                sb.append("EnpStacMm: ").append(this.getEnpStacMm()).append("\n");
                sb.append("EnpXchgLstgDt: ").append(this.getEnpXchgLstgDt()).append("\n");
                sb.append("EnpXchgLstgAbolDt: ").append(this.getEnpXchgLstgAbolDt()).append("\n");
                sb.append("EnpKosdaqLstgDt: ").append(this.getEnpKosdaqLstgDt()).append("\n");
                sb.append("EnpKosdaqLstgAbolDt: ").append(this.getEnpKosdaqLstgAbolDt()).append("\n");
                sb.append("EnpKrxLstgDt: ").append(this.getEnpKrxLstgDt()).append("\n");
                sb.append("FssCorpUnqNo: ").append(this.getFssCorpUnqNo()).append("\n");
                sb.append("FssCorpChgDtm: ").append(this.getFssCorpChgDtm()).append("\n");
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