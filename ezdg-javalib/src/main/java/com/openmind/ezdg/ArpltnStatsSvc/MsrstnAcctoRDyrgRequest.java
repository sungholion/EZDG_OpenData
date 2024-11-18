package com.openmind.ezdg.ArpltnStatsSvc;

public class MsrstnAcctoRDyrgRequest {
    /**
    * 공공데이터포털에서 받은 인증키
    */
    private String serviceKey;

    /**
    * xml 또는 json
    */
    private String returnType;

    /**
    * 한 페이지 결과 수
    */
    private String numOfRows;

    /**
    * 페이지번호
    */
    private String pageNo;

    /**
    * 조회시작일자
    */
    private String inqBginDt;

    /**
    * 조회종료일자
    */
    private String inqEndDt;

    /**
    * 측정소명
    */
    private String msrstnName;

    // Getters and Setters
    public String getServiceKey() {
    return serviceKey;
    }

    public void setServiceKey(String serviceKey) {
    this.serviceKey = serviceKey;
    }

    public String getReturnType() {
    return returnType;
    }

    public void setReturnType(String returnType) {
    this.returnType = returnType;
    }

    public String getNumOfRows() {
    return numOfRows;
    }

    public void setNumOfRows(String numOfRows) {
    this.numOfRows = numOfRows;
    }

    public String getPageNo() {
    return pageNo;
    }

    public void setPageNo(String pageNo) {
    this.pageNo = pageNo;
    }

    public String getInqBginDt() {
    return inqBginDt;
    }

    public void setInqBginDt(String inqBginDt) {
    this.inqBginDt = inqBginDt;
    }

    public String getInqEndDt() {
    return inqEndDt;
    }

    public void setInqEndDt(String inqEndDt) {
    this.inqEndDt = inqEndDt;
    }

    public String getMsrstnName() {
    return msrstnName;
    }

    public void setMsrstnName(String msrstnName) {
    this.msrstnName = msrstnName;
    }

}