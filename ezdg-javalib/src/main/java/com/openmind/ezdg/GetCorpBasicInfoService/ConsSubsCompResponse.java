package com.openmind.ezdg.GetCorpBasicInfoService;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class ConsSubsCompResponse {

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
        private String sbrdEnpNm;
        private String sbrdEnpEstbDt;
        private String sbrdEnpAdr;
        private String sbrdEnpMainBizCtt;
        private String sbrdEnpLtstEbzyrTastAmt;
        private String dntRltBsisCtt;
        private String mainSbrdEnpYnCtt;
        private String basDt;
        private String crno;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("SbrdEnpNm: ").append(this.getSbrdEnpNm()).append("\n");
            sb.append("SbrdEnpEstbDt: ").append(this.getSbrdEnpEstbDt()).append("\n");
            sb.append("SbrdEnpAdr: ").append(this.getSbrdEnpAdr()).append("\n");
            sb.append("SbrdEnpMainBizCtt: ").append(this.getSbrdEnpMainBizCtt()).append("\n");
            sb.append("SbrdEnpLtstEbzyrTastAmt: ").append(this.getSbrdEnpLtstEbzyrTastAmt()).append("\n");
            sb.append("DntRltBsisCtt: ").append(this.getDntRltBsisCtt()).append("\n");
            sb.append("MainSbrdEnpYnCtt: ").append(this.getMainSbrdEnpYnCtt()).append("\n");
            sb.append("BasDt: ").append(this.getBasDt()).append("\n");
            sb.append("Crno: ").append(this.getCrno()).append("\n");
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