package com.openmind.ezdg.DrbEasyDrugInfoService;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class DrbEasyDrugListResponse {

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
        private String entpName;
        private String itemName;
        private String itemSeq;
        private String efcyQesitm;
        private String useMethodQesitm;
        private String atpnWarnQesitm;
        private String atpnQesitm;
        private String intrcQesitm;
        private String seQesitm;
        private String depositMethodQesitm;
        private String openDe;
        private String updateDe;
        private String itemImage;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("EntpName: ").append(this.getEntpName()).append("\n");
            sb.append("ItemName: ").append(this.getItemName()).append("\n");
            sb.append("ItemSeq: ").append(this.getItemSeq()).append("\n");
            sb.append("EfcyQesitm: ").append(this.getEfcyQesitm()).append("\n");
            sb.append("UseMethodQesitm: ").append(this.getUseMethodQesitm()).append("\n");
            sb.append("AtpnWarnQesitm: ").append(this.getAtpnWarnQesitm()).append("\n");
            sb.append("AtpnQesitm: ").append(this.getAtpnQesitm()).append("\n");
            sb.append("IntrcQesitm: ").append(this.getIntrcQesitm()).append("\n");
            sb.append("SeQesitm: ").append(this.getSeQesitm()).append("\n");
            sb.append("DepositMethodQesitm: ").append(this.getDepositMethodQesitm()).append("\n");
            sb.append("OpenDe: ").append(this.getOpenDe()).append("\n");
            sb.append("UpdateDe: ").append(this.getUpdateDe()).append("\n");
            sb.append("ItemImage: ").append(this.getItemImage()).append("\n");
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