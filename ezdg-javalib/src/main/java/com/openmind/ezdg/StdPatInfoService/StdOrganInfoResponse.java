package com.openmind.ezdg.StdPatInfoService;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class StdOrganInfoResponse {

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
        private String num;
        private String stdorgancd;
        private String sginfoclass;
        private String sginfoclass1;
        private String sginfoclass2;
        private String sginfoclass3;
        private String stdfieldEng;
        private String stdfieldKor;
        private String workprogress;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("Num: ").append(this.getNum()).append("\n");
            sb.append("Stdorgancd: ").append(this.getStdorgancd()).append("\n");
            sb.append("Sginfoclass: ").append(this.getSginfoclass()).append("\n");
            sb.append("Sginfoclass1: ").append(this.getSginfoclass1()).append("\n");
            sb.append("Sginfoclass2: ").append(this.getSginfoclass2()).append("\n");
            sb.append("Sginfoclass3: ").append(this.getSginfoclass3()).append("\n");
            sb.append("StdfieldEng: ").append(this.getStdfieldEng()).append("\n");
            sb.append("StdfieldKor: ").append(this.getStdfieldKor()).append("\n");
            sb.append("Workprogress: ").append(this.getWorkprogress()).append("\n");
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