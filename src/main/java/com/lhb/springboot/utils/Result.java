package com.lhb.springboot.utils;

/**
 * @author: yaya
 * @create: 2020/4/4
 */
public class Result {
    private String msg;
    private int code;

    public Result(int code,String msg) {
        this.msg = msg;
        this.code = code;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
