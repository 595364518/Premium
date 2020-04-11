package com.lhb.springboot.dao.users;

import com.lhb.springboot.entity.users.Times;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: yaya
 * @create: 2020/3/29
 */
@Mapper
public interface TimesDao {
    /**
     * 发布作业
     * @param times 作业
     * @return
     */
    int addTime(Times times);

    /**
     * 通过作业编号删除作业
     * @param timeId
     * @return
     */
    int delTimeById(Long timeId);

    /**
     * 修改作业内容
     * @param times 作业信息
     * @return
     */
    int updateTime(Times times);

    /**
     * 通过作业名查询作业
     * @param timeName 作业名
     * @return 作业
     */
    Times findTimeByName(String timeName);

    /**
     * 查询所有作业
     * @return 做业集合
     */
    List<Times> findAllTimes();

    /**
     * 通过年级编号查询作业
     * @param gradeId 年级编号
     * @return 做业集合
     */
    List<Times> findTimesByGradeId(Long gradeId);
}
