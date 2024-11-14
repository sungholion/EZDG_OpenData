package com.openmind.ezdg.StdPatInfoService;

public class StdOrganInfoRequest {
    /**
    * 한 페이지 결과 수
    */
    private String numOfRows;

    /**
    * 페이지번호
    */
    private String pageNo;

    /**
    * 결과형식 ( XML/JSON, 기본 값 : xml )
    */
    private String resultType;

    /**
    * 표준기구코드
    */
    private String stdorgancd;

    /**
    * 연구반정보_분류
    */
    private String sginfoclass;

    /**
    * 연구반정보_분류1
    */
    private String sginfoclass1;

    /**
    * 연구반정보_분류2
    */
    private String sginfoclass2;

    /**
    * 연구반정보_분류3
    */
    private String sginfoclass3;

    /**
    * 연구반정보 표준분야_영문
    */
    private String stdfield_eng;

    /**
    * 연구반정보 표준분야_한글
    */
    private String stdfield_kor;

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

    public String getResultType() {
    return resultType;
    }

    public void setResultType(String resultType) {
    this.resultType = resultType;
    }

    public String getStdorgancd() {
    return stdorgancd;
    }

    public void setStdorgancd(String stdorgancd) {
    this.stdorgancd = stdorgancd;
    }

    public String getSginfoclass() {
    return sginfoclass;
    }

    public void setSginfoclass(String sginfoclass) {
    this.sginfoclass = sginfoclass;
    }

    public String getSginfoclass1() {
    return sginfoclass1;
    }

    public void setSginfoclass1(String sginfoclass1) {
    this.sginfoclass1 = sginfoclass1;
    }

    public String getSginfoclass2() {
    return sginfoclass2;
    }

    public void setSginfoclass2(String sginfoclass2) {
    this.sginfoclass2 = sginfoclass2;
    }

    public String getSginfoclass3() {
    return sginfoclass3;
    }

    public void setSginfoclass3(String sginfoclass3) {
    this.sginfoclass3 = sginfoclass3;
    }

    public String getStdfield_eng() {
    return stdfield_eng;
    }

    public void setStdfield_eng(String stdfield_eng) {
    this.stdfield_eng = stdfield_eng;
    }

    public String getStdfield_kor() {
    return stdfield_kor;
    }

    public void setStdfield_kor(String stdfield_kor) {
    this.stdfield_kor = stdfield_kor;
    }

}