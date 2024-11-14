package com.openmind.ezdg.StdPatInfoService;

public class DeclarerDeclareRecordPatInfoRequest {
    /**
    * 한 페이지 결과 수
    */
    private String numOfRows;

    /**
    * 페이지번호( 기본 값 : 1 )
    */
    private String pageNo;

    /**
    * XML/JSON기본 값 : xml
    */
    private String resultType;

    /**
    * 선언자국가_정비
    */
    private String declarercountry_adjust;

    /**
    * 시작 선언일자(8자리)
    */
    private String startdeclaredate;

    /**
    * 종료 선언일자(8자리)
    */
    private String enddeclaredate;

    /**
    * OECD여부(Y/N)
    */
    private String oecdyn;

    /**
    * 클럽2050여부(Y/N)
    */
    private String club2050yn;

    /**
    * Kipris 출원인
    */
    private String applicant;

    /**
    * Kipris 발명인
    */
    private String inventor;

    /**
    * Kipris 발명명칭
    */
    private String inventtitle;

    /**
    * 선언자_정비
    */
    private String declarer_adjust;

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

    public String getDeclarercountry_adjust() {
    return declarercountry_adjust;
    }

    public void setDeclarercountry_adjust(String declarercountry_adjust) {
    this.declarercountry_adjust = declarercountry_adjust;
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

    public String getOecdyn() {
    return oecdyn;
    }

    public void setOecdyn(String oecdyn) {
    this.oecdyn = oecdyn;
    }

    public String getClub2050yn() {
    return club2050yn;
    }

    public void setClub2050yn(String club2050yn) {
    this.club2050yn = club2050yn;
    }

    public String getApplicant() {
    return applicant;
    }

    public void setApplicant(String applicant) {
    this.applicant = applicant;
    }

    public String getInventor() {
    return inventor;
    }

    public void setInventor(String inventor) {
    this.inventor = inventor;
    }

    public String getInventtitle() {
    return inventtitle;
    }

    public void setInventtitle(String inventtitle) {
    this.inventtitle = inventtitle;
    }

    public String getDeclarer_adjust() {
    return declarer_adjust;
    }

    public void setDeclarer_adjust(String declarer_adjust) {
    this.declarer_adjust = declarer_adjust;
    }

}