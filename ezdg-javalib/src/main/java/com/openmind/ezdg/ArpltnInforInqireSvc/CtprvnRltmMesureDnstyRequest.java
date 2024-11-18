package com.openmind.ezdg.ArpltnInforInqireSvc;

public class CtprvnRltmMesureDnstyRequest {
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
    * 시도 이름(전국, 서울, 부산, 대구, 인천, 광주, 대전, 울산, 경기, 강원, 충북, 충남, 전북, 전남, 경북, 경남, 제주, 세종)
    */
    private String sidoName;

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

    public String getSidoName() {
    return sidoName;
    }

    public void setSidoName(String sidoName) {
    this.sidoName = sidoName;
    }

    public String getVer() {
    return ver;
    }

    public void setVer(String ver) {
    this.ver = ver;
    }

}