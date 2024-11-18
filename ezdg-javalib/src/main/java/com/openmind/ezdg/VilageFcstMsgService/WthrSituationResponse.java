package com.openmind.ezdg.VilageFcstMsgService;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class WthrSituationResponse {

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
        private String tmFc;
        private String wfSv1;
        private String wn;
        private String wr;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("StnId: ").append(this.getStnId()).append("\n");
            sb.append("TmFc: ").append(this.getTmFc()).append("\n");
            sb.append("WfSv1: ").append(this.getWfSv1()).append("\n");
            sb.append("Wn: ").append(this.getWn()).append("\n");
            sb.append("Wr: ").append(this.getWr()).append("\n");
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