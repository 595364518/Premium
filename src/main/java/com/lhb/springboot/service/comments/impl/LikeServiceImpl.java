package com.lhb.springboot.service.comments.impl;

import com.lhb.springboot.dao.comments.LikeDao;
import com.lhb.springboot.entity.comments.Like;
import com.lhb.springboot.service.comments.LikeService;
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
public class LikeServiceImpl implements LikeService {
    @Autowired
    LikeDao likeDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_COMMITTED)
    public int addLike(Like like) {
        int flag = likeDao.addLike(like);
        return flag;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int updateLike(Like like) {
        return likeDao.updateLike(like);
    }

    @Override
    public List<Like> findAllLikes() {
        return likeDao.findAllLikes();
    }

    @Override
    public List<Like> findLikesByUserIdAndTopicId(Like like) {
        return likeDao.findLikesByUserIdAndTopicId(like);
    }

    @Override
    public List<Like> findLikesByUserIdAndCommentId(Like like) {
        return likeDao.findLikesByUserIdAndCommentId(like);
    }

    @Override
    public List<Like> findLikesByUserIdAndReplyId(Like like) {
        return likeDao.findLikesByUserIdAndReplyId(like);
    }
}
