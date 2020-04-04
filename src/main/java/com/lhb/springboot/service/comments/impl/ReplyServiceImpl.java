package com.lhb.springboot.service.comments.impl;

import com.lhb.springboot.dao.comments.ReplyDao;
import com.lhb.springboot.entity.comments.Reply;
import com.lhb.springboot.service.comments.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(propagation = Propagation.REQUIRES_NEW,
                isolation = Isolation.READ_COMMITTED)
    public Reply addReply(Reply reply) {
        int flag = replyDao.addReply(reply);
        if(flag == 1){
            return reply;
        }
        return null;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRES_NEW)
    public int delReplyById(Long replyId) {
        return replyDao.delReplyById(replyId);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRES_NEW)
    public int updateReply(Reply reply) {
        return replyDao.updateReply(reply);
    }

    @Override
    public List<Reply> findAllReplies() {
        return replyDao.findAllReplies();
    }

    @Override
    public List<Reply> findRepliesByUserId(Long userId) {
        return replyDao.findRepliesByUserId(userId);
    }

    @Override
    public List<Reply> findRepliesByCommentId(Long commentId) {
        return replyDao.findRepliesByCommentId(commentId);
    }
}
