package com.lhb.springboot.dao;

import com.lhb.springboot.entity.Topic;
import com.lhb.springboot.entity.Users;

import java.util.List;

/**
 * @author: yaya
 * @create: 2020/3/29
 */
public interface TopicDao {
    /**
     * 发布话题
     * @param topic 话题
     * @return
     */
    int addTopic(Topic topic);

    /**
     * 通过用户编号和话题名称删除话题
     * @param topic 话题
     * @return
     */
    int delTopicByNameAndUserId(Topic topic);

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
     * 通过用户编号和话题名查询话题
     * @param topic 话题信息
     * @return 话题
     */
    Topic findTopicByUserIdAndName(Topic topic);
}
