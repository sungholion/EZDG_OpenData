package com.openmind.ezdg.GetCorpBasicInfoService;

public class AffiliateRequest {
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
    * 결과형식(xml/json)
    */
    private String resultType;

    /**
    * 작업 또는 거래의 기준이 되는 일자(년월일)
    */
    private String basDt;

    /**
    * 법인등록번호
    */
    private String crno;

    /**
    * 계열 회사의 이름
    */
    private String afilCmpyNm;

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

    public String getBasDt() {
    return basDt;
    }

    public void setBasDt(String basDt) {
    this.basDt = basDt;
    }

    public String getCrno() {
    return crno;
    }

    public void setCrno(String crno) {
    this.crno = crno;
    }

    public String getAfilCmpyNm() {
    return afilCmpyNm;
    }

    public void setAfilCmpyNm(String afilCmpyNm) {
    this.afilCmpyNm = afilCmpyNm;
    }

}