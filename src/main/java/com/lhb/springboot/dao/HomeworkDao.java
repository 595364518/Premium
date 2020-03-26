package com.lhb.springboot.dao;

import com.lhb.springboot.entity.HomeWork;
import com.lhb.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 01:59 2020/3/13
 */
@Mapper
public interface HomeworkDao {
    int addHW(HomeWork hw);
    int delHW(Long sno);
    List<HomeWork> findHWs(HomeWork homeWork);
    HomeWork findHWBySno(Long sno);
}
