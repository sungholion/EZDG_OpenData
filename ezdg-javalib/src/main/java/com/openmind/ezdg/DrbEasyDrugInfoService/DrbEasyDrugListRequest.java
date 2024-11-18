package com.openmind.ezdg.DrbEasyDrugInfoService;

public class DrbEasyDrugListRequest {
    /**
    * 공공데이터포털에서 받은 인증키
    */
    private String ServiceKey;

    /**
    * 페이지번호
    */
    private String pageNo;

    /**
    * 한 페이지 결과 수
    */
    private String numOfRows;

    /**
    * 업체명
    */
    private String entpName;

    /**
    * 제품명
    */
    private String itemName;

    /**
    * 품목기준코드
    */
    private String itemSeq;

    /**
    * 이 약의 효능은 무엇입니까?
    */
    private String efcyQesitm;

    /**
    * 이 약은 어떻게 사용합니까?
    */
    private String useMethodQesitm;

    /**
    * 이 약을 사용하기 전에 반드시 알아야 할 내용은 무엇입니까?
    */
    private String atpnWarnQesitm;

    /**
    * 이 약의 사용상 주의사항은 무엇입니까?
    */
    private String atpnQesitm;

    /**
    * 이 약을 사용하는 동안 주의해야 할 약 또는 음식은 무엇입니까?
    */
    private String intrcQesitm;

    /**
    * 이 약은 어떤 이상반응이 나타날 수 있습니까?
    */
    private String seQesitm;

    /**
    * 이 약은 어떻게 보관해야 합니까?
    */
    private String depositMethodQesitm;

    /**
    * 공개일자
    */
    private String openDe;

    /**
    * 수정일자
    */
    private String updateDe;

    /**
    * 응답데이터 형식(xml/json) Default:xml
    */
    private String type;

    // Getters and Setters
    public String getServiceKey() {
    return ServiceKey;
    }

    public void setServiceKey(String ServiceKey) {
    this.ServiceKey = ServiceKey;
    }

    public String getPageNo() {
    return pageNo;
    }

    public void setPageNo(String pageNo) {
    this.pageNo = pageNo;
    }

    public String getNumOfRows() {
    return numOfRows;
    }

    public void setNumOfRows(String numOfRows) {
    this.numOfRows = numOfRows;
    }

    public String getEntpName() {
    return entpName;
    }

    public void setEntpName(String entpName) {
    this.entpName = entpName;
    }

    public String getItemName() {
    return itemName;
    }

    public void setItemName(String itemName) {
    this.itemName = itemName;
    }

    public String getItemSeq() {
    return itemSeq;
    }

    public void setItemSeq(String itemSeq) {
    this.itemSeq = itemSeq;
    }

    public String getEfcyQesitm() {
    return efcyQesitm;
    }

    public void setEfcyQesitm(String efcyQesitm) {
    this.efcyQesitm = efcyQesitm;
    }

    public String getUseMethodQesitm() {
    return useMethodQesitm;
    }

    public void setUseMethodQesitm(String useMethodQesitm) {
    this.useMethodQesitm = useMethodQesitm;
    }

    public String getAtpnWarnQesitm() {
    return atpnWarnQesitm;
    }

    public void setAtpnWarnQesitm(String atpnWarnQesitm) {
    this.atpnWarnQesitm = atpnWarnQesitm;
    }

    public String getAtpnQesitm() {
    return atpnQesitm;
    }

    public void setAtpnQesitm(String atpnQesitm) {
    this.atpnQesitm = atpnQesitm;
    }

    public String getIntrcQesitm() {
    return intrcQesitm;
    }

    public void setIntrcQesitm(String intrcQesitm) {
    this.intrcQesitm = intrcQesitm;
    }

    public String getSeQesitm() {
    return seQesitm;
    }

    public void setSeQesitm(String seQesitm) {
    this.seQesitm = seQesitm;
    }

    public String getDepositMethodQesitm() {
    return depositMethodQesitm;
    }

    public void setDepositMethodQesitm(String depositMethodQesitm) {
    this.depositMethodQesitm = depositMethodQesitm;
    }

    public String getOpenDe() {
    return openDe;
    }

    public void setOpenDe(String openDe) {
    this.openDe = openDe;
    }

    public String getUpdateDe() {
    return updateDe;
    }

    public void setUpdateDe(String updateDe) {
    this.updateDe = updateDe;
    }

    public String getType() {
    return type;
    }

    public void setType(String type) {
    this.type = type;
    }

}