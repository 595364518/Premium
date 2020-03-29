package com.lhb.springboot.service;

import com.lhb.springboot.entity.Reply;

import java.util.List;

/**
 * @author: yaya
 * @create: 2020/3/29
 */
public interface ReplyService {
    /**
     * 添加回复
     * @param reply 回复
     * @return 回复信息
     */
    Reply addReply(Reply reply);

    /**
     * 通过编号删除回复
     * @param replyId 回复编号
     * @return
     */
    int delReplyById(Long replyId);

    /**
     * 查询所有回复
     * @return 回复集合
     */
    List<Reply> findAllReplies();

    /**
     * 通过用户编号查询所有回复
     * @param userId 用户编号
     * @return 回复集合
     */
    List<Reply> findRepliesByUserId(Long userId);

    /**
     * 通过评论编号查询所有回复
     * @param commentId 评论编号
     * @return 回复集合
     */
    List<Reply> findRepliesByCommentId(Long commentId);
}
