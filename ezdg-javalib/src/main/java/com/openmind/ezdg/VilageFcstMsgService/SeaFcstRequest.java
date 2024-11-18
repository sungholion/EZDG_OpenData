package com.openmind.ezdg.VilageFcstMsgService;

public class SeaFcstRequest {
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
    * 요청자료형식(XML/JSON)Default: XML
    */
    private String dataType;

    /**
    * 12A20100 (서해중부앞바다),  12B20100(남해동부앞바다) 등... 별첨 엑셀자료 참조(‘해상’ 구분 값 참고)
    */
    private String regId;

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

    public String getRegId() {
    return regId;
    }

    public void setRegId(String regId) {
    this.regId = regId;
    }

}