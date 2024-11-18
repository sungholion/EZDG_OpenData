package com.openmind.ezdg.KorService1;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class DetailImage1Response {

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
        private String contentid;
        private String imgname;
        private String originimgurl;
        private String serialnum;
        private String smallimageurl;
        private String cpyrhtDivCd;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("Contentid: ").append(this.getContentid()).append("\n");
            sb.append("Imgname: ").append(this.getImgname()).append("\n");
            sb.append("Originimgurl: ").append(this.getOriginimgurl()).append("\n");
            sb.append("Serialnum: ").append(this.getSerialnum()).append("\n");
            sb.append("Smallimageurl: ").append(this.getSmallimageurl()).append("\n");
            sb.append("CpyrhtDivCd: ").append(this.getCpyrhtDivCd()).append("\n");
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