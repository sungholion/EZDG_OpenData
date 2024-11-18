package com.openmind.ezdg.KorService1;

public class AreaBasedSyncList1Request {
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
    * 인증키(서비스키)
    */
    private String serviceKey;

    /**
    * 응답메세지 형식 : REST방식의 URL호출 시 json값 추가(디폴트 응답메세지 형식은XML)
    */
    private String _type;

    /**
    * 컨텐츠표출여부(1=표출, 0=비표출)
    */
    private String showflag;

    /**
    * 컨텐츠변경일자 (수정년도,수정년월,수정년월일 입력,YYYYMMDD)
    */
    private String modifiedtime;

    /**
    * 목록 구분 (Y=목록, N=개수)
    */
    private String listYN;

    /**
    * 정렬 구분 (A=제목순, C=수정일순, D=생성일순) 대표이미지가 반드시 있는 정렬 (O=제목순, Q=수정일순, R=생성일순)
    */
    private String arrange;

    /**
    * 관광타입(12:관광지, 14:문화시설, 15:축제공연행사, 25:여행코스, 28:레포츠, 32:숙박, 38:쇼핑, 39:음식점) ID
    */
    private String contentTypeId;

    /**
    * 지역코드(지역코드조회 참고)
    */
    private String areaCode;

    /**
    * 시군구코드(지역코드조회 참고)
    */
    private String sigunguCode;

    /**
    * 대분류 코드(서비스분류코드조회 참고)
    */
    private String cat1;

    /**
    * 중분류 코드(서비스분류코드조회 참고)
    */
    private String cat2;

    /**
    * 소분류 코드(서비스분류코드조회 참고)
    */
    private String cat3;

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

    public String getServiceKey() {
    return serviceKey;
    }

    public void setServiceKey(String serviceKey) {
    this.serviceKey = serviceKey;
    }

    public String get_type() {
    return _type;
    }

    public void set_type(String _type) {
    this._type = _type;
    }

    public String getShowflag() {
    return showflag;
    }

    public void setShowflag(String showflag) {
    this.showflag = showflag;
    }

    public String getModifiedtime() {
    return modifiedtime;
    }

    public void setModifiedtime(String modifiedtime) {
    this.modifiedtime = modifiedtime;
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

    public String getContentTypeId() {
    return contentTypeId;
    }

    public void setContentTypeId(String contentTypeId) {
    this.contentTypeId = contentTypeId;
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

}