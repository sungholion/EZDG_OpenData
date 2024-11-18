package com.openmind.ezdg.KorService1;

public class detailCommon1Request {
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
    * 콘텐츠ID
    */
    private String contentId;

    /**
    * 관광타입(12:관광지, 14:문화시설, 15:축제공연행사, 25:여행코스, 28:레포츠, 32:숙박, 38:쇼핑, 39:음식점) ID
    */
    private String contentTypeId;

    /**
    * 기본정보조회여부( Y,N )
    */
    private String defaultYN;

    /**
    * 원본, 썸네일대표 이미지, 이미지 공공누리유형정보 조회여부( Y,N )
    */
    private String firstImageYN;

    /**
    * 지역코드, 시군구코드조회여부( Y,N )
    */
    private String areacodeYN;

    /**
    * 대,중,소분류코드조회여부( Y,N )
    */
    private String catcodeYN;

    /**
    * 주소, 상세주소조회여부( Y,N )
    */
    private String addrinfoYN;

    /**
    * 좌표X, Y 조회여부( Y,N )
    */
    private String mapinfoYN;

    /**
    * 콘텐츠개요조회여부( Y,N )
    */
    private String overviewYN;

    /**
    * 한페이지결과수
    */
    private Number numOfRows;

    /**
    * 페이지번호
    */
    private Number pageNo;

    /**
    * 인증키(서비스키)
    */
    private String serviceKey;

    // Getters and Setters
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

    public String getContentId() {
    return contentId;
    }

    public void setContentId(String contentId) {
    this.contentId = contentId;
    }

    public String getContentTypeId() {
    return contentTypeId;
    }

    public void setContentTypeId(String contentTypeId) {
    this.contentTypeId = contentTypeId;
    }

    public String getDefaultYN() {
    return defaultYN;
    }

    public void setDefaultYN(String defaultYN) {
    this.defaultYN = defaultYN;
    }

    public String getFirstImageYN() {
    return firstImageYN;
    }

    public void setFirstImageYN(String firstImageYN) {
    this.firstImageYN = firstImageYN;
    }

    public String getAreacodeYN() {
    return areacodeYN;
    }

    public void setAreacodeYN(String areacodeYN) {
    this.areacodeYN = areacodeYN;
    }

    public String getCatcodeYN() {
    return catcodeYN;
    }

    public void setCatcodeYN(String catcodeYN) {
    this.catcodeYN = catcodeYN;
    }

    public String getAddrinfoYN() {
    return addrinfoYN;
    }

    public void setAddrinfoYN(String addrinfoYN) {
    this.addrinfoYN = addrinfoYN;
    }

    public String getMapinfoYN() {
    return mapinfoYN;
    }

    public void setMapinfoYN(String mapinfoYN) {
    this.mapinfoYN = mapinfoYN;
    }

    public String getOverviewYN() {
    return overviewYN;
    }

    public void setOverviewYN(String overviewYN) {
    this.overviewYN = overviewYN;
    }

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

    public String getServiceKey() {
    return serviceKey;
    }

    public void setServiceKey(String serviceKey) {
    this.serviceKey = serviceKey;
    }

}