package com.openmind.ezdg.ArpltnInforInqireSvc;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class MinuDustFrcstDspthResponse {

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
        private String informCode;
        private String infornOverall;
        private String informCause;
        private String informGrade;
        private String actionKnack;
        private String imageUrl1;
        private String imageUrl2;
        private String imageUrl3;
        private String imageUrl4;
        private String imageUrl5;
        private String imageUrl6;
        private String imageUrl7;
        private String imageUrl8;
        private String imageUrl9;
        private String informData;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("Items: ").append(this.getItems()).append("\n");
            sb.append("DataTime: ").append(this.getDataTime()).append("\n");
            sb.append("InformCode: ").append(this.getInformCode()).append("\n");
            sb.append("InfornOverall: ").append(this.getInfornOverall()).append("\n");
            sb.append("InformCause: ").append(this.getInformCause()).append("\n");
            sb.append("InformGrade: ").append(this.getInformGrade()).append("\n");
            sb.append("ActionKnack: ").append(this.getActionKnack()).append("\n");
            sb.append("ImageUrl1: ").append(this.getImageUrl1()).append("\n");
            sb.append("ImageUrl2: ").append(this.getImageUrl2()).append("\n");
            sb.append("ImageUrl3: ").append(this.getImageUrl3()).append("\n");
            sb.append("ImageUrl4: ").append(this.getImageUrl4()).append("\n");
            sb.append("ImageUrl5: ").append(this.getImageUrl5()).append("\n");
            sb.append("ImageUrl6: ").append(this.getImageUrl6()).append("\n");
            sb.append("ImageUrl7: ").append(this.getImageUrl7()).append("\n");
            sb.append("ImageUrl8: ").append(this.getImageUrl8()).append("\n");
            sb.append("ImageUrl9: ").append(this.getImageUrl9()).append("\n");
            sb.append("InformData: ").append(this.getInformData()).append("\n");
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