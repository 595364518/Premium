package com.lhb.springboot.service.tests;

import com.lhb.springboot.entity.tests.HomeWork;

import java.util.List;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:11 2020/3/13
 */
public interface HomeWorkService {
    HomeWork addHW(HomeWork hw);
    int delHW(Long sno);
    List<HomeWork> findHWs(HomeWork homeWork);
    HomeWork findHWBySno(Long sno);
}
