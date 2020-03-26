package com.lhb.springboot.dao;

import com.lhb.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 03:04 2020/3/6
 */
@Mapper
public interface UserDao {
    int addUser(User user);
    //int addUsers(List<User> users);
    int deleteUser(Long sno);
    User updateUser(User user);
    User findUserBySno(Long sno);
}
