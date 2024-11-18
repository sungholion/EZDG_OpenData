package com.openmind.ezdg.ArpltnStatsSvc;

public class CtprvnMesureSidoLIstRequest {
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
    * 시도 이름
    */
    private String sidoName;

    /**
    * 요청 데이터기간
    */
    private String searchCondition;

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

    public String getSidoName() {
    return sidoName;
    }

    public void setSidoName(String sidoName) {
    this.sidoName = sidoName;
    }

    public String getSearchCondition() {
    return searchCondition;
    }

    public void setSearchCondition(String searchCondition) {
    this.searchCondition = searchCondition;
    }

}