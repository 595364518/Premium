package com.lhb.springboot.service;

import com.lhb.springboot.entity.HomeWork;

import java.util.List;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:11 2020/3/13
 */
public interface HomeworkService {
    HomeWork addHW(HomeWork hw);
    int delHW(Long sno);
    List<HomeWork> findHWs(HomeWork homeWork);
    HomeWork findHWBySno(Long sno);
}
