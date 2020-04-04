package com.lhb.springboot.service.users.impl;

import com.lhb.springboot.dao.users.HomeworksDao;
import com.lhb.springboot.entity.users.HomeWorks;
import com.lhb.springboot.service.users.HomeworksService;
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
public class HomeworksServiceImpl implements HomeworksService {
    @Autowired
    HomeworksDao homeworksDao;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRES_NEW)
    public HomeWorks addHomework(HomeWorks homeworks) {
        int flag = homeworksDao.addHomework(homeworks);
        if(flag == 1){
            return homeworks;
        }
        return null;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int delHomeworkById(Long homeworkId) {
        return homeworksDao.delHomeworkById(homeworkId);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRES_NEW)
    public int updateHomework(HomeWorks homeworks) {
        return homeworksDao.updateHomework(homeworks);
    }

    @Override
    public List<HomeWorks> findAllHomeworks() {
        return homeworksDao.findAllHomeworks();
    }

    @Override
    public List<HomeWorks> findHomeworksByIdOrName(HomeWorks homeworks) {
        return homeworksDao.findHomeworksByIdOrName(homeworks);
    }
}
