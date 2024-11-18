package com.openmind.ezdg.RoadWthrInfoService;

public class StdNodeLinkRoadWwRequest {
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
    * 요청자료형식(XML/JSON)
    */
    private String dataType;

    /**
    * 표준노드링크 ID
    */
    private String stdLinkId;

    /**
    * 최근 결과 시간
    */
    private String hhCode;

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

    public String getDataType() {
    return dataType;
    }

    public void setDataType(String dataType) {
    this.dataType = dataType;
    }

    public String getStdLinkId() {
    return stdLinkId;
    }

    public void setStdLinkId(String stdLinkId) {
    this.stdLinkId = stdLinkId;
    }

    public String getHhCode() {
    return hhCode;
    }

    public void setHhCode(String hhCode) {
    this.hhCode = hhCode;
    }

}