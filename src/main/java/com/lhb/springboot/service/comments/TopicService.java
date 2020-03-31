package com.lhb.springboot.service.comments;

import com.lhb.springboot.entity.comments.Topic;

import java.util.List;

/**
 * @author: yaya
 * @create: 2020/3/29
 */
public interface TopicService {
    /**
     * 发布话题
     * @param topic 话题
     * @return 话题信息
     */
    Topic addTopic(Topic topic);

    /**
     * 通过话题编号删除话题
     * @param topicId 话题编号
     * @return
     */
    int delTopicById(Long topicId);

    /**
     * 修改话题
     * @param topic 话题
     * @return
     */
    int updateTopic(Topic topic);

    /**
     * 查询全部话题
     * @return 话题集合
     */
    List<Topic> findAllTopics();

    /**
     * 通过用户编号查询话题
     * @param userId 用户编号
     * @return 话题集合
     */
    List<Topic> findTopicByUserId(Long userId);

    /**
     * 通过用户编号和话题名模糊查询话题
     * @param topic 话题信息
     * @return 话题列表
     */
    List<Topic> findTopicsByUserIdAndName(Topic topic);
}
