package com.openmind.ezdg.MetalMeasuringResultService;

public class MetalServiceRequest {
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
    * 결과형식(XML/JSON)
    */
    private String resultType;

    /**
    * 검색조건 날짜 (예시 : 20171208)
    */
    private String date;

    /**
    * 검색조건 측정소코드
    */
    private String stationcode;

    /**
    * 검색조건 항목코드
    */
    private String itemcode;

    /**
    * 검색조건 시간구분
    */
    private String timecode;

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

    public String getDate() {
    return date;
    }

    public void setDate(String date) {
    this.date = date;
    }

    public String getStationcode() {
    return stationcode;
    }

    public void setStationcode(String stationcode) {
    this.stationcode = stationcode;
    }

    public String getItemcode() {
    return itemcode;
    }

    public void setItemcode(String itemcode) {
    this.itemcode = itemcode;
    }

    public String getTimecode() {
    return timecode;
    }

    public void setTimecode(String timecode) {
    this.timecode = timecode;
    }

}