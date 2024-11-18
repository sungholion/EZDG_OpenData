package com.openmind.ezdg.WaterQualityService;

public class WaterMeasuringListRequest {
    /**
    * 공공데이터포털에서 받은 인증키
    */
    private String ServiceKey;

    /**
    * 페이지 번호 (기본 값 : 1)
    */
    private String pageNo;

    /**
    * 페이지 크기 (기본 값 : 10)
    */
    private String numOfRows;

    /**
    * 결과형식(XML/JSON)
    */
    private String resultType;

    /**
    * 측정소 다건 검색시 콤마(,) 로 구분 (예시 : ptNoList=3008A40,2012F50 ) 물환경_코드_코드명 엑셀 파일 참조
    */
    private String ptNoList;

    /**
    * 측정년도 다건 검색시 콤마(,)로 구분 (예시 : wmyrList=2012,2013)
    */
    private String wmyrList;

    /**
    * 측정월 다건 검색시 콤마(,)로 구분 (예시 : wmodList=01,02,03) (1~9월까지는 ‘01’~’09’로 표시).
    */
    private String wmodList;

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

    public String getWmyrList() {
    return wmyrList;
    }

    public void setWmyrList(String wmyrList) {
    this.wmyrList = wmyrList;
    }

    public String getWmodList() {
    return wmodList;
    }

    public void setWmodList(String wmodList) {
    this.wmodList = wmodList;
    }

}