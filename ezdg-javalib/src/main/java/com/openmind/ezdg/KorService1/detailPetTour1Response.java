package com.openmind.ezdg.KorService1;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class detailPetTour1Response {

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
        private String acmpyPsblCpam;
        private String relaRntlPrdlst;
        private String acmpyNeedMtr;
        private String relaFrnshPrdlst;
        private String etcAcmpyInfo;
        private String relaPurcPrdlst;
        private String relaAcdntRiskMtr;
        private String acmpyTypeCd;
        private String relaPosesFclty;
        private String contentid;
        private String petTursmInfo;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("AcmpyPsblCpam: ").append(this.getAcmpyPsblCpam()).append("\n");
            sb.append("RelaRntlPrdlst: ").append(this.getRelaRntlPrdlst()).append("\n");
            sb.append("AcmpyNeedMtr: ").append(this.getAcmpyNeedMtr()).append("\n");
            sb.append("RelaFrnshPrdlst: ").append(this.getRelaFrnshPrdlst()).append("\n");
            sb.append("EtcAcmpyInfo: ").append(this.getEtcAcmpyInfo()).append("\n");
            sb.append("RelaPurcPrdlst: ").append(this.getRelaPurcPrdlst()).append("\n");
            sb.append("RelaAcdntRiskMtr: ").append(this.getRelaAcdntRiskMtr()).append("\n");
            sb.append("AcmpyTypeCd: ").append(this.getAcmpyTypeCd()).append("\n");
            sb.append("RelaPosesFclty: ").append(this.getRelaPosesFclty()).append("\n");
            sb.append("Contentid: ").append(this.getContentid()).append("\n");
            sb.append("PetTursmInfo: ").append(this.getPetTursmInfo()).append("\n");
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