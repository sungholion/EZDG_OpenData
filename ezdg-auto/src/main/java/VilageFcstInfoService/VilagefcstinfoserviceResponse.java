package VilageFcstInfoService;

public class VilagefcstinfoserviceResponse {
    /**
    * 결과코드
    */
    private Integer resultCode;
    /**
    * 결과메시지
    */
    private String resultMsg;
    /**
    * 한 페이지 결과 수
    */
    private Integer numOfRows;
    /**
    * 페이지번호
    */
    private Integer pageNo;
    /**
    * 전체 결과 수
    */
    private Integer totalCount;
    /**
    * 응답자료형식 (XML/JSON)
    */
    private String dataType;
    /**
    * ‘21년 6월 28일 발표
    */
    private String baseDate;
    /**
    * 06시 발표(매 정시)
    */
    private Integer baseTime;
    /**
    * 입력한 예보지점 X 좌표
    */
    private Integer nx;
    /**
    * 입력한 예보지점 Y 좌표
    */
    private Integer ny;
    /**
    * 자료구분코드
    */
    private String category;
    /**
    * RN1, T1H, UUU, VVV, WSD  실수로 제공
    */
    private Integer obsrValue;

    public Integer getResultCode() {
    return resultCode;
    }

    public void setResultCode(Integer resultCode) {
    this.resultCode = resultCode;
    }
    public String getResultMsg() {
    return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
    this.resultMsg = resultMsg;
    }
    public Integer getNumOfRows() {
    return numOfRows;
    }

    public void setNumOfRows(Integer numOfRows) {
    this.numOfRows = numOfRows;
    }
    public Integer getPageNo() {
    return pageNo;
    }

    public void setPageNo(Integer pageNo) {
    this.pageNo = pageNo;
    }
    public Integer getTotalCount() {
    return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
    }
    public String getDataType() {
    return dataType;
    }

    public void setDataType(String dataType) {
    this.dataType = dataType;
    }
    public String getBaseDate() {
    return baseDate;
    }

    public void setBaseDate(String baseDate) {
    this.baseDate = baseDate;
    }
    public Integer getBaseTime() {
    return baseTime;
    }

    public void setBaseTime(Integer baseTime) {
    this.baseTime = baseTime;
    }
    public Integer getNx() {
    return nx;
    }

    public void setNx(Integer nx) {
    this.nx = nx;
    }
    public Integer getNy() {
    return ny;
    }

    public void setNy(Integer ny) {
    this.ny = ny;
    }
    public String getCategory() {
    return category;
    }

    public void setCategory(String category) {
    this.category = category;
    }
    public Integer getObsrValue() {
    return obsrValue;
    }

    public void setObsrValue(Integer obsrValue) {
    this.obsrValue = obsrValue;
    }
}
