package com.openmind.ezdg.WaterQualityService;

public class RadioActiveMaterListRequest {
    /**
    * 서비스 키
    */
    private String ServiceKey;

    /**
    * 페이지 번호 (기본 값 : 1)
    */
    private String pageNo;

    /**
    * 한 페이지 결과 수 (기본 값 : 10)
    */
    private String numOfRows;

    /**
    * 결과형식(XML/JSON)
    */
    private String resultType;

    /**
    * 측정소 다건 검색시 콤마(,) 로 구분 (예시 : ptNoList=1003A05,1003A74 ) 물환경_코드_코드명 엑셀 파일 참조
    */
    private String ptNoList;

    /**
    * 검색조건 시작연도
    */
    private String from_wmyr;

    /**
    * 검색조건 종료연도
    */
    private String to_wmyr;

    /**
    * 검색조건 시작회차
    */
    private String from_wmwk;

    /**
    * 검색조건 종료회차
    */
    private String to_wmwk;

    /**
    * 측정년도 다건 검색시 콤마(,)로 구분 (예시 : wmyrList=2014,2015)
    */
    private String wmyrList;

    /**
    * 측정회차 다건 검색시 콤마(,)로 구분 (예시 : wmwkList=1,2)
    */
    private String wmwkList;

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

    public String getPtNoList() {
    return ptNoList;
    }

    public void setPtNoList(String ptNoList) {
    this.ptNoList = ptNoList;
    }

    public String getFrom_wmyr() {
    return from_wmyr;
    }

    public void setFrom_wmyr(String from_wmyr) {
    this.from_wmyr = from_wmyr;
    }

    public String getTo_wmyr() {
    return to_wmyr;
    }

    public void setTo_wmyr(String to_wmyr) {
    this.to_wmyr = to_wmyr;
    }

    public String getFrom_wmwk() {
    return from_wmwk;
    }

    public void setFrom_wmwk(String from_wmwk) {
    this.from_wmwk = from_wmwk;
    }

    public String getTo_wmwk() {
    return to_wmwk;
    }

    public void setTo_wmwk(String to_wmwk) {
    this.to_wmwk = to_wmwk;
    }

    public String getWmyrList() {
    return wmyrList;
    }

    public void setWmyrList(String wmyrList) {
    this.wmyrList = wmyrList;
    }

    public String getWmwkList() {
    return wmwkList;
    }

    public void setWmwkList(String wmwkList) {
    this.wmwkList = wmwkList;
    }

}