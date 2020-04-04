package com.lhb.springboot.service.users.impl;

import com.lhb.springboot.dao.users.UsersDao;
import com.lhb.springboot.entity.users.Users;
import com.lhb.springboot.service.users.UsersService;
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
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersDao usersDao;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRES_NEW)
    public Users addUser(Users users) {
        int flag = usersDao.addUser(users);
        if(flag == 1){
            return users;
        }
        return null;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int delUserById(Long userId) {
        return usersDao.delUserById(userId);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRES_NEW)
    public int updateUser(Users users) {
        return usersDao.updateUser(users);
    }

    @Override
    public List<Users> findAllUsers() {
        return usersDao.findAllUsers();
    }

    @Override
    public Users findUserById(Users users) {
        return usersDao.findUserById(users);
    }
}
