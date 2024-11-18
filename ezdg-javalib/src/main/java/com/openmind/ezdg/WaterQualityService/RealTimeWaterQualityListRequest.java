package com.openmind.ezdg.WaterQualityService;

public class RealTimeWaterQualityListRequest {
    /**
    * 공공데이터포털에서 받은 인증키
    */
    private String ServiceKey;

    /**
    * 페이지번호 (기본 값 : 1)
    */
    private String pageNo;

    /**
    * 한 페이지 결과 수 (기본 값 : 10)
    */
    private String numOfRows;

    /**
    * 결과형식 ( XML/JSON )
    */
    private String resultType;

    /**
    * 측정소 다건 조회 가능. 측정소 코드는 실시간수질_코드-코드명 엑셀파일 참조
    */
    private String siteId;

    /**
    * yyyyMMddHHmmss 형식으로 14자리가 들어가며 시는 24시형태로 표시 (startDate와 endDate는 같이 쓰여야 함)
    */
    private String startDate;

    /**
    * yyyyMMddHHmmss 형식으로 14자리가 들어가며 시는 24시형태로 표시 (startDate와 endDate는 같이 쓰여야 함)
    */
    private String endDate;

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

    public String getSiteId() {
    return siteId;
    }

    public void setSiteId(String siteId) {
    this.siteId = siteId;
    }

    public String getStartDate() {
    return startDate;
    }

    public void setStartDate(String startDate) {
    this.startDate = startDate;
    }

    public String getEndDate() {
    return endDate;
    }

    public void setEndDate(String endDate) {
    this.endDate = endDate;
    }

}