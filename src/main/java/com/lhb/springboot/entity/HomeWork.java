package com.lhb.springboot.entity;

import java.io.Serializable;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 01:57 2020/3/13
 */
public class HomeWork implements Serializable {
    private Long hid;
    private String hname;
    private Long sno;

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public Long getSno() {
        return sno;
    }

    public void setSno(Long sno) {
        this.sno = sno;
    }
}
