package com.openmind.ezdg.StdPatInfoService;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class StdNoDeclareRecordPatInfoResponse {

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
        private String reportveryymn;
        private String stdorgancd;
        private String patpool;
        private String declarerAdjust;
        private String declarercountryAdjust;
        private String patnoOrg;
        private String stdno;
        private String stdaddinfo;
        private String sginfoClass;
        private String dtltech1;
        private String dtltech2;
        private String declaredate;
        private String iprpolicyclass;
        private String iprpolicy;
        private String t0401Mngno;
        private String t0402Mngno;
        private String appcountrycd;
        private String appcountrytitle;
        private String appno;
        private String appdate;
        private String publicno;
        private String publicdate;
        private String regno;
        private String regdate;
        private String ipclist;
        private String ipc;
        private String productclass;
        private String producttitle;
        private String industryclass;
        private String industrytitle;
        private String applicant;
        private String inventor;
        private String inventtitle;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("Num: ").append(this.getNum()).append("\n");
            sb.append("Reportveryymn: ").append(this.getReportveryymn()).append("\n");
            sb.append("Stdorgancd: ").append(this.getStdorgancd()).append("\n");
            sb.append("Patpool: ").append(this.getPatpool()).append("\n");
            sb.append("DeclarerAdjust: ").append(this.getDeclarerAdjust()).append("\n");
            sb.append("DeclarercountryAdjust: ").append(this.getDeclarercountryAdjust()).append("\n");
            sb.append("PatnoOrg: ").append(this.getPatnoOrg()).append("\n");
            sb.append("Stdno: ").append(this.getStdno()).append("\n");
            sb.append("Stdaddinfo: ").append(this.getStdaddinfo()).append("\n");
            sb.append("SginfoClass: ").append(this.getSginfoClass()).append("\n");
            sb.append("Dtltech1: ").append(this.getDtltech1()).append("\n");
            sb.append("Dtltech2: ").append(this.getDtltech2()).append("\n");
            sb.append("Declaredate: ").append(this.getDeclaredate()).append("\n");
            sb.append("Iprpolicyclass: ").append(this.getIprpolicyclass()).append("\n");
            sb.append("Iprpolicy: ").append(this.getIprpolicy()).append("\n");
            sb.append("T0401Mngno: ").append(this.getT0401Mngno()).append("\n");
            sb.append("T0402Mngno: ").append(this.getT0402Mngno()).append("\n");
            sb.append("Appcountrycd: ").append(this.getAppcountrycd()).append("\n");
            sb.append("Appcountrytitle: ").append(this.getAppcountrytitle()).append("\n");
            sb.append("Appno: ").append(this.getAppno()).append("\n");
            sb.append("Appdate: ").append(this.getAppdate()).append("\n");
            sb.append("Publicno: ").append(this.getPublicno()).append("\n");
            sb.append("Publicdate: ").append(this.getPublicdate()).append("\n");
            sb.append("Regno: ").append(this.getRegno()).append("\n");
            sb.append("Regdate: ").append(this.getRegdate()).append("\n");
            sb.append("Ipclist: ").append(this.getIpclist()).append("\n");
            sb.append("Ipc: ").append(this.getIpc()).append("\n");
            sb.append("Productclass: ").append(this.getProductclass()).append("\n");
            sb.append("Producttitle: ").append(this.getProducttitle()).append("\n");
            sb.append("Industryclass: ").append(this.getIndustryclass()).append("\n");
            sb.append("Industrytitle: ").append(this.getIndustrytitle()).append("\n");
            sb.append("Applicant: ").append(this.getApplicant()).append("\n");
            sb.append("Inventor: ").append(this.getInventor()).append("\n");
            sb.append("Inventtitle: ").append(this.getInventtitle()).append("\n");
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