package GetCorpBasicInfoService;

public class GetCorpOutline_V2ApiRequest {
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
    * 법인등록번호
    */
    private String crno;

    /**
    * 법인(法人)의 명칭
    */
    private String corpNm;

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

    public String getCrno() {
    return crno;
    }

    public void setCrno(String crno) {
    this.crno = crno;
    }

    public String getCorpNm() {
    return corpNm;
    }

    public void setCorpNm(String corpNm) {
    this.corpNm = corpNm;
    }

}