package com.openmind.ezdg.UlfptcaAlarmInqireSvc;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class UlfptcaAlarmInfoResponse {

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
        private String sn;
        private String dataDate;
        private String districtName;
        private String moveName;
        private String itemCode;
        private String issueGbn;
        private String issueDate;
        private String issueTime;
        private String issueVal;
        private String clearDate;
        private String clearTime;
        private String clearVal;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("Items: ").append(this.getItems()).append("\n");
            sb.append("Sn: ").append(this.getSn()).append("\n");
            sb.append("DataDate: ").append(this.getDataDate()).append("\n");
            sb.append("DistrictName: ").append(this.getDistrictName()).append("\n");
            sb.append("MoveName: ").append(this.getMoveName()).append("\n");
            sb.append("ItemCode: ").append(this.getItemCode()).append("\n");
            sb.append("IssueGbn: ").append(this.getIssueGbn()).append("\n");
            sb.append("IssueDate: ").append(this.getIssueDate()).append("\n");
            sb.append("IssueTime: ").append(this.getIssueTime()).append("\n");
            sb.append("IssueVal: ").append(this.getIssueVal()).append("\n");
            sb.append("ClearDate: ").append(this.getClearDate()).append("\n");
            sb.append("ClearTime: ").append(this.getClearTime()).append("\n");
            sb.append("ClearVal: ").append(this.getClearVal()).append("\n");
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