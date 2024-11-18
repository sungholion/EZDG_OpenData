package com.openmind.ezdg.ArpltnInforInqireSvc;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class MinuDustWeekFrcstDspthResponse {

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
        private String frcstOneCn;
        private String frcstTwoCn;
        private String frcstThreeCn;
        private String frcstFourCn;
        private String presnatnDT;
        private String frcstOneDt;
        private String frcstTwoDt;
        private String frcstThreeDt;
        private String frcstFourDt;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("FrcstOneCn: ").append(this.getFrcstOneCn()).append("\n");
            sb.append("FrcstTwoCn: ").append(this.getFrcstTwoCn()).append("\n");
            sb.append("FrcstThreeCn: ").append(this.getFrcstThreeCn()).append("\n");
            sb.append("FrcstFourCn: ").append(this.getFrcstFourCn()).append("\n");
            sb.append("PresnatnDT: ").append(this.getPresnatnDT()).append("\n");
            sb.append("FrcstOneDt: ").append(this.getFrcstOneDt()).append("\n");
            sb.append("FrcstTwoDt: ").append(this.getFrcstTwoDt()).append("\n");
            sb.append("FrcstThreeDt: ").append(this.getFrcstThreeDt()).append("\n");
            sb.append("FrcstFourDt: ").append(this.getFrcstFourDt()).append("\n");
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