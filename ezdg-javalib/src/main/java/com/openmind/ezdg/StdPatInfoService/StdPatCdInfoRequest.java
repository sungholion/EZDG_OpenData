package com.openmind.ezdg.StdPatInfoService;

public class StdPatCdInfoRequest {
    /**
    * 한 페이지 결과 수
    */
    private String numOfRows;

    /**
    * 페이지번호
    */
    private String pageNo;

    /**
    * XML/JSON
    */
    private String resultType;

    /**
    * 코드
    */
    private String cd;

    /**
    * 코드 분류
    */
    private String cdclass;

    /**
    * 코드세부명칭
    */
    private String cdtitle;

    // Getters and Setters
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

    public String getResultType() {
    return resultType;
    }

    public void setResultType(String resultType) {
    this.resultType = resultType;
    }

    public String getCd() {
    return cd;
    }

    public void setCd(String cd) {
    this.cd = cd;
    }

    public String getCdclass() {
    return cdclass;
    }

    public void setCdclass(String cdclass) {
    this.cdclass = cdclass;
    }

    public String getCdtitle() {
    return cdtitle;
    }

    public void setCdtitle(String cdtitle) {
    this.cdtitle = cdtitle;
    }

}