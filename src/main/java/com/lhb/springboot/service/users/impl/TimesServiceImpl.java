package com.lhb.springboot.service.users.impl;

import com.lhb.springboot.dao.users.TimesDao;
import com.lhb.springboot.entity.users.Times;
import com.lhb.springboot.service.users.TimesService;
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
public class TimesServiceImpl implements TimesService {
    @Autowired
    TimesDao timesDao;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRES_NEW)
    public Times addTime(Times times) {
        int flag = timesDao.addTime(times);
        if(flag == 1){
            return times;
        }
        return null;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int delTimeById(Long timeId) {
        return timesDao.delTimeById(timeId);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRES_NEW)
    public int updateTime(Times times) {
        return timesDao.updateTime(times);
    }

    @Override
    public List<Times> findAllTimes() {
        return timesDao.findAllTimes();
    }

    @Override
    public List<Times> findTimesByGradeId(Long gradeId) {
        return timesDao.findTimesByGradeId(gradeId);
    }
}
