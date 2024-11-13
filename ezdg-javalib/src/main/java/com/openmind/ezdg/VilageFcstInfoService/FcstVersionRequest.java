package com.openmind.ezdg.VilageFcstInfoService;

public class FcstVersionRequest {
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
    * 요청자료형식(XML/JSON) Default: XML
    */
    private String dataType;

    /**
    * 파일구분 -ODAM: 동네예보실황 -VSRT: 동네예보초단기 -SHRT: 동네예보단기
    */
    private String ftype;

    /**
    * 각각의 base_time 로 검색
    */
    private String basedatetime;

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

    public String getFtype() {
    return ftype;
    }

    public void setFtype(String ftype) {
    this.ftype = ftype;
    }

    public String getBasedatetime() {
    return basedatetime;
    }

    public void setBasedatetime(String basedatetime) {
    this.basedatetime = basedatetime;
    }

}