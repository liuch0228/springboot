package com.example.aoplogback.pojo;

public class BaseResponse {
    private int rtnCode;

    private String rtnDesc;

    private Object datas;

    public BaseResponse(int rtnCode, String rtnDesc, Object datas) {
        this.rtnCode = rtnCode;
        this.rtnDesc = rtnDesc;
        this.datas = datas;
    }

    public int getRtnCode() {
        return rtnCode;
    }

    public void setRtnCode(int rtnCode) {
        this.rtnCode = rtnCode;
    }

    public String getRtnDesc() {
        return rtnDesc;
    }

    public void setRtnDesc(String rtnDesc) {
        this.rtnDesc = rtnDesc;
    }

    public Object getDatas() {
        return datas;
    }

    public void setDatas(Object datas) {
        this.datas = datas;
    }
}
