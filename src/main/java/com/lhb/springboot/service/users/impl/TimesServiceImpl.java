package com.lhb.springboot.service.users.impl;

import com.lhb.springboot.dao.users.TimesDao;
import com.lhb.springboot.entity.users.Times;
import com.lhb.springboot.service.users.TimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public Times addTime(Times times) {
        return null;
    }

    @Override
    public int delTimeById(Long timeId) {
        return 0;
    }

    @Override
    public int updateTime(Times times) {
        return 0;
    }

    @Override
    public List<Times> findAllTimes() {
        return null;
    }

    @Override
    public List<Times> findTimesByGradeId(Long gradeId) {
        return null;
    }
}
