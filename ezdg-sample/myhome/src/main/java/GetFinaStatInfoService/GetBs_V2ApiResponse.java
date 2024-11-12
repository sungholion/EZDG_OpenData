package GetFinaStatInfoService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetBs_V2ApiResponse {
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
            private String acitId;
            private String acitNm;
            private String bizYear;
            private String bpvtrAcitAmt;
            private String crno;
            private String crtmAcitAmt;
            private String curCd;
            private String fnclDcd;
            private String fnclDcdNm;
            private String lsqtAcitAmt;
            private String pvtrAcitAmt;
            private String thqrAcitAmt;
            private String basDt;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
                sb.append("AcitId: ").append(this.getAcitId()).append("\n");
                sb.append("AcitNm: ").append(this.getAcitNm()).append("\n");
                sb.append("BizYear: ").append(this.getBizYear()).append("\n");
                sb.append("BpvtrAcitAmt: ").append(this.getBpvtrAcitAmt()).append("\n");
                sb.append("Crno: ").append(this.getCrno()).append("\n");
                sb.append("CrtmAcitAmt: ").append(this.getCrtmAcitAmt()).append("\n");
                sb.append("CurCd: ").append(this.getCurCd()).append("\n");
                sb.append("FnclDcd: ").append(this.getFnclDcd()).append("\n");
                sb.append("FnclDcdNm: ").append(this.getFnclDcdNm()).append("\n");
                sb.append("LsqtAcitAmt: ").append(this.getLsqtAcitAmt()).append("\n");
                sb.append("PvtrAcitAmt: ").append(this.getPvtrAcitAmt()).append("\n");
                sb.append("ThqrAcitAmt: ").append(this.getThqrAcitAmt()).append("\n");
                sb.append("BasDt: ").append(this.getBasDt()).append("\n");
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