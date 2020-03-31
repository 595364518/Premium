package com.lhb.springboot.service.users.impl;

import com.lhb.springboot.dao.users.HomeworksDao;
import com.lhb.springboot.entity.users.HomeWorks;
import com.lhb.springboot.service.users.HomeworksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public HomeWorks addHomework(HomeWorks homeworks) {
        return null;
    }

    @Override
    public int delHomeworkById(Long homeworkId) {
        return 0;
    }

    @Override
    public int updateHomework(HomeWorks homeworks) {
        return 0;
    }

    @Override
    public List<HomeWorks> findAllHomeworks() {
        return null;
    }

    @Override
    public List<HomeWorks> findHomeworksByIdOrName(HomeWorks homeworks) {
        return null;
    }
}
