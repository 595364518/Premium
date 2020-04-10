package com.lhb.springboot.entity;

/**
 * @author: yaya
 * @create: 2020/4/9
 */
public class Student {
    private String username;
    private Long sno;
    private String grade;

    public Student() {
    }

    public Student(String username, Long sno, String grade) {
        this.username = username;
        this.sno = sno;
        this.grade = grade;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getSno() {
        return sno;
    }

    public void setSno(Long sno) {
        this.sno = sno;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
