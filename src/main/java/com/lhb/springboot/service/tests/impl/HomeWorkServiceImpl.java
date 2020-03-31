package com.lhb.springboot.service.tests.impl;

import com.lhb.springboot.dao.tests.HomeWorkDao;
import com.lhb.springboot.entity.tests.HomeWork;
import com.lhb.springboot.service.tests.HomeWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:14 2020/3/13
 */
@Component
public class HomeWorkServiceImpl implements HomeWorkService {
    @Autowired
    HomeWorkDao homeworkDao;
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
