package com.example.lchtest.springbootdemo1.domain;

/**
 *  自定义异常类
 */
public class MyException extends RuntimeException {
    private int code;
    private  String msg;
    public MyException(){
        super();
    }

    public MyException(int code, String msg){
      this.code = code;
      this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
