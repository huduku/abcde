package com.abcde.validate;


public class RetData {



    private String status;
    private String errMsg;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "RetData{" +
                "status='" + status + '\'' +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
