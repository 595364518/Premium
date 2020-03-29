package com.lhb.springboot.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author: yaya
 * @create: 2020/3/29
 */
public class Topic implements Serializable {
    private Long topicId;
    private Long userId;
    private String topicName;
    private String content;
    private Timestamp topicDate;
    private Long topicLike;
    private Long viewCount;
    private int topicStatus;

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTopicDate() {
        return topicDate;
    }

    public void setTopicDate(Timestamp topicDate) {
        this.topicDate = topicDate;
    }

    public Long getTopicLike() {
        return topicLike;
    }

    public void setTopicLike(Long topicLike) {
        this.topicLike = topicLike;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public int getTopicStatus() {
        return topicStatus;
    }

    public void setTopicStatus(int topicStatus) {
        this.topicStatus = topicStatus;
    }
}
