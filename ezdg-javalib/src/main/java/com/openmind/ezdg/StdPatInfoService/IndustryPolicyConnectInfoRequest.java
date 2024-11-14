package com.openmind.ezdg.StdPatInfoService;

public class IndustryPolicyConnectInfoRequest {
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
    * 시작 선언일자(8자리)
    */
    private String startdeclaredate;

    /**
    * 종료 선언일자(8자리)
    */
    private String enddeclaredate;

    /**
    * Kipris 제품분류
    */
    private String productclass;

    /**
    * Kipris 제품명칭
    */
    private String producttitle;

    /**
    * Kipris KSIC산업분류
    */
    private String industryclass;

    /**
    * KSIC산업분류명칭
    */
    private String industrytitle;

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

    public String getProductclass() {
    return productclass;
    }

    public void setProductclass(String productclass) {
    this.productclass = productclass;
    }

    public String getProducttitle() {
    return producttitle;
    }

    public void setProducttitle(String producttitle) {
    this.producttitle = producttitle;
    }

    public String getIndustryclass() {
    return industryclass;
    }

    public void setIndustryclass(String industryclass) {
    this.industryclass = industryclass;
    }

    public String getIndustrytitle() {
    return industrytitle;
    }

    public void setIndustrytitle(String industrytitle) {
    this.industrytitle = industrytitle;
    }

}