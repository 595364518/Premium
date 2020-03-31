package com.lhb.springboot.dao.users;

import com.lhb.springboot.entity.users.Grade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: yaya
 * @create: 2020/3/29
 */
@Mapper
public interface GradeDao {
    /**
     * 添加年级
     * @param grade 年级
     * @return 影响的行数
     */
    int addGrade(Grade grade);

    /**
     * 删除年级
     * @param gradeId 年级编号
     * @return 影响的行数
     */
    int delGradeById(Long gradeId);

    /**
     * 更新年级信息
     * @param grade 年级信息
     * @return 影响的行数
     */
    int updateGrade(Grade grade);

    /**
     * 查询所有年级
     * @return 年级集合
     */
    List<Grade> findAllGrades();

    /***
     * 通过id或年级名模糊查询
     * @param grade 查询信息
     * @return 年级集合
     */
    List<Grade> findGradesByIdOrName(Grade grade);
}
