package com.openmind.ezdg.PubDataOpnStdService;

public class DataSetOpnStdBidPblancInfoRequest {
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
    * 오픈API 리턴 타입을 JSON으로 받고 싶을 경우 'json' 으로 지정함
    */
    private String type;

    /**
    * 검색하고자하는 입찰공고일시범위 시작 'YYYYMMDDHHMM' (입찰공고일시 범위는 1개월 로 제한)
    */
    private String bidNtceBgnDt;

    /**
    * 검색하고자하는 입찰공고일시범위 종료 'YYYYMMDDHHMM'  (입찰공고일시 범위는 1개월 로 제한)
    */
    private String bidNtceEndDt;

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

    public String getType() {
    return type;
    }

    public void setType(String type) {
    this.type = type;
    }

    public String getBidNtceBgnDt() {
    return bidNtceBgnDt;
    }

    public void setBidNtceBgnDt(String bidNtceBgnDt) {
    this.bidNtceBgnDt = bidNtceBgnDt;
    }

    public String getBidNtceEndDt() {
    return bidNtceEndDt;
    }

    public void setBidNtceEndDt(String bidNtceEndDt) {
    this.bidNtceEndDt = bidNtceEndDt;
    }

}