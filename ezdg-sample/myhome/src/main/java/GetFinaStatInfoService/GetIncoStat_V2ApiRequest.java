package GetFinaStatInfoService;

public class GetIncoStat_V2ApiRequest {
    /**
    * 공공데이터포털에서 받은 인증키
    */
    private String serviceKey;

    /**
    * 한 페이지 결과 수
    */
    private String numOfRows;

    /**
    * 페이지번호
    */
    private String pageNo;

    /**
    * 결과형식(xml/json)
    */
    private String resultType;

    /**
    * 법인등록번호
    */
    private String crno;

    /**
    * 법인에 대해 법령이 규정한 1회계기간으로서 법인세의 과세기간
    */
    private String bizYear;

// Getters and Setters
    public String getServiceKey() {
    return serviceKey;
    }

    public void setServiceKey(String serviceKey) {
    this.serviceKey = serviceKey;
    }

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

    public String getCrno() {
    return crno;
    }

    public void setCrno(String crno) {
    this.crno = crno;
    }

    public String getBizYear() {
    return bizYear;
    }

    public void setBizYear(String bizYear) {
    this.bizYear = bizYear;
    }

}