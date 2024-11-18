package com.openmind.ezdg.PubDataOpnStdService;

public class DataSetOpnStdCntrctInfoRequest {
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
    * 오픈API 리턴 타입을 JSON으로 받고 싶을 경우 'json' 으로 지정
    */
    private String type;

    /**
    * 검색하고자하는 계약체결일자 시작 'YYYYMMDD' (계약체결일자 범위는 1개월 로 제한)
    */
    private String cntrctCnclsBgnDate;

    /**
    * 검색하고자하는 계약체결일자 종료 'YYYYMMDD' (계약체결일자 범위는 1개월 로 제한)
    */
    private String cntrctCnclsEndDate;

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

    public String getType() {
    return type;
    }

    public void setType(String type) {
    this.type = type;
    }

    public String getCntrctCnclsBgnDate() {
    return cntrctCnclsBgnDate;
    }

    public void setCntrctCnclsBgnDate(String cntrctCnclsBgnDate) {
    this.cntrctCnclsBgnDate = cntrctCnclsBgnDate;
    }

    public String getCntrctCnclsEndDate() {
    return cntrctCnclsEndDate;
    }

    public void setCntrctCnclsEndDate(String cntrctCnclsEndDate) {
    this.cntrctCnclsEndDate = cntrctCnclsEndDate;
    }

}