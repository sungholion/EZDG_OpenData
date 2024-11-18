package com.openmind.ezdg.ArpltnStatsSvc;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class CtprvnMesureLIstResponse {

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
        private String dataTime;
        private String itemCode;
        private String dataGubun;
        private String seoul;
        private String busan;
        private String daegu;
        private String incheon;
        private String gwangju;
        private String daejeon;
        private String ulsan;
        private String gyeonggi;
        private String gangwon;
        private String chungbuk;
        private String chungnam;
        private String jeonbuk;
        private String jeonnam;
        private String gyeongbuk;
        private String gyeongnam;
        private String jeju;
        private String sejong;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("Items: ").append(this.getItems()).append("\n");
            sb.append("DataTime: ").append(this.getDataTime()).append("\n");
            sb.append("ItemCode: ").append(this.getItemCode()).append("\n");
            sb.append("DataGubun: ").append(this.getDataGubun()).append("\n");
            sb.append("Seoul: ").append(this.getSeoul()).append("\n");
            sb.append("Busan: ").append(this.getBusan()).append("\n");
            sb.append("Daegu: ").append(this.getDaegu()).append("\n");
            sb.append("Incheon: ").append(this.getIncheon()).append("\n");
            sb.append("Gwangju: ").append(this.getGwangju()).append("\n");
            sb.append("Daejeon: ").append(this.getDaejeon()).append("\n");
            sb.append("Ulsan: ").append(this.getUlsan()).append("\n");
            sb.append("Gyeonggi: ").append(this.getGyeonggi()).append("\n");
            sb.append("Gangwon: ").append(this.getGangwon()).append("\n");
            sb.append("Chungbuk: ").append(this.getChungbuk()).append("\n");
            sb.append("Chungnam: ").append(this.getChungnam()).append("\n");
            sb.append("Jeonbuk: ").append(this.getJeonbuk()).append("\n");
            sb.append("Jeonnam: ").append(this.getJeonnam()).append("\n");
            sb.append("Gyeongbuk: ").append(this.getGyeongbuk()).append("\n");
            sb.append("Gyeongnam: ").append(this.getGyeongnam()).append("\n");
            sb.append("Jeju: ").append(this.getJeju()).append("\n");
            sb.append("Sejong: ").append(this.getSejong()).append("\n");
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