package com.lhb.springboot.dao;

import com.lhb.springboot.entity.Users;

import java.util.List;

/**
 * @author: yaya
 * @create: 2020/3/29
 */
public interface UsersDao {
    /**
     * 添加用户
     * @param users 用户
     * @return 影响的行数
     */
    int addUser(Users users);

    /**
     * 通过用户编号删除用户
     * @param userId 用户编号--学号
     * @return 影响的行数
     */
    int delUserById(Long userId);

    /**
     * 更新用户信息
     * @param users 用户信息
     * @return 影响的行数
     */
    int updateUser(Users users);

    /**
     * 查询所有用户
     * @return 用户集合
     */
    List<Users> findAllUsers();

    /**
     * 通过用户编号或用户名模糊查询
     * @param users 用户信息
     * @return 用户
     */
    Users findUserById(Users users);
}
