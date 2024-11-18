package com.openmind.ezdg.ArpltnInforInqireSvc;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class CtprvnRltmMesureDnstyResponse {

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
        private String items;
        private String stationName;
        private String mangName;
        private String dataTime;
        private String so2Value;
        private String coValue;
        private String o3Value;
        private String no2Value;
        private String pm10Value;
        private String pm10Value24;
        private String pm25Value;
        private String pm25Value24;
        private String khaiValue;
        private String khaiGrade;
        private String so2Grade;
        private String coGrade;
        private String o3Grade;
        private String no2Grade;
        private String pm10Grade;
        private String pm25Grade;
        private String pm10Grade1h;
        private String pm25Grade1h;
        private String so2Flag;
        private String coFlag;
        private String o3Flag;
        private String no2Flag;
        private String pm10Flag;
        private String pm25Flag;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("Items: ").append(this.getItems()).append("\n");
            sb.append("StationName: ").append(this.getStationName()).append("\n");
            sb.append("MangName: ").append(this.getMangName()).append("\n");
            sb.append("DataTime: ").append(this.getDataTime()).append("\n");
            sb.append("So2Value: ").append(this.getSo2Value()).append("\n");
            sb.append("CoValue: ").append(this.getCoValue()).append("\n");
            sb.append("O3Value: ").append(this.getO3Value()).append("\n");
            sb.append("No2Value: ").append(this.getNo2Value()).append("\n");
            sb.append("Pm10Value: ").append(this.getPm10Value()).append("\n");
            sb.append("Pm10Value24: ").append(this.getPm10Value24()).append("\n");
            sb.append("Pm25Value: ").append(this.getPm25Value()).append("\n");
            sb.append("Pm25Value24: ").append(this.getPm25Value24()).append("\n");
            sb.append("KhaiValue: ").append(this.getKhaiValue()).append("\n");
            sb.append("KhaiGrade: ").append(this.getKhaiGrade()).append("\n");
            sb.append("So2Grade: ").append(this.getSo2Grade()).append("\n");
            sb.append("CoGrade: ").append(this.getCoGrade()).append("\n");
            sb.append("O3Grade: ").append(this.getO3Grade()).append("\n");
            sb.append("No2Grade: ").append(this.getNo2Grade()).append("\n");
            sb.append("Pm10Grade: ").append(this.getPm10Grade()).append("\n");
            sb.append("Pm25Grade: ").append(this.getPm25Grade()).append("\n");
            sb.append("Pm10Grade1h: ").append(this.getPm10Grade1h()).append("\n");
            sb.append("Pm25Grade1h: ").append(this.getPm25Grade1h()).append("\n");
            sb.append("So2Flag: ").append(this.getSo2Flag()).append("\n");
            sb.append("CoFlag: ").append(this.getCoFlag()).append("\n");
            sb.append("O3Flag: ").append(this.getO3Flag()).append("\n");
            sb.append("No2Flag: ").append(this.getNo2Flag()).append("\n");
            sb.append("Pm10Flag: ").append(this.getPm10Flag()).append("\n");
            sb.append("Pm25Flag: ").append(this.getPm25Flag()).append("\n");
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