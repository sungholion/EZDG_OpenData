package com.openmind.ezdg.StdPatInfoService;

public class StdNoDeclareRecordPatInfoRequest {
    /**
    * 한 페이지 결과 수(기본 값 : 10, 최대 값 : 1000)
    */
    private String numOfRows;

    /**
    * 페이지 번호 ( 기본 값 : 1 )
    */
    private String pageNo;

    /**
    * 결과형식 ( XML/JSON, 기본 값 : xml )
    */
    private String resultType;

    /**
    * 표준기구코드
    */
    private String stdorgancd;

    /**
    * 선언자국가_정비
    */
    private String declarercountry_adjust;

    /**
    * 표준번호
    */
    private String stdno;

    /**
    * 검색시작_선언일자
    */
    private String startdeclaredate;

    /**
    * 검색종료_선언일자
    */
    private String enddeclaredate;

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

    public String getStdorgancd() {
    return stdorgancd;
    }

    public void setStdorgancd(String stdorgancd) {
    this.stdorgancd = stdorgancd;
    }

    public String getDeclarercountry_adjust() {
    return declarercountry_adjust;
    }

    public void setDeclarercountry_adjust(String declarercountry_adjust) {
    this.declarercountry_adjust = declarercountry_adjust;
    }

    public String getStdno() {
    return stdno;
    }

    public void setStdno(String stdno) {
    this.stdno = stdno;
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

}