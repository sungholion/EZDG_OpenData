package com.openmind.ezdg.VilageFcstInfoService;

public class UltraSrtFcstRequest {
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
    * 요청자료형식(XML/JSON) Default: XML
    */
    private String dataType;

    /**
    * ‘21년 6월 28일 발표
    */
    private String base_date;

    /**
    * 06시30분 발표(30분 단위)
    */
    private String base_time;

    /**
    * 예보지점 X 좌표값
    */
    private String nx;

    /**
    * 예보지점 Y 좌표값
    */
    private String ny;

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

    public String getBase_date() {
    return base_date;
    }

    public void setBase_date(String base_date) {
    this.base_date = base_date;
    }

    public String getBase_time() {
    return base_time;
    }

    public void setBase_time(String base_time) {
    this.base_time = base_time;
    }

    public String getNx() {
    return nx;
    }

    public void setNx(String nx) {
    this.nx = nx;
    }

    public String getNy() {
    return ny;
    }

    public void setNy(String ny) {
    this.ny = ny;
    }

}