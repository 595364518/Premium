package com.lhb.springboot.service.impl;

import com.lhb.springboot.dao.HomeworkDao;
import com.lhb.springboot.entity.HomeWork;
import com.lhb.springboot.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:14 2020/3/13
 */
@Component
public class HomeworkServiceImpl implements HomeworkService {
    @Autowired
    HomeworkDao homeworkDao;
    @Transactional(propagation = Propagation.NESTED,isolation = Isolation.READ_COMMITTED)
    //@CachePut(value = "redisCache",key = "'redis_homework_'+#result.sno")
    @Override
    public HomeWork addHW(HomeWork hw) {
        homeworkDao.addHW(hw);
        return hw;
    }

    @Transactional
    //@CacheEvict(value = "redisCache",key = "'redis_homework_'+#sno")
    @Override
    public int delHW(Long sno) {
        return homeworkDao.delHW(sno);
    }

    @Transactional
    //@Cacheable(value = "redisCache",key = "'redis_homework_'")
    @Override
    public List<HomeWork> findHWs(HomeWork homeWork) {
        return homeworkDao.findHWs(homeWork);
    }

    @Override
    public HomeWork findHWBySno(Long sno) {
        return homeworkDao.findHWBySno(sno);
    }
}
