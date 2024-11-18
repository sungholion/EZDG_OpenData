package com.openmind.ezdg.ArpltnInforInqireSvc;

public class MinuDustFrcstDspthRequest {
    /**
    * 공공데이터포털에서 받은 인증키
    */
    private String serviceKey;

    /**
    * xml 또는 json
    */
    private String returnType;

    /**
    * 한 페이지 결과 수(조회 날짜로 검색 시 사용 안함)
    */
    private String numOfRows;

    /**
    * 페이지번호(조회 날짜로 검색 시 사용 안함)
    */
    private String pageNo;

    /**
    * 통보시간 검색(조회 날짜 입력이 없을 경우 한달동안 예보통보 발령 날짜의 리스트 정보를 확인)
    */
    private String searchDate;

    /**
    * 통보코드검색(PM10, PM25, O3)
    */
    private String InformCode;

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

    public String getSearchDate() {
    return searchDate;
    }

    public void setSearchDate(String searchDate) {
    this.searchDate = searchDate;
    }

    public String getInformCode() {
    return InformCode;
    }

    public void setInformCode(String InformCode) {
    this.InformCode = InformCode;
    }

}