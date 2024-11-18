package com.openmind.ezdg.KorService1;

public class DetailImage1Request {
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
    * 이미지조회1 : Y=콘텐츠이미지조회 N=”음식점”타입의음식메뉴이미지
    */
    private String imageYN;

    /**
    * 이미지조회2 : Y=원본,썸네일이미지조회,공공누리 저작권유형정보조회 N=Null
    */
    private String subImageYN;

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

    public String getImageYN() {
    return imageYN;
    }

    public void setImageYN(String imageYN) {
    this.imageYN = imageYN;
    }

    public String getSubImageYN() {
    return subImageYN;
    }

    public void setSubImageYN(String subImageYN) {
    this.subImageYN = subImageYN;
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