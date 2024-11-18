package com.openmind.ezdg.WaterQualityService;

public class SgisDrinkWaterListRequest {
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
    * 결과형식(XML/JSON)
    */
    private String resultType;

    /**
    * 복수년도 검색시 콤마(,)로 구분 (예시 : yyyy=2012,2013)
    */
    private String yyyy;

    /**
    * 시도 명칭
    */
    private String sido;

    /**
    * 1/4 , 2/4 , 3/4 , 4/4
    */
    private String period;

    /**
    * 시군구 명칭
    */
    private String sgg;

    /**
    * 복수지점코드 검색시 콤마(,)로 구분(예시 : legacyCodeNo=PUB_2969,PUB_2970) 먹는물_코드-코드명 엑셀 파일 참조
    */
    private String legacyCodeNo;

    /**
    * 지점명
    */
    private String spotNm;

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

    public String getResultType() {
    return resultType;
    }

    public void setResultType(String resultType) {
    this.resultType = resultType;
    }

    public String getYyyy() {
    return yyyy;
    }

    public void setYyyy(String yyyy) {
    this.yyyy = yyyy;
    }

    public String getSido() {
    return sido;
    }

    public void setSido(String sido) {
    this.sido = sido;
    }

    public String getPeriod() {
    return period;
    }

    public void setPeriod(String period) {
    this.period = period;
    }

    public String getSgg() {
    return sgg;
    }

    public void setSgg(String sgg) {
    this.sgg = sgg;
    }

    public String getLegacyCodeNo() {
    return legacyCodeNo;
    }

    public void setLegacyCodeNo(String legacyCodeNo) {
    this.legacyCodeNo = legacyCodeNo;
    }

    public String getSpotNm() {
    return spotNm;
    }

    public void setSpotNm(String spotNm) {
    this.spotNm = spotNm;
    }

}