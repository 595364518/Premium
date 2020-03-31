package com.lhb.springboot.service.users.impl;

import com.lhb.springboot.dao.users.GradeDao;
import com.lhb.springboot.entity.users.Grade;
import com.lhb.springboot.service.users.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: yaya
 * @create: 2020/3/31
 */
@Component
public class GradeServiceImpl implements GradeService {
    @Autowired
    GradeDao gradeDao;

    @Override
    public Grade addGrade(Grade grade) {
        return null;
    }

    @Override
    public int delGradeById(Long gradeId) {
        return 0;
    }

    @Override
    public int updateGrade(Grade grade) {
        return 0;
    }

    @Override
    public List<Grade> findAllGrades() {
        return null;
    }

    @Override
    public List<Grade> findGradesByIdOrName(Grade grade) {
        return null;
    }
}
