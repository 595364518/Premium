package com.lhb.springboot.service.comments.impl;

import com.lhb.springboot.dao.comments.LikeDao;
import com.lhb.springboot.entity.comments.Like;
import com.lhb.springboot.service.comments.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: yaya
 * @create: 2020/3/31
 */
@Component
public class LikeServiceImpl implements LikeService {
    @Autowired
    LikeDao likeDao;

    @Override
    public int addLike(Like like) {
        return 0;
    }

    @Override
    public int updateLike(Like like) {
        return 0;
    }

    @Override
    public List<Like> findAllLikes() {
        return null;
    }

    @Override
    public List<Like> findLikesByUserIdAndTopicId(Like like) {
        return null;
    }

    @Override
    public List<Like> findLikesByUserIdAndCommentId(Like like) {
        return null;
    }

    @Override
    public List<Like> findLikesByUserIdAndReplyId(Like like) {
        return null;
    }
}
