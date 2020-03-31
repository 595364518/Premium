package com.lhb.springboot.service.users.impl;

import com.lhb.springboot.dao.users.UsersDao;
import com.lhb.springboot.entity.users.Users;
import com.lhb.springboot.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: yaya
 * @create: 2020/3/31
 */
@Component
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersDao usersDao;

    @Override
    public Users addUser(Users users) {
        return null;
    }

    @Override
    public int delUserById(Long userId) {
        return 0;
    }

    @Override
    public int updateUser(Users users) {
        return 0;
    }

    @Override
    public List<Users> findAllUsers() {
        return null;
    }

    @Override
    public Users findUserById(Users users) {
        return null;
    }
}
