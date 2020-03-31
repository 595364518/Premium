package com.lhb.springboot.dao.users;

import com.lhb.springboot.entity.users.Code;
import com.lhb.springboot.entity.users.Email;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: yaya
 * @create: 2020/3/29
 */
@Mapper
public interface CodeDao {
    /**
     * 添加验证码
     * @param code 验证码
     * @return 影响的行数
     */
    int addCode(Code code);

    /**
     * 通过邮件编号删除验证码，验证码过期时间为5分钟或使用之后立即删除
     * @param email 邮箱信息
     * @return 影响的行数
     */
    int delCodeById(Email email);

    /**
     * 通过邮箱编号获取验证码，用于用户注册验证
     * @param email 邮箱信息
     * @return 验证码
     */
    Code findCodeById(Email email);
}
