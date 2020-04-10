package com.lhb.springboot.service.users;

import com.lhb.springboot.entity.users.Grade;

import java.util.List;

/**
 * @author: yaya
 * @create: 2020/3/29
 */
public interface GradeService {
    /**
     * 添加年级
     * @param grade 年级
     * @return 年级信息
     */
    Grade addGrade(Grade grade);

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
     * 通过id查询年级
     * @param grade 年级信息
     * @return 年级
     */
    Grade findGradeById(Grade grade);

    /**
     * 通过年级名查询年级
     * @param grade 年级信息
     * @return 年级
     */
    Grade findGradeByName(Grade grade);

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
