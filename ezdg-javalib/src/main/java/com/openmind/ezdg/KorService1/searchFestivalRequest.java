package com.openmind.ezdg.KorService1;

public class searchFestivalRequest {
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
    * 응답메세지 형식 : REST방식의 URL호출 시 json값 추가(디폴트 응답메세지 형식은XML)
    */
    private String _type;

    /**
    * 목록구분(Y=목록, N=개수)
    */
    private String listYN;

    /**
    * 정렬구분 (A=제목순, C=수정일순, D=생성일순) 대표이미지가반드시있는정렬(O=제목순, Q=수정일순, R=생성일순)
    */
    private String arrange;

    /**
    * 행사시작일(형식 :YYYYMMDD)
    */
    private String eventStartDate;

    /**
    * 행사종료일(형식 :YYYYMMDD)
    */
    private String eventEndDate;

    /**
    * 지역코드(지역코드조회 참고)
    */
    private String areaCode;

    /**
    * 시군구코드(지역코드조회 참고)
    */
    private String sigunguCode;

    /**
    * 수정일(형식 :YYYYMMDD)
    */
    private String modifiedtime;

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

    public String get_type() {
    return _type;
    }

    public void set_type(String _type) {
    this._type = _type;
    }

    public String getListYN() {
    return listYN;
    }

    public void setListYN(String listYN) {
    this.listYN = listYN;
    }

    public String getArrange() {
    return arrange;
    }

    public void setArrange(String arrange) {
    this.arrange = arrange;
    }

    public String getEventStartDate() {
    return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
    this.eventStartDate = eventStartDate;
    }

    public String getEventEndDate() {
    return eventEndDate;
    }

    public void setEventEndDate(String eventEndDate) {
    this.eventEndDate = eventEndDate;
    }

    public String getAreaCode() {
    return areaCode;
    }

    public void setAreaCode(String areaCode) {
    this.areaCode = areaCode;
    }

    public String getSigunguCode() {
    return sigunguCode;
    }

    public void setSigunguCode(String sigunguCode) {
    this.sigunguCode = sigunguCode;
    }

    public String getModifiedtime() {
    return modifiedtime;
    }

    public void setModifiedtime(String modifiedtime) {
    this.modifiedtime = modifiedtime;
    }

    public String getServiceKey() {
    return serviceKey;
    }

    public void setServiceKey(String serviceKey) {
    this.serviceKey = serviceKey;
    }

}