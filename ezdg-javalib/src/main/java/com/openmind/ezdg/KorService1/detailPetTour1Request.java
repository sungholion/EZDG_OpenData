package com.openmind.ezdg.KorService1;

public class detailPetTour1Request {
    /**
    * 공공데이터포털에서 받은 인증키
    */
    private String serviceKey;

    /**
    * 페이지번호
    */
    private Number pageNo;

    /**
    * 한 페이지 결과 수
    */
    private Number numOfRows;

    /**
    * OS 구분(IOS (아이폰), AND (안드로이드), WIN (윈도우폰), ETC)
    */
    private String MobileOS;

    /**
    * 서비스명
    */
    private String MobileApp;

    /**
    * 콘텐츠ID(옵션,미기입시 전체목록조회)
    */
    private String contentId;

    /**
    * 응답메세지 형식 : REST방식의 URL호출 시 json값 추가(디폴트 응답메세지 형식은XML)
    */
    private String _type;

    // Getters and Setters
    public String getServiceKey() {
    return serviceKey;
    }

    public void setServiceKey(String serviceKey) {
    this.serviceKey = serviceKey;
    }

    public Number getPageNo() {
    return pageNo;
    }

    public void setPageNo(Number pageNo) {
    this.pageNo = pageNo;
    }

    public Number getNumOfRows() {
    return numOfRows;
    }

    public void setNumOfRows(Number numOfRows) {
    this.numOfRows = numOfRows;
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

    public String getContentId() {
    return contentId;
    }

    public void setContentId(String contentId) {
    this.contentId = contentId;
    }

    public String get_type() {
    return _type;
    }

    public void set_type(String _type) {
    this._type = _type;
    }

}