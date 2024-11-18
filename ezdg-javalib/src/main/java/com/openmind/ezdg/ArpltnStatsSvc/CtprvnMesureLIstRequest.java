package com.openmind.ezdg.ArpltnStatsSvc;

public class CtprvnMesureLIstRequest {
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
    * 측정항목 구분(SO2, CO, O3, NO2, PM10, PM2.5)
    */
    private String itemCode;

    /**
    * 요청 자료 구분(시간평균: HOUR, 일평균: DAILY)
    */
    private String dataGubun;

    /**
    * 요청 데이터 기간(일주일: WEEK, 한달: MONTH)
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

    public String getItemCode() {
    return itemCode;
    }

    public void setItemCode(String itemCode) {
    this.itemCode = itemCode;
    }

    public String getDataGubun() {
    return dataGubun;
    }

    public void setDataGubun(String dataGubun) {
    this.dataGubun = dataGubun;
    }

    public String getSearchCondition() {
    return searchCondition;
    }

    public void setSearchCondition(String searchCondition) {
    this.searchCondition = searchCondition;
    }

}