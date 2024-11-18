package com.openmind.ezdg.BeachInfoservice;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class VilageFcstBeachResponse {

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
        private String beachNum;
        private String baseDate;
        private String baseTime;
        private String category;
        private String fcstDate;
        private String fcstTime;
        private String fcstValue;
        private String nx;
        private String ny;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("BeachNum: ").append(this.getBeachNum()).append("\n");
            sb.append("BaseDate: ").append(this.getBaseDate()).append("\n");
            sb.append("BaseTime: ").append(this.getBaseTime()).append("\n");
            sb.append("Category: ").append(this.getCategory()).append("\n");
            sb.append("FcstDate: ").append(this.getFcstDate()).append("\n");
            sb.append("FcstTime: ").append(this.getFcstTime()).append("\n");
            sb.append("FcstValue: ").append(this.getFcstValue()).append("\n");
            sb.append("Nx: ").append(this.getNx()).append("\n");
            sb.append("Ny: ").append(this.getNy()).append("\n");
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