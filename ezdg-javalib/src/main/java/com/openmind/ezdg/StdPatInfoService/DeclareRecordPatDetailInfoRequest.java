package com.openmind.ezdg.StdPatInfoService;

public class DeclareRecordPatDetailInfoRequest {
    /**
    * 한 페이지 결과 수
    */
    private String numOfRows;

    /**
    * 3
    */
    private String pageNo;

    /**
    * XML/JSON
    */
    private String resultType;

    /**
    * 특허번호_원본
    */
    private String patno_org;

    /**
    * 종료 선언일자(8자리)
    */
    private String startdeclaredate;

    /**
    * 종료 선언일자(8자리)
    */
    private String enddeclaredate;

    /**
    * Kipris 출원번호
    */
    private String appno;

    /**
    * Kipris공개번호
    */
    private String publicno;

    /**
    * Kipiris 등록번호
    */
    private String regno;

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

    public String getPatno_org() {
    return patno_org;
    }

    public void setPatno_org(String patno_org) {
    this.patno_org = patno_org;
    }

    public String getStartdeclaredate() {
    return startdeclaredate;
    }

    public void setStartdeclaredate(String startdeclaredate) {
    this.startdeclaredate = startdeclaredate;
    }

    public String getEnddeclaredate() {
    return enddeclaredate;
    }

    public void setEnddeclaredate(String enddeclaredate) {
    this.enddeclaredate = enddeclaredate;
    }

    public String getAppno() {
    return appno;
    }

    public void setAppno(String appno) {
    this.appno = appno;
    }

    public String getPublicno() {
    return publicno;
    }

    public void setPublicno(String publicno) {
    this.publicno = publicno;
    }

    public String getRegno() {
    return regno;
    }

    public void setRegno(String regno) {
    this.regno = regno;
    }

}