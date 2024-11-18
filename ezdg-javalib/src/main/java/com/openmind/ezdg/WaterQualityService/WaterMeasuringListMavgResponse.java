package com.openmind.ezdg.WaterQualityService;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class WaterMeasuringListMavgResponse {

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
        private String ptNo;
        private String ptNm;
        private String wmyr;
        private String wmod;
        private String itemAmnt;
        private String itemTemp;
        private String itemPh;
        private String itemDoc;
        private String itemBod;
        private String itemCod;
        private String itemSs;
        private String itemTcoli;
        private String itemTn;
        private String itemTp;
        private String itemCd;
        private String itemCn;
        private String itemPb;
        private String itemCr6;
        private String itemAs;
        private String itemHg;
        private String itemCu;
        private String itemAbs;
        private String itemPcb;
        private String itemOp;
        private String itemMn;
        private String itemTrans;
        private String itemCloa;
        private String itemCl;
        private String itemZn;
        private String itemCr;
        private String itemFe;
        private String itemPhenol;
        private String itemNhex;
        private String itemEc;
        private String itemTce;
        private String itemNo3n;
        private String itemNh3n;
        private String itemEcoli;
        private String itemPop;
        private String itemDtn;
        private String itemDtp;
        private String itemFl;
        private String itemCol;
        private String itemCcl4;
        private String itemDceth;
        private String itemDcm;
        private String itemBenzene;
        private String itemChcl3;
        private String itemToc;
        private String itemDehp;
        private String itemAntimon;
        private String itemAntimon;
        private String itemHcho;
        private String itemHcb;
        private String itemNi;
        private String itemBa;
        private String itemSe;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("Rowno: ").append(this.getRowno()).append("\n");
            sb.append("PtNo: ").append(this.getPtNo()).append("\n");
            sb.append("PtNm: ").append(this.getPtNm()).append("\n");
            sb.append("Wmyr: ").append(this.getWmyr()).append("\n");
            sb.append("Wmod: ").append(this.getWmod()).append("\n");
            sb.append("ItemAmnt: ").append(this.getItemAmnt()).append("\n");
            sb.append("ItemTemp: ").append(this.getItemTemp()).append("\n");
            sb.append("ItemPh: ").append(this.getItemPh()).append("\n");
            sb.append("ItemDoc: ").append(this.getItemDoc()).append("\n");
            sb.append("ItemBod: ").append(this.getItemBod()).append("\n");
            sb.append("ItemCod: ").append(this.getItemCod()).append("\n");
            sb.append("ItemSs: ").append(this.getItemSs()).append("\n");
            sb.append("ItemTcoli: ").append(this.getItemTcoli()).append("\n");
            sb.append("ItemTn: ").append(this.getItemTn()).append("\n");
            sb.append("ItemTp: ").append(this.getItemTp()).append("\n");
            sb.append("ItemCd: ").append(this.getItemCd()).append("\n");
            sb.append("ItemCn: ").append(this.getItemCn()).append("\n");
            sb.append("ItemPb: ").append(this.getItemPb()).append("\n");
            sb.append("ItemCr6: ").append(this.getItemCr6()).append("\n");
            sb.append("ItemAs: ").append(this.getItemAs()).append("\n");
            sb.append("ItemHg: ").append(this.getItemHg()).append("\n");
            sb.append("ItemCu: ").append(this.getItemCu()).append("\n");
            sb.append("ItemAbs: ").append(this.getItemAbs()).append("\n");
            sb.append("ItemPcb: ").append(this.getItemPcb()).append("\n");
            sb.append("ItemOp: ").append(this.getItemOp()).append("\n");
            sb.append("ItemMn: ").append(this.getItemMn()).append("\n");
            sb.append("ItemTrans: ").append(this.getItemTrans()).append("\n");
            sb.append("ItemCloa: ").append(this.getItemCloa()).append("\n");
            sb.append("ItemCl: ").append(this.getItemCl()).append("\n");
            sb.append("ItemZn: ").append(this.getItemZn()).append("\n");
            sb.append("ItemCr: ").append(this.getItemCr()).append("\n");
            sb.append("ItemFe: ").append(this.getItemFe()).append("\n");
            sb.append("ItemPhenol: ").append(this.getItemPhenol()).append("\n");
            sb.append("ItemNhex: ").append(this.getItemNhex()).append("\n");
            sb.append("ItemEc: ").append(this.getItemEc()).append("\n");
            sb.append("ItemTce: ").append(this.getItemTce()).append("\n");
            sb.append("ItemNo3n: ").append(this.getItemNo3n()).append("\n");
            sb.append("ItemNh3n: ").append(this.getItemNh3n()).append("\n");
            sb.append("ItemEcoli: ").append(this.getItemEcoli()).append("\n");
            sb.append("ItemPop: ").append(this.getItemPop()).append("\n");
            sb.append("ItemDtn: ").append(this.getItemDtn()).append("\n");
            sb.append("ItemDtp: ").append(this.getItemDtp()).append("\n");
            sb.append("ItemFl: ").append(this.getItemFl()).append("\n");
            sb.append("ItemCol: ").append(this.getItemCol()).append("\n");
            sb.append("ItemCcl4: ").append(this.getItemCcl4()).append("\n");
            sb.append("ItemDceth: ").append(this.getItemDceth()).append("\n");
            sb.append("ItemDcm: ").append(this.getItemDcm()).append("\n");
            sb.append("ItemBenzene: ").append(this.getItemBenzene()).append("\n");
            sb.append("ItemChcl3: ").append(this.getItemChcl3()).append("\n");
            sb.append("ItemToc: ").append(this.getItemToc()).append("\n");
            sb.append("ItemDehp: ").append(this.getItemDehp()).append("\n");
            sb.append("ItemAntimon: ").append(this.getItemAntimon()).append("\n");
            sb.append("ItemAntimon: ").append(this.getItemAntimon()).append("\n");
            sb.append("ItemHcho: ").append(this.getItemHcho()).append("\n");
            sb.append("ItemHcb: ").append(this.getItemHcb()).append("\n");
            sb.append("ItemNi: ").append(this.getItemNi()).append("\n");
            sb.append("ItemBa: ").append(this.getItemBa()).append("\n");
            sb.append("ItemSe: ").append(this.getItemSe()).append("\n");
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