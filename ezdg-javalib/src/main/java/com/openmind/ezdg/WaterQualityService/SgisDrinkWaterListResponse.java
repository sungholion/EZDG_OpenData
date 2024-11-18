package com.openmind.ezdg.WaterQualityService;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class SgisDrinkWaterListResponse {

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
        private String legacyCodeNo;
        private String spotNm;
        private String spotStdCode;
        private String infoCreatInsttNm;
        private String clMiddleNm;
        private String clSmallNm;
        private String doNm;
        private String ctyNm;
        private String adres;
        private String admcode;
        private String crdntX;
        private String crdntY;
        private String ablAt;
        private String ablDe;
        private String dayAvg;
        private String charge;
        private String insDate;
        private String delYn;
        private String office;
        private String officeTel;
        private String buildingNo;
        private String locJibun;
        private String commt;
        private String yyyy;
        private String period;
        private String inspCheck;
        private String unInspDesc;
        private String acceptYn;
        private String suit;
        private String unsuit;
        private String itemGenbaclow;
        private String itemGenbacmid;
        private String itemTotbac;
        private String itemBac;
        private String itemFestr;
        private String itemBranfungus;
        private String itemGrgungus;
        private String itemSalmol;
        private String itemSegel;
        private String itemSulfungus;
        private String itemYersinia;
        private String itemPb;
        private String itemF;
        private String itemGas;
        private String itemSe;
        private String itemHg;
        private String itemCn;
        private String itemCr6;
        private String itemNo3am;
        private String itemNo3n;
        private String itemCd;
        private String itemBoron;
        private String itemBro3;
        private String itemPhenol;
        private String itemDiazn;
        private String itemParat;
        private String itemPenitro;
        private String itemCarbaryl;
        private String itemTcet;
        private String itemTece;
        private String itemTce;
        private String itemDcm;
        private String itemBenzene;
        private String itemToluene;
        private String itemEtilben;
        private String itemXylene;
        private String itemDce;
        private String itemCcl4;
        private String itemDbcp;
        private String itemC4h8o2;
        private String itemGradient;
        private String itemKmn;
        private String itemSmell;
        private String itemColor;
        private String itemCu;
        private String itemAbs;
        private String itemPh;
        private String itemZn;
        private String itemCl;
        private String itemFe;
        private String itemMn;
        private String itemMuddy;
        private String itemSo42;
        private String itemAl;
        private String inspRst;
        private String failDesc;
        private String sampDate;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("Rowno: ").append(this.getRowno()).append("\n");
            sb.append("LegacyCodeNo: ").append(this.getLegacyCodeNo()).append("\n");
            sb.append("SpotNm: ").append(this.getSpotNm()).append("\n");
            sb.append("SpotStdCode: ").append(this.getSpotStdCode()).append("\n");
            sb.append("InfoCreatInsttNm: ").append(this.getInfoCreatInsttNm()).append("\n");
            sb.append("ClMiddleNm: ").append(this.getClMiddleNm()).append("\n");
            sb.append("ClSmallNm: ").append(this.getClSmallNm()).append("\n");
            sb.append("DoNm: ").append(this.getDoNm()).append("\n");
            sb.append("CtyNm: ").append(this.getCtyNm()).append("\n");
            sb.append("Adres: ").append(this.getAdres()).append("\n");
            sb.append("Admcode: ").append(this.getAdmcode()).append("\n");
            sb.append("CrdntX: ").append(this.getCrdntX()).append("\n");
            sb.append("CrdntY: ").append(this.getCrdntY()).append("\n");
            sb.append("AblAt: ").append(this.getAblAt()).append("\n");
            sb.append("AblDe: ").append(this.getAblDe()).append("\n");
            sb.append("DayAvg: ").append(this.getDayAvg()).append("\n");
            sb.append("Charge: ").append(this.getCharge()).append("\n");
            sb.append("InsDate: ").append(this.getInsDate()).append("\n");
            sb.append("DelYn: ").append(this.getDelYn()).append("\n");
            sb.append("Office: ").append(this.getOffice()).append("\n");
            sb.append("OfficeTel: ").append(this.getOfficeTel()).append("\n");
            sb.append("BuildingNo: ").append(this.getBuildingNo()).append("\n");
            sb.append("LocJibun: ").append(this.getLocJibun()).append("\n");
            sb.append("Commt: ").append(this.getCommt()).append("\n");
            sb.append("Yyyy: ").append(this.getYyyy()).append("\n");
            sb.append("Period: ").append(this.getPeriod()).append("\n");
            sb.append("InspCheck: ").append(this.getInspCheck()).append("\n");
            sb.append("UnInspDesc: ").append(this.getUnInspDesc()).append("\n");
            sb.append("AcceptYn: ").append(this.getAcceptYn()).append("\n");
            sb.append("Suit: ").append(this.getSuit()).append("\n");
            sb.append("Unsuit: ").append(this.getUnsuit()).append("\n");
            sb.append("ItemGenbaclow: ").append(this.getItemGenbaclow()).append("\n");
            sb.append("ItemGenbacmid: ").append(this.getItemGenbacmid()).append("\n");
            sb.append("ItemTotbac: ").append(this.getItemTotbac()).append("\n");
            sb.append("ItemBac: ").append(this.getItemBac()).append("\n");
            sb.append("ItemFestr: ").append(this.getItemFestr()).append("\n");
            sb.append("ItemBranfungus: ").append(this.getItemBranfungus()).append("\n");
            sb.append("ItemGrgungus: ").append(this.getItemGrgungus()).append("\n");
            sb.append("ItemSalmol: ").append(this.getItemSalmol()).append("\n");
            sb.append("ItemSegel: ").append(this.getItemSegel()).append("\n");
            sb.append("ItemSulfungus: ").append(this.getItemSulfungus()).append("\n");
            sb.append("ItemYersinia: ").append(this.getItemYersinia()).append("\n");
            sb.append("ItemPb: ").append(this.getItemPb()).append("\n");
            sb.append("ItemF: ").append(this.getItemF()).append("\n");
            sb.append("ItemGas: ").append(this.getItemGas()).append("\n");
            sb.append("ItemSe: ").append(this.getItemSe()).append("\n");
            sb.append("ItemHg: ").append(this.getItemHg()).append("\n");
            sb.append("ItemCn: ").append(this.getItemCn()).append("\n");
            sb.append("ItemCr6: ").append(this.getItemCr6()).append("\n");
            sb.append("ItemNo3am: ").append(this.getItemNo3am()).append("\n");
            sb.append("ItemNo3n: ").append(this.getItemNo3n()).append("\n");
            sb.append("ItemCd: ").append(this.getItemCd()).append("\n");
            sb.append("ItemBoron: ").append(this.getItemBoron()).append("\n");
            sb.append("ItemBro3: ").append(this.getItemBro3()).append("\n");
            sb.append("ItemPhenol: ").append(this.getItemPhenol()).append("\n");
            sb.append("ItemDiazn: ").append(this.getItemDiazn()).append("\n");
            sb.append("ItemParat: ").append(this.getItemParat()).append("\n");
            sb.append("ItemPenitro: ").append(this.getItemPenitro()).append("\n");
            sb.append("ItemCarbaryl: ").append(this.getItemCarbaryl()).append("\n");
            sb.append("ItemTcet: ").append(this.getItemTcet()).append("\n");
            sb.append("ItemTece: ").append(this.getItemTece()).append("\n");
            sb.append("ItemTce: ").append(this.getItemTce()).append("\n");
            sb.append("ItemDcm: ").append(this.getItemDcm()).append("\n");
            sb.append("ItemBenzene: ").append(this.getItemBenzene()).append("\n");
            sb.append("ItemToluene: ").append(this.getItemToluene()).append("\n");
            sb.append("ItemEtilben: ").append(this.getItemEtilben()).append("\n");
            sb.append("ItemXylene: ").append(this.getItemXylene()).append("\n");
            sb.append("ItemDce: ").append(this.getItemDce()).append("\n");
            sb.append("ItemCcl4: ").append(this.getItemCcl4()).append("\n");
            sb.append("ItemDbcp: ").append(this.getItemDbcp()).append("\n");
            sb.append("ItemC4h8o2: ").append(this.getItemC4h8o2()).append("\n");
            sb.append("ItemGradient: ").append(this.getItemGradient()).append("\n");
            sb.append("ItemKmn: ").append(this.getItemKmn()).append("\n");
            sb.append("ItemSmell: ").append(this.getItemSmell()).append("\n");
            sb.append("ItemColor: ").append(this.getItemColor()).append("\n");
            sb.append("ItemCu: ").append(this.getItemCu()).append("\n");
            sb.append("ItemAbs: ").append(this.getItemAbs()).append("\n");
            sb.append("ItemPh: ").append(this.getItemPh()).append("\n");
            sb.append("ItemZn: ").append(this.getItemZn()).append("\n");
            sb.append("ItemCl: ").append(this.getItemCl()).append("\n");
            sb.append("ItemFe: ").append(this.getItemFe()).append("\n");
            sb.append("ItemMn: ").append(this.getItemMn()).append("\n");
            sb.append("ItemMuddy: ").append(this.getItemMuddy()).append("\n");
            sb.append("ItemSo42: ").append(this.getItemSo42()).append("\n");
            sb.append("ItemAl: ").append(this.getItemAl()).append("\n");
            sb.append("InspRst: ").append(this.getInspRst()).append("\n");
            sb.append("FailDesc: ").append(this.getFailDesc()).append("\n");
            sb.append("SampDate: ").append(this.getSampDate()).append("\n");
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