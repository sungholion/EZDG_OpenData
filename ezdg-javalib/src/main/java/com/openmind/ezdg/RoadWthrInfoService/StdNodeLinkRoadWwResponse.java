package com.openmind.ezdg.RoadWthrInfoService;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class StdNodeLinkRoadWwResponse {

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
        private String baseData;
        private String baseTime;
        private String weatherNm;
        private String cctvId;
        private String cctvNm;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("BaseData: ").append(this.getBaseData()).append("\n");
            sb.append("BaseTime: ").append(this.getBaseTime()).append("\n");
            sb.append("WeatherNm: ").append(this.getWeatherNm()).append("\n");
            sb.append("CctvId: ").append(this.getCctvId()).append("\n");
            sb.append("CctvNm: ").append(this.getCctvNm()).append("\n");
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