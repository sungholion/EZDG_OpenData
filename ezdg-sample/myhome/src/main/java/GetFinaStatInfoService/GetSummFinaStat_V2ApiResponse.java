package GetFinaStatInfoService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetSummFinaStat_V2ApiResponse {
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
            private String basDt;
            private String bizYear;
            private String crno;
            private String curCd;
            private String enpBzopPft;
            private String enpCptlAmt;
            private String enpCrtmNpf;
            private String enpSaleAmt;
            private String enpTastAmt;
            private String enpTdbtAmt;
            private String enpTcptAmt;
            private String fnclDcd;
            private String fnclDcdNm;
            private String fnclDebtRto;
            private String iclsPalClcAmt;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
                sb.append("BasDt: ").append(this.getBasDt()).append("\n");
                sb.append("BizYear: ").append(this.getBizYear()).append("\n");
                sb.append("Crno: ").append(this.getCrno()).append("\n");
                sb.append("CurCd: ").append(this.getCurCd()).append("\n");
                sb.append("EnpBzopPft: ").append(this.getEnpBzopPft()).append("\n");
                sb.append("EnpCptlAmt: ").append(this.getEnpCptlAmt()).append("\n");
                sb.append("EnpCrtmNpf: ").append(this.getEnpCrtmNpf()).append("\n");
                sb.append("EnpSaleAmt: ").append(this.getEnpSaleAmt()).append("\n");
                sb.append("EnpTastAmt: ").append(this.getEnpTastAmt()).append("\n");
                sb.append("EnpTdbtAmt: ").append(this.getEnpTdbtAmt()).append("\n");
                sb.append("EnpTcptAmt: ").append(this.getEnpTcptAmt()).append("\n");
                sb.append("FnclDcd: ").append(this.getFnclDcd()).append("\n");
                sb.append("FnclDcdNm: ").append(this.getFnclDcdNm()).append("\n");
                sb.append("FnclDebtRto: ").append(this.getFnclDebtRto()).append("\n");
                sb.append("IclsPalClcAmt: ").append(this.getIclsPalClcAmt()).append("\n");
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