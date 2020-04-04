package com.lhb.springboot.service.comments.impl;

import com.lhb.springboot.dao.comments.TopicDao;
import com.lhb.springboot.entity.comments.Topic;
import com.lhb.springboot.service.comments.TopicService;
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
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicDao topicDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_COMMITTED)
    public Topic addTopic(Topic topic) {
        int flag = topicDao.addTopic(topic);
        if(flag == 1){
            return topic;
        }
        return null;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRES_NEW)
    public int delTopicById(Long topicId) {
        return topicDao.delTopicById(topicId);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRES_NEW)
    public int updateTopic(Topic topic) {
        return topicDao.updateTopic(topic);
    }

    @Override
    public List<Topic> findAllTopics() {
        return topicDao.findAllTopics();
    }

    @Override
    public List<Topic> findTopicByUserId(Long userId) {
        return topicDao.findTopicByUserId(userId);
    }

    @Override
    public List<Topic> findTopicsByUserIdAndName(Topic topic) {
        return topicDao.findTopicsByUserIdAndName(topic);
    }
}
