package com.lhb.springboot.dao.comments;

import com.lhb.springboot.entity.comments.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: yaya
 * @create: 2020/3/29
 */
@Mapper
public interface CommentDao {
    /**
     * 发表(添加)评论
     * @param comment 评论
     * @return
     */
    int addComment(Comment comment);

    /**
     * 通过评论编号删除评论
     * @param commentId 评论编号
     * @return
     */
    int delComentById(Long commentId);

    /**
     * 修改评论点赞数
     * @param comment 评论信息
     * @return
     */
    int updateComment(Comment comment);

    /**
     * 查询所有评论
     * @return 评论集合
     */
    List<Comment> findAllComments();

    /**
     * 通过用户编号查询评论
     * @param userId 用户编号
     * @return 评论集合
     */
    List<Comment> findCommentsByUserId(Long userId);

    /**
     * 通过话题编号查询评论
     * @param topicId 话题编号
     * @return 评论集合
     */
    List<Comment> findCommentsByTopicId(Long topicId);

    /**
     * 通过话题编号和用户编号查询评论
     * @param topicId 话题编号
     * @param userId 用户编号
     * @return 评论集合
     */
    List<Comment> findCommentsByTopicIdAndUserId(Long topicId,Long userId);
}
