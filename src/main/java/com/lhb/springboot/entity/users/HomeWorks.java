package com.lhb.springboot.entity.users;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author: yaya
 * @create: 2020/3/29
 */
public class HomeWorks implements Serializable {
    private Long homeworkId;
    private Long userId;
    private Long timeIdl;
    private String homeworkName;
    private int qualified;
    private int checked;
    private String homeworkNote;
    private Timestamp handedDate;

    public Long getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTimeIdl() {
        return timeIdl;
    }

    public void setTimeIdl(Long timeIdl) {
        this.timeIdl = timeIdl;
    }

    public String getHomeworkName() {
        return homeworkName;
    }

    public void setHomeworkName(String homeworkName) {
        this.homeworkName = homeworkName;
    }

    public int getQualified() {
        return qualified;
    }

    public void setQualified(int qualified) {
        this.qualified = qualified;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public String getHomeworkNote() {
        return homeworkNote;
    }

    public void setHomeworkNote(String homeworkNote) {
        this.homeworkNote = homeworkNote;
    }

    public Timestamp getHandedDate() {
        return handedDate;
    }

    public void setHandedDate(Timestamp handedDate) {
        this.handedDate = handedDate;
    }
}
