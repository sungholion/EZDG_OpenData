package com.openmind.ezdg.KorService1;

public class categoryCode1Request {
    /**
    * 한페이지결과수
    */
    private String numOfRows;

    /**
    * 페이지번호
    */
    private String pageNo;

    /**
    * OS 구분 : IOS (아이폰), AND (안드로이드), WIN (윈도우폰), ETC(기타)
    */
    private String MobileOS;

    /**
    * 서비스명(어플명)
    */
    private String MobileApp;

    /**
    * 관광타입(12:관광지, 14:문화시설, 15:축제공연행사, 25:여행코스, 28:레포츠, 32:숙박, 38:쇼핑, 39:음식점) ID
    */
    private String contentTypeId;

    /**
    * 대분류코드
    */
    private String cat1;

    /**
    * 중분류코드
    */
    private String cat2;

    /**
    * 소분류코드
    */
    private String cat3;

    /**
    * 응답메세지 형식 : REST방식의 URL호출 시 json값 추가(디폴트 응답메세지 형식은XML)
    */
    private String _type;

    /**
    * 인증키(서비스키)
    */
    private String serviceKey;

    // Getters and Setters
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

    public String getContentTypeId() {
    return contentTypeId;
    }

    public void setContentTypeId(String contentTypeId) {
    this.contentTypeId = contentTypeId;
    }

    public String getCat1() {
    return cat1;
    }

    public void setCat1(String cat1) {
    this.cat1 = cat1;
    }

    public String getCat2() {
    return cat2;
    }

    public void setCat2(String cat2) {
    this.cat2 = cat2;
    }

    public String getCat3() {
    return cat3;
    }

    public void setCat3(String cat3) {
    this.cat3 = cat3;
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