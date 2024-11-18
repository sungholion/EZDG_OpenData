package com.openmind.ezdg.BeachInfoservice;

public class TwBuoyBeachRequest {
    /**
    * 공공데이터포털에서 받은 인증키
    */
    private String serviceKey;

    /**
    * 한 페이지 결과 수
    */
    private String numOfRows;

    /**
    * 페이지번호
    */
    private String pageNo;

    /**
    * 응답자료형식
    */
    private String dataType;

    /**
    * 해변코드
    */
    private String beach_num;

    /**
    * 관측시간(년월일시분)
    */
    private String searchTime;

    // Getters and Setters
    public String getServiceKey() {
    return serviceKey;
    }

    public void setServiceKey(String serviceKey) {
    this.serviceKey = serviceKey;
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

    public String getDataType() {
    return dataType;
    }

    public void setDataType(String dataType) {
    this.dataType = dataType;
    }

    public String getBeach_num() {
    return beach_num;
    }

    public void setBeach_num(String beach_num) {
    this.beach_num = beach_num;
    }

    public String getSearchTime() {
    return searchTime;
    }

    public void setSearchTime(String searchTime) {
    this.searchTime = searchTime;
    }

}