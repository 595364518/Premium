package com.lhb.springboot.service.tests;

import com.lhb.springboot.entity.tests.User;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 03:46 2020/3/6
 */
public interface UserService {
    User addUser(User user);
    int deleteUser(Long sno);
    User updateUser(User user);
    User findUserBySno(Long sno);
}
