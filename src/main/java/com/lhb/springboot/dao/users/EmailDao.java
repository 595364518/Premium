package com.lhb.springboot.dao.users;

import com.lhb.springboot.entity.users.Email;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: yaya
 * @create: 2020/3/29
 */
@Mapper
public interface EmailDao {
    /**
     * 添加邮箱
     * @param e 邮箱信息
     * @return 影响的行数
     */
    int addEmail(Email e);

    /**
     * 删除邮箱
     * @param e 邮箱信息
     * @return 影响的行数
     */
    int delEmail(Email e);

    /**
     * 更新邮箱
     * @param e 邮箱信息
     * @return 影响的行数
     */
    int updateEmail(Email e);

    /**
     * 获取所有邮箱
     * @return 邮箱集合
     */
    List<Email> findAllEmails();

    /**
     * 通过邮箱名查询邮箱
     * @param e 邮箱信息
     * @return 邮箱
     */
    Email findEmailByEName(Email e);
}
