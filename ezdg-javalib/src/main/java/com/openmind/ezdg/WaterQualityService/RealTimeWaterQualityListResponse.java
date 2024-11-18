package com.openmind.ezdg.WaterQualityService;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class RealTimeWaterQualityListResponse {

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
        private String rowno;
        private String siteId;
        private String siteName;
        private String msrDate;
        private String m01;
        private String m02;
        private String m03;
        private String m04;
        private String m05;
        private String m06;
        private String m07;
        private String m08;
        private String m09;
        private String m10;
        private String m11;
        private String m12;
        private String m13;
        private String m14;
        private String m15;
        private String m16;
        private String m17;
        private String m18;
        private String m19;
        private String m20;
        private String m21;
        private String m22;
        private String m23;
        private String m24;
        private String m25;
        private String m26;
        private String m27;
        private String m28;
        private String m29;
        private String m30;
        private String m31;
        private String m32;
        private String m33;
        private String m34;
        private String m35;
        private String m36;
        private String m37;
        private String m38;
        private String m39;
        private String m40;
        private String m41;
        private String m42;
        private String m43;
        private String m44;
        private String m45;
        private String m46;
        private String m47;
        private String m48;
        private String m49;
        private String m50;
        private String m51;
        private String m52;
        private String m53;
        private String m54;
        private String m55;
        private String m56;
        private String m57;
        private String m58;
        private String m59;
        private String m60;
        private String m61;
        private String m62;
        private String m63;
        private String m64;
        private String m65;
        private String m66;
        private String m67;
        private String m68;
        private String m69;
        private String m70;
        private String m71;
        private String m72;
        private String m73;
        private String m74;
        private String m75;
        private String m76;
        private String m77;
        private String m78;
        private String m79;
        private String m80;
        private String m81;
        private String m82;
        private String m83;
        private String m84;
        private String m85;
        private String m86;
        private String m87;
        private String m88;
        private String m89;
        private String m90;
        private String m91;
        private String m92;
        private String m93;
        private String m94;
        private String m95;
        private String m96;
        private String m97;
        private String m98;
        private String m99;
        private String m100;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("Rowno: ").append(this.getRowno()).append("\n");
            sb.append("SiteId: ").append(this.getSiteId()).append("\n");
            sb.append("SiteName: ").append(this.getSiteName()).append("\n");
            sb.append("MsrDate: ").append(this.getMsrDate()).append("\n");
            sb.append("M01: ").append(this.getM01()).append("\n");
            sb.append("M02: ").append(this.getM02()).append("\n");
            sb.append("M03: ").append(this.getM03()).append("\n");
            sb.append("M04: ").append(this.getM04()).append("\n");
            sb.append("M05: ").append(this.getM05()).append("\n");
            sb.append("M06: ").append(this.getM06()).append("\n");
            sb.append("M07: ").append(this.getM07()).append("\n");
            sb.append("M08: ").append(this.getM08()).append("\n");
            sb.append("M09: ").append(this.getM09()).append("\n");
            sb.append("M10: ").append(this.getM10()).append("\n");
            sb.append("M11: ").append(this.getM11()).append("\n");
            sb.append("M12: ").append(this.getM12()).append("\n");
            sb.append("M13: ").append(this.getM13()).append("\n");
            sb.append("M14: ").append(this.getM14()).append("\n");
            sb.append("M15: ").append(this.getM15()).append("\n");
            sb.append("M16: ").append(this.getM16()).append("\n");
            sb.append("M17: ").append(this.getM17()).append("\n");
            sb.append("M18: ").append(this.getM18()).append("\n");
            sb.append("M19: ").append(this.getM19()).append("\n");
            sb.append("M20: ").append(this.getM20()).append("\n");
            sb.append("M21: ").append(this.getM21()).append("\n");
            sb.append("M22: ").append(this.getM22()).append("\n");
            sb.append("M23: ").append(this.getM23()).append("\n");
            sb.append("M24: ").append(this.getM24()).append("\n");
            sb.append("M25: ").append(this.getM25()).append("\n");
            sb.append("M26: ").append(this.getM26()).append("\n");
            sb.append("M27: ").append(this.getM27()).append("\n");
            sb.append("M28: ").append(this.getM28()).append("\n");
            sb.append("M29: ").append(this.getM29()).append("\n");
            sb.append("M30: ").append(this.getM30()).append("\n");
            sb.append("M31: ").append(this.getM31()).append("\n");
            sb.append("M32: ").append(this.getM32()).append("\n");
            sb.append("M33: ").append(this.getM33()).append("\n");
            sb.append("M34: ").append(this.getM34()).append("\n");
            sb.append("M35: ").append(this.getM35()).append("\n");
            sb.append("M36: ").append(this.getM36()).append("\n");
            sb.append("M37: ").append(this.getM37()).append("\n");
            sb.append("M38: ").append(this.getM38()).append("\n");
            sb.append("M39: ").append(this.getM39()).append("\n");
            sb.append("M40: ").append(this.getM40()).append("\n");
            sb.append("M41: ").append(this.getM41()).append("\n");
            sb.append("M42: ").append(this.getM42()).append("\n");
            sb.append("M43: ").append(this.getM43()).append("\n");
            sb.append("M44: ").append(this.getM44()).append("\n");
            sb.append("M45: ").append(this.getM45()).append("\n");
            sb.append("M46: ").append(this.getM46()).append("\n");
            sb.append("M47: ").append(this.getM47()).append("\n");
            sb.append("M48: ").append(this.getM48()).append("\n");
            sb.append("M49: ").append(this.getM49()).append("\n");
            sb.append("M50: ").append(this.getM50()).append("\n");
            sb.append("M51: ").append(this.getM51()).append("\n");
            sb.append("M52: ").append(this.getM52()).append("\n");
            sb.append("M53: ").append(this.getM53()).append("\n");
            sb.append("M54: ").append(this.getM54()).append("\n");
            sb.append("M55: ").append(this.getM55()).append("\n");
            sb.append("M56: ").append(this.getM56()).append("\n");
            sb.append("M57: ").append(this.getM57()).append("\n");
            sb.append("M58: ").append(this.getM58()).append("\n");
            sb.append("M59: ").append(this.getM59()).append("\n");
            sb.append("M60: ").append(this.getM60()).append("\n");
            sb.append("M61: ").append(this.getM61()).append("\n");
            sb.append("M62: ").append(this.getM62()).append("\n");
            sb.append("M63: ").append(this.getM63()).append("\n");
            sb.append("M64: ").append(this.getM64()).append("\n");
            sb.append("M65: ").append(this.getM65()).append("\n");
            sb.append("M66: ").append(this.getM66()).append("\n");
            sb.append("M67: ").append(this.getM67()).append("\n");
            sb.append("M68: ").append(this.getM68()).append("\n");
            sb.append("M69: ").append(this.getM69()).append("\n");
            sb.append("M70: ").append(this.getM70()).append("\n");
            sb.append("M71: ").append(this.getM71()).append("\n");
            sb.append("M72: ").append(this.getM72()).append("\n");
            sb.append("M73: ").append(this.getM73()).append("\n");
            sb.append("M74: ").append(this.getM74()).append("\n");
            sb.append("M75: ").append(this.getM75()).append("\n");
            sb.append("M76: ").append(this.getM76()).append("\n");
            sb.append("M77: ").append(this.getM77()).append("\n");
            sb.append("M78: ").append(this.getM78()).append("\n");
            sb.append("M79: ").append(this.getM79()).append("\n");
            sb.append("M80: ").append(this.getM80()).append("\n");
            sb.append("M81: ").append(this.getM81()).append("\n");
            sb.append("M82: ").append(this.getM82()).append("\n");
            sb.append("M83: ").append(this.getM83()).append("\n");
            sb.append("M84: ").append(this.getM84()).append("\n");
            sb.append("M85: ").append(this.getM85()).append("\n");
            sb.append("M86: ").append(this.getM86()).append("\n");
            sb.append("M87: ").append(this.getM87()).append("\n");
            sb.append("M88: ").append(this.getM88()).append("\n");
            sb.append("M89: ").append(this.getM89()).append("\n");
            sb.append("M90: ").append(this.getM90()).append("\n");
            sb.append("M91: ").append(this.getM91()).append("\n");
            sb.append("M92: ").append(this.getM92()).append("\n");
            sb.append("M93: ").append(this.getM93()).append("\n");
            sb.append("M94: ").append(this.getM94()).append("\n");
            sb.append("M95: ").append(this.getM95()).append("\n");
            sb.append("M96: ").append(this.getM96()).append("\n");
            sb.append("M97: ").append(this.getM97()).append("\n");
            sb.append("M98: ").append(this.getM98()).append("\n");
            sb.append("M99: ").append(this.getM99()).append("\n");
            sb.append("M100: ").append(this.getM100()).append("\n");
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