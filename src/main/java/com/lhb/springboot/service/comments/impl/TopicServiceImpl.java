package com.lhb.springboot.service.comments.impl;

import com.lhb.springboot.dao.comments.TopicDao;
import com.lhb.springboot.entity.comments.Topic;
import com.lhb.springboot.service.comments.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public Topic addTopic(Topic topic) {
        return null;
    }

    @Override
    public int delTopicById(Long topicId) {
        return 0;
    }

    @Override
    public int updateTopic(Topic topic) {
        return 0;
    }

    @Override
    public List<Topic> findAllTopics() {
        return null;
    }

    @Override
    public List<Topic> findTopicByUserId(Long userId) {
        return null;
    }

    @Override
    public List<Topic> findTopicsByUserIdAndName(Topic topic) {
        return null;
    }
}
