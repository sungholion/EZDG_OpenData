package VilageFcstInfoService;

public class Vilagefcstinfoservice12Request {
    /**
    * 공공데이터포털에서 받은 인증키
    */
    private String serviceKey;

    /**
    * 페이지번호
    */
    private Integer pageNo;

    /**
    * 한 페이지 결과 수
    */
    private Integer numOfRows;

    /**
    * 요청자료형식(XML/JSON) Default: XML
    */
    private String dataType;

    /**
    * ‘21년 6월 28일 발표
    */
    private Integer base_date;

    /**
    * 06시 발표(정시단위)
    */
    private Integer base_time;

    /**
    * 예보지점의 X 좌표값
    */
    private Integer nx;

    /**
    * 예보지점의 Y 좌표값
    */
    private Integer ny;

// Getters and Setters
    public String getServiceKey() {
    return serviceKey;
    }

    public void setServiceKey(String serviceKey) {
    this.serviceKey = serviceKey;
    }

    public Integer getPageNo() {
    return pageNo;
    }

    public void setPageNo(Integer pageNo) {
    this.pageNo = pageNo;
    }

    public Integer getNumOfRows() {
    return numOfRows;
    }

    public void setNumOfRows(Integer numOfRows) {
    this.numOfRows = numOfRows;
    }

    public String getDataType() {
    return dataType;
    }

    public void setDataType(String dataType) {
    this.dataType = dataType;
    }

    public Integer getBase_date() {
    return base_date;
    }

    public void setBase_date(Integer base_date) {
    this.base_date = base_date;
    }

    public Integer getBase_time() {
    return base_time;
    }

    public void setBase_time(Integer base_time) {
    this.base_time = base_time;
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

}