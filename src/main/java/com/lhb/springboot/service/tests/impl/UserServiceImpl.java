package com.lhb.springboot.service.tests.impl;

import com.lhb.springboot.dao.tests.UserDao;
import com.lhb.springboot.entity.tests.User;
import com.lhb.springboot.service.tests.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 03:51 2020/3/6
 */
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao=null;
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.NESTED)
    //@CachePut(value = "redisCache",key = "'redis_user_'+#result.sno")
    public User addUser(User user) {
        userDao.addUser(user);
        return user;
    }

    @Override
    @Transactional
    //@CacheEvict(value = "redisCache",key = "'redis_user_'+#sno",beforeInvocation = false)
    public int deleteUser(Long sno) {
        return userDao.deleteUser(sno);
    }

    @Override
    @Transactional
    //@CachePut(value = "redisCache",condition = "#result!=null",key = "'redis_user_'+#result.sno")
    public User updateUser(User user) {
        User user1 = this.findUserBySno(user.getSno());
        if(user1==null){
            return null;
        }
        return userDao.updateUser(user);
    }
    //Cache命中率低，不适用缓存
    @Override
    public User findUserBySno(Long sno) {
        return userDao.findUserBySno(sno);
    }
}
