package com.lhb.springboot.entity;

import java.io.Serializable;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 03:00 2020/3/6
 */
public class User implements Serializable {
    private Long id;
    private String username;
    private Long level;
    private Long sno;

    public User() {
    }

    public User(String username, Long level, Long sno) {
        this.username = username;
        this.level = level;
        this.sno = sno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getSno() {
        return sno;
    }

    public void setSno(Long sno) {
        this.sno = sno;
    }
}
