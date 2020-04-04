package com.lhb.springboot.service.comments.impl;

import com.lhb.springboot.dao.comments.CommentDao;
import com.lhb.springboot.entity.comments.Comment;
import com.lhb.springboot.service.comments.CommentService;
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
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDao commentDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_COMMITTED)
    public Comment addComment(Comment comment) {
        int flag = commentDao.addComment(comment);
        if(flag == 1){
            return comment;
        }
        return null;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRES_NEW)
    public int delComentById(Long commentId) {
        return commentDao.delComentById(commentId);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRES_NEW)
    public int updateComment(Comment comment) {
        return commentDao.updateComment(comment);
    }

    @Override
    public List<Comment> findAllComments() {
        return commentDao.findAllComments();
    }

    @Override
    public List<Comment> findCommentsByUserId(Long userId) {
        return commentDao.findCommentsByUserId(userId);
    }

    @Override
    public List<Comment> findCommentsByTopicId(Long topicId) {
        return commentDao.findCommentsByTopicId(topicId);
    }

    @Override
    public List<Comment> findCommentsByTopicIdAndUserId(Long topicId, Long userId) {
        return commentDao.findCommentsByTopicIdAndUserId(topicId,userId);
    }
}
