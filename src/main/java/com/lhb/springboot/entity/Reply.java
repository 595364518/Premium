package com.lhb.springboot.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author: yaya
 * @create: 2020/3/29
 */
public class Reply implements Serializable {
    private Long replyId;
    private Long commentId;
    private Long userId;
    private String replyContent;
    private Timestamp replyDate;
    private Long replyLike;

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Timestamp getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Timestamp replyDate) {
        this.replyDate = replyDate;
    }

    public Long getReplyLike() {
        return replyLike;
    }

    public void setReplyLike(Long replyLike) {
        this.replyLike = replyLike;
    }
}
