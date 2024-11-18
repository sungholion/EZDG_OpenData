package com.openmind.ezdg.ArpltnStatsSvc;

public class MsrstnAcctoRMmrgRequest {
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
    * 조회시작월
    */
    private String inqBginMm;

    /**
    * 조회종료월
    */
    private String inqEndMm;

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

    public String getInqBginMm() {
    return inqBginMm;
    }

    public void setInqBginMm(String inqBginMm) {
    this.inqBginMm = inqBginMm;
    }

    public String getInqEndMm() {
    return inqEndMm;
    }

    public void setInqEndMm(String inqEndMm) {
    this.inqEndMm = inqEndMm;
    }

    public String getMsrstnName() {
    return msrstnName;
    }

    public void setMsrstnName(String msrstnName) {
    this.msrstnName = msrstnName;
    }

}