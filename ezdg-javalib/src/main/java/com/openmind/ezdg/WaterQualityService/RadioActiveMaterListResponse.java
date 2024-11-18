package com.openmind.ezdg.WaterQualityService;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class RadioActiveMaterListResponse {

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
        private String rn;
        private String ptNo;
        private String ptNm;
        private String wmcymd;
        private String act1;
        private String act2;
        private String act3;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("Rn: ").append(this.getRn()).append("\n");
            sb.append("PtNo: ").append(this.getPtNo()).append("\n");
            sb.append("PtNm: ").append(this.getPtNm()).append("\n");
            sb.append("Wmcymd: ").append(this.getWmcymd()).append("\n");
            sb.append("Act1: ").append(this.getAct1()).append("\n");
            sb.append("Act2: ").append(this.getAct2()).append("\n");
            sb.append("Act3: ").append(this.getAct3()).append("\n");
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