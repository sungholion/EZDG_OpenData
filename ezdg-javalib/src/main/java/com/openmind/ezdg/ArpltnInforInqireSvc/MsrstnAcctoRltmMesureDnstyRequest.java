package com.openmind.ezdg.ArpltnInforInqireSvc;

public class MsrstnAcctoRltmMesureDnstyRequest {
    /**
    * 공공데이터포털에서 받은 인증키
    */
    private String serviceKey;

    /**
    * xml 또는 json
    */
    private String returnType;

    /**
    * 한 페이지 결과 수
    */
    private String numOfRows;

    /**
    * 페이지번호
    */
    private String pageNo;

    /**
    * 측정소 이름
    */
    private String stationName;

    /**
    * 요청 데이터기간(1일: DAILY, 1개월: MONTH, 3개월: 3MONTH)
    */
    private String dataTerm;

    /**
    * 버전별 상세 결과 참고
    */
    private String ver;

    // Getters and Setters
    public String getServiceKey() {
    return serviceKey;
    }

    public void setServiceKey(String serviceKey) {
    this.serviceKey = serviceKey;
    }

    public String getReturnType() {
    return returnType;
    }

    public void setReturnType(String returnType) {
    this.returnType = returnType;
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

    public String getStationName() {
    return stationName;
    }

    public void setStationName(String stationName) {
    this.stationName = stationName;
    }

    public String getDataTerm() {
    return dataTerm;
    }

    public void setDataTerm(String dataTerm) {
    this.dataTerm = dataTerm;
    }

    public String getVer() {
    return ver;
    }

    public void setVer(String ver) {
    this.ver = ver;
    }

}