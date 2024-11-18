package com.openmind.ezdg.TourStnInfoService1;

public class CityTourClmIdxRequest {
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
    * 요청자료형식(XML/JSON)
    */
    private String dataType;

    /**
    * 2018-12-31 00시부터 조회
    */
    private String CURRENT_DATE;

    /**
    * CURRENT_DATE부터 입력값까지의 자료 호출
    */
    private String DAY;

    /**
    * 시군구 아이디
    */
    private String CITY_AREA_ID;

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

    public String getDataType() {
    return dataType;
    }

    public void setDataType(String dataType) {
    this.dataType = dataType;
    }

    public String getCURRENT_DATE() {
    return CURRENT_DATE;
    }

    public void setCURRENT_DATE(String CURRENT_DATE) {
    this.CURRENT_DATE = CURRENT_DATE;
    }

    public String getDAY() {
    return DAY;
    }

    public void setDAY(String DAY) {
    this.DAY = DAY;
    }

    public String getCITY_AREA_ID() {
    return CITY_AREA_ID;
    }

    public void setCITY_AREA_ID(String CITY_AREA_ID) {
    this.CITY_AREA_ID = CITY_AREA_ID;
    }

}