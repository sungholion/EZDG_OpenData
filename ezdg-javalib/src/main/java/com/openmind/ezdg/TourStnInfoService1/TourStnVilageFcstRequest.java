package com.openmind.ezdg.TourStnInfoService1;

public class TourStnVilageFcstRequest {
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
    * 2016-12-01 01시부터 조회
    */
    private String CURRENT_DATE;

    /**
    * CURRENT_DATE부터 24시간 후까지의 자료 호출
    */
    private String HOUR;

    /**
    * 관광 코스ID
    */
    private String COURSE_ID;

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

    public String getHOUR() {
    return HOUR;
    }

    public void setHOUR(String HOUR) {
    this.HOUR = HOUR;
    }

    public String getCOURSE_ID() {
    return COURSE_ID;
    }

    public void setCOURSE_ID(String COURSE_ID) {
    this.COURSE_ID = COURSE_ID;
    }

}