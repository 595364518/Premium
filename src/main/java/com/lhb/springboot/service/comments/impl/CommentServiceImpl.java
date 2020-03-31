package com.lhb.springboot.service.comments.impl;

import com.lhb.springboot.dao.comments.CommentDao;
import com.lhb.springboot.entity.comments.Comment;
import com.lhb.springboot.service.comments.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public Comment addComment(Comment comment) {
        return null;
    }

    @Override
    public int delComentById(Long commentId) {
        return 0;
    }

    @Override
    public int updateComment(Comment comment) {
        return 0;
    }

    @Override
    public List<Comment> findAllComments() {
        return null;
    }

    @Override
    public List<Comment> findCommentsByUserId(Long userId) {
        return null;
    }

    @Override
    public List<Comment> findCommentsByTopicId(Long topicId) {
        return null;
    }
}
