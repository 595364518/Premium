package com.lhb.springboot.service.users;

import com.lhb.springboot.entity.users.HomeWorks;

import java.util.List;

/**
 * @author: yaya
 * @create: 2020/3/29
 */
public interface HomeworksService {
    /**
     * 提交作业
     * @param homeworks 作业
     * @return 作业信息
     */
    HomeWorks addHomework(HomeWorks homeworks);

    /**
     * 通过作业编号删除作业
     * @param homeworkId 作业编号
     * @return 影响的行数
     */
    int delHomeworkById(Long homeworkId);

    /**
     * 更新作业，一般用于更新作业状态
     * @param homeworks 待更新的作业
     * @return 影响的行数
     */
    int updateHomework(HomeWorks homeworks);

    /**
     * 查询所有作业
     * @return 做业集合
     */
    List<HomeWorks> findAllHomeworks();

    /**
     * 通过作业编号或作业名进行模糊查询
     * @param homeworks 作业信息
     * @return 作业
     */
    List<HomeWorks> findHomeworksByIdOrName(HomeWorks homeworks);
}
