package com.lhb.springboot.utils;

import org.omg.PortableInterceptor.SUCCESSFUL;

/**
 * @author: yaya
 * @create: 2020/4/4
 */
public enum ResultCode {
    /**
     * 用户名不能为空
     */
    USER_EMPTY(201,"用户名为空"),
    /**
     * 用户名已存在
     */
    USER_EXISTS(202,"用户名已存在"),
    /**
     * 用户名不存在
     */
    USER_NOT_EXISTS(203,"用户名不存在"),
    /**
     * 请求成功
     */
    SUCCESSFUL(200,"请求成功"),
    /**
     * 请求失败
     */
    FAILED(204,"请求失败"),
    /**
     * 验证码错误
     */
    WRONG_CODE(205,"验证码错误"),
    /**
     * 验证码为空
     */
    EMPTY_CODE(205,"验证码为空");
    int code;
    String msg;
    ResultCode(int code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }

}
