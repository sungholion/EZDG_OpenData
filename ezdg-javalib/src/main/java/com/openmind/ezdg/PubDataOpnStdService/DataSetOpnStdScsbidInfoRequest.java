package com.openmind.ezdg.PubDataOpnStdService;

public class DataSetOpnStdScsbidInfoRequest {
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
    * 업무구분코드가 1이면 물품, 2면 외자, 3이면 공사, 5면 용역
    */
    private String bsnsDivCd;

    /**
    * 검색하고자하는 개찰일시범위 시작 'YYYYMMDDHHMM' (개찰일시 범위는 1주일로 제한)
    */
    private String opengBgnDt;

    /**
    * 검색하고자하는 개찰일시범위 종료 'YYYYMMDDHHMM' (개찰일시 범위는 1주일로 제한)
    */
    private String opengEndDt;

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

    public String getBsnsDivCd() {
    return bsnsDivCd;
    }

    public void setBsnsDivCd(String bsnsDivCd) {
    this.bsnsDivCd = bsnsDivCd;
    }

    public String getOpengBgnDt() {
    return opengBgnDt;
    }

    public void setOpengBgnDt(String opengBgnDt) {
    this.opengBgnDt = opengBgnDt;
    }

    public String getOpengEndDt() {
    return opengEndDt;
    }

    public void setOpengEndDt(String opengEndDt) {
    this.opengEndDt = opengEndDt;
    }

}