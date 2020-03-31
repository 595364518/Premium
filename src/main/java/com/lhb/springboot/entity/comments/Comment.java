package com.lhb.springboot.entity.comments;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author: yaya
 * @create: 2020/3/29
 */
public class Comment implements Serializable {
    private Long commentId;
    private Long topicId;
    private Long userId;
    private String comContent;
    private Timestamp commentDate;
    private Long commentLike;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

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

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent;
    }

    public Timestamp getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Timestamp commentDate) {
        this.commentDate = commentDate;
    }

    public Long getCommentLike() {
        return commentLike;
    }

    public void setCommentLike(Long commentLike) {
        this.commentLike = commentLike;
    }
}
