package com.lhb.springboot.entity.users;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author: yaya
 * @create: 2020/3/29
 */
public class Times implements Serializable {
    private Long timeId;
    private String timeName;
    private String note;
    private Timestamp publicDate;
    private Long gradeId;

    public Long getTimeId() {
        return timeId;
    }

    public void setTimeId(Long timeId) {
        this.timeId = timeId;
    }

    public String getTimeName() {
        return timeName;
    }

    public void setTimeName(String timeName) {
        this.timeName = timeName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Timestamp getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Timestamp publicDate) {
        this.publicDate = publicDate;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }
}
