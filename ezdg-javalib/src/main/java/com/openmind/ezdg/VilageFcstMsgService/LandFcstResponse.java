package com.openmind.ezdg.VilageFcstMsgService;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class LandFcstResponse {

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
        private String regId;
        private String announceTime;
        private String numEf;
        private String wd1;
        private String wdTnd;
        private String wd2;
        private String wsIt;
        private String ta;
        private String rnSt;
        private String wf;
        private String wfCd;
        private String rnYn;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("RegId: ").append(this.getRegId()).append("\n");
            sb.append("AnnounceTime: ").append(this.getAnnounceTime()).append("\n");
            sb.append("NumEf: ").append(this.getNumEf()).append("\n");
            sb.append("Wd1: ").append(this.getWd1()).append("\n");
            sb.append("WdTnd: ").append(this.getWdTnd()).append("\n");
            sb.append("Wd2: ").append(this.getWd2()).append("\n");
            sb.append("WsIt: ").append(this.getWsIt()).append("\n");
            sb.append("Ta: ").append(this.getTa()).append("\n");
            sb.append("RnSt: ").append(this.getRnSt()).append("\n");
            sb.append("Wf: ").append(this.getWf()).append("\n");
            sb.append("WfCd: ").append(this.getWfCd()).append("\n");
            sb.append("RnYn: ").append(this.getRnYn()).append("\n");
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