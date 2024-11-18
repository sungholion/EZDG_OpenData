package com.openmind.ezdg.AsosHourlyInfoService;

public class WthrDataListRequest {
    /**
    * 공공데이터포털에서 받은 인증키
    */
    private String ServiceKey;

    /**
    * 페이지번호 Default : 10
    */
    private String pageNo;

    /**
    * 한 페이지 결과 수 Default : 1
    */
    private String numOfRows;

    /**
    * 요청자료형식(XML/JSON) Default : XML
    */
    private String dataType;

    /**
    * 자료 분류 코드(ASOS)
    */
    private String dataCd;

    /**
    * 날짜 분류 코드(HR)
    */
    private String dateCd;

    /**
    * 조회 기간 시작일(YYYYMMDD)
    */
    private String startDt;

    /**
    * 조회 기간 시작시(HH)
    */
    private String startHh;

    /**
    * 조회 기간 종료일(YYYYMMDD) (전일(D-1) 까지 제공)
    */
    private String endDt;

    /**
    * 조회 기간 종료시(HH)
    */
    private String endHh;

    /**
    * 종관기상관측 지점 번호 (활용가이드 하단 첨부 참조)
    */
    private String stnIds;

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

    public String getDataCd() {
    return dataCd;
    }

    public void setDataCd(String dataCd) {
    this.dataCd = dataCd;
    }

    public String getDateCd() {
    return dateCd;
    }

    public void setDateCd(String dateCd) {
    this.dateCd = dateCd;
    }

    public String getStartDt() {
    return startDt;
    }

    public void setStartDt(String startDt) {
    this.startDt = startDt;
    }

    public String getStartHh() {
    return startHh;
    }

    public void setStartHh(String startHh) {
    this.startHh = startHh;
    }

    public String getEndDt() {
    return endDt;
    }

    public void setEndDt(String endDt) {
    this.endDt = endDt;
    }

    public String getEndHh() {
    return endHh;
    }

    public void setEndHh(String endHh) {
    this.endHh = endHh;
    }

    public String getStnIds() {
    return stnIds;
    }

    public void setStnIds(String stnIds) {
    this.stnIds = stnIds;
    }

}