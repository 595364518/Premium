package com.lhb.springboot.service.users.impl;

import com.lhb.springboot.dao.users.GradeDao;
import com.lhb.springboot.entity.users.Grade;
import com.lhb.springboot.service.users.GradeService;
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
public class GradeServiceImpl implements GradeService {
    @Autowired
    GradeDao gradeDao;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRES_NEW)
    public Grade addGrade(Grade grade) {
        int flag = gradeDao.addGrade(grade);
        if(flag == 1){
            return grade;
        }
        return null;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int delGradeById(Long gradeId) {
        return gradeDao.delGradeById(gradeId);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRES_NEW)
    public int updateGrade(Grade grade) {
        return gradeDao.updateGrade(grade);
    }

    @Override
    public List<Grade> findAllGrades() {
        return gradeDao.findAllGrades();
    }

    @Override
    public List<Grade> findGradesByIdOrName(Grade grade) {
        return gradeDao.findGradesByIdOrName(grade);
    }
}
