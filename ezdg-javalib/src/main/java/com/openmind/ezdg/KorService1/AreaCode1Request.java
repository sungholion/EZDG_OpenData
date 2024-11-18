package com.openmind.ezdg.KorService1;

public class AreaCode1Request {
    /**
    * 한페이지결과수
    */
    private Number numOfRows;

    /**
    * 페이지번호
    */
    private Number pageNo;

    /**
    * OS 구분 : IOS (아이폰), AND (안드로이드), WIN (윈도우폰), ETC(기타)
    */
    private String MobileOS;

    /**
    * 서비스명(어플명)
    */
    private String MobileApp;

    /**
    * 지역코드
    */
    private String areaCode;

    /**
    * 응답메세지 형식 : REST방식의 URL호출 시 json값 추가(디폴트 응답메세지 형식은XML)
    */
    private String _type;

    /**
    * 인증키(서비스키)
    */
    private String serviceKey;

    // Getters and Setters
    public Number getNumOfRows() {
    return numOfRows;
    }

    public void setNumOfRows(Number numOfRows) {
    this.numOfRows = numOfRows;
    }

    public Number getPageNo() {
    return pageNo;
    }

    public void setPageNo(Number pageNo) {
    this.pageNo = pageNo;
    }

    public String getMobileOS() {
    return MobileOS;
    }

    public void setMobileOS(String MobileOS) {
    this.MobileOS = MobileOS;
    }

    public String getMobileApp() {
    return MobileApp;
    }

    public void setMobileApp(String MobileApp) {
    this.MobileApp = MobileApp;
    }

    public String getAreaCode() {
    return areaCode;
    }

    public void setAreaCode(String areaCode) {
    this.areaCode = areaCode;
    }

    public String get_type() {
    return _type;
    }

    public void set_type(String _type) {
    this._type = _type;
    }

    public String getServiceKey() {
    return serviceKey;
    }

    public void setServiceKey(String serviceKey) {
    this.serviceKey = serviceKey;
    }

}