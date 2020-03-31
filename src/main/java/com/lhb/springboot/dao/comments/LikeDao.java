package com.lhb.springboot.dao.comments;

import com.lhb.springboot.entity.comments.Like;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: yaya
 * @create: 2020/3/29
 */
@Mapper
public interface LikeDao {
    /**
     * 添加点赞信息
     * @param like 点赞信息
     * @return
     */
    int addLike(Like like);

    /**
     * 修改点赞状态
     * @param like 点赞信息
     * @return
     */
    int updateLike(Like like);

    /**
     * 查询所有点赞信息
     * @return 点赞信息集合
     */
    List<Like> findAllLikes();

    /**
     * 通过用户名和话题编号查询所有点赞信息
     * @param like 点赞信息
     * @return 点赞集合
     */
    List<Like> findLikesByUserIdAndTopicId(Like like);
    /**
     * 通过用户名和评论编号查询所有点赞信息
     * @param like 点赞信息
     * @return 点赞集合
     */
    List<Like> findLikesByUserIdAndCommentId(Like like);
    /**
     * 通过用户名和回复编号查询所有点赞信息
     * @param like 点赞信息
     * @return 点赞集合
     */
    List<Like> findLikesByUserIdAndReplyId(Like like);
}
