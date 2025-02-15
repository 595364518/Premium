package com.lhb.springboot.service.users;

import com.lhb.springboot.entity.users.Users;

import java.util.List;

/**
 * @author: yaya
 * @create: 2020/3/29
 */
public interface UsersService {
    /**
     * 添加用户
     * @param users 用户
     * @return 用户信息
     */
    Users addUser(Users users);

    /**
     * 通过用户编号删除用户
     * @param userId 用户编号--学号
     * @return 影响的行数
     */
    int delUserById(Long userId);

    /**
     * 更新(完善)用户信息
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
     * 通过用户编号查询
     * @param users 用户信息
     * @return 用户
     */
    Users findUserById(Users users);

    /**
     * 通过年级编号查询
     * @param gradeId 年级编号
     * @return 用户集合
     */
    List<Users> findUsersByGradeId(Long gradeId);
}
