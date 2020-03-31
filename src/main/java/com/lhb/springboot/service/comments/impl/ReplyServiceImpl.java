package com.lhb.springboot.service.comments.impl;

import com.lhb.springboot.dao.comments.ReplyDao;
import com.lhb.springboot.entity.comments.Reply;
import com.lhb.springboot.service.comments.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: yaya
 * @create: 2020/3/31
 */
@Component
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    ReplyDao replyDao;

    @Override
    public Reply addReply(Reply reply) {
        return null;
    }

    @Override
    public int delReplyById(Long replyId) {
        return 0;
    }

    @Override
    public int updateReply(Reply reply) {
        return 0;
    }

    @Override
    public List<Reply> findAllReplies() {
        return null;
    }

    @Override
    public List<Reply> findRepliesByUserId(Long userId) {
        return null;
    }

    @Override
    public List<Reply> findRepliesByCommentId(Long commentId) {
        return null;
    }
}
