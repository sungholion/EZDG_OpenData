package com.openmind.ezdg.StdPatInfoService;

public class TechFieldRecordPatInfoRequest {
    /**
    * 한 페이지 결과 수기본 값 : 10, 최대 값 : 1000)
    */
    private String numOfRows;

    /**
    * 페이지번호 기본 값 : 1 )
    */
    private String pageNo;

    /**
    * XML/JSON, 기본 값 : xml
    */
    private String resultType;

    /**
    * Kipris IPC목록
    */
    private String ipc;

    /**
    * Kipris IPC명칭
    */
    private String ipctitle;

    /**
    * 시작 선언일자(8자리)
    */
    private String startdeclaredate;

    /**
    * 종료 선언일자(8자리)
    */
    private String enddeclaredate;

    /**
    * Kipris IPC(IPC1st)
    */
    private String ipclist;

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

    public String getIpc() {
    return ipc;
    }

    public void setIpc(String ipc) {
    this.ipc = ipc;
    }

    public String getIpctitle() {
    return ipctitle;
    }

    public void setIpctitle(String ipctitle) {
    this.ipctitle = ipctitle;
    }

    public String getStartdeclaredate() {
    return startdeclaredate;
    }

    public void setStartdeclaredate(String startdeclaredate) {
    this.startdeclaredate = startdeclaredate;
    }

    public String getEnddeclaredate() {
    return enddeclaredate;
    }

    public void setEnddeclaredate(String enddeclaredate) {
    this.enddeclaredate = enddeclaredate;
    }

    public String getIpclist() {
    return ipclist;
    }

    public void setIpclist(String ipclist) {
    this.ipclist = ipclist;
    }

}