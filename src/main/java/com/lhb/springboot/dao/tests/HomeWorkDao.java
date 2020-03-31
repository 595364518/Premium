package com.lhb.springboot.dao.tests;

import com.lhb.springboot.entity.tests.HomeWork;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 01:59 2020/3/13
 */
@Mapper
public interface HomeWorkDao {
    int addHW(HomeWork hw);
    int delHW(Long sno);
    List<HomeWork> findHWs(HomeWork homeWork);
    HomeWork findHWBySno(Long sno);
}
