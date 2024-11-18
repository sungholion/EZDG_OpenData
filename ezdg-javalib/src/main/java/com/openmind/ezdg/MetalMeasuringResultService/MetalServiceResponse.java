package com.openmind.ezdg.MetalMeasuringResultService;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class MetalServiceResponse {

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
        private String sdate;
        private String stationcode;
        private String itemcode;
        private String timecode;
        private String value;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("Sdate: ").append(this.getSdate()).append("\n");
            sb.append("Stationcode: ").append(this.getStationcode()).append("\n");
            sb.append("Itemcode: ").append(this.getItemcode()).append("\n");
            sb.append("Timecode: ").append(this.getTimecode()).append("\n");
            sb.append("Value: ").append(this.getValue()).append("\n");
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