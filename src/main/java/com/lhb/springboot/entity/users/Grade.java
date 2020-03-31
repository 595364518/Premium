package com.lhb.springboot.entity.users;

/**
 * @author: yaya
 * @create: 2020/3/29
 */
public class Grade {
    private Long gradeId;
    private String gradeName;

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
}
