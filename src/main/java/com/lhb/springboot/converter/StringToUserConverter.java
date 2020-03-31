package com.lhb.springboot.converter;

import com.lhb.springboot.entity.tests.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 01:46 2020/3/10
 */
@Component
public class StringToUserConverter implements Converter<String, User> {
    /**
     * 方法用于实现字符串参数到User之间的转换
     * @param s 要转换的字符串，格式xx-xxx-xxx
     * @return 返回一个User对象
     */
    @Override
    public User convert(String s) {
        User user = new User();
        String []strArr = s.split("-");
        user.setId(Long.parseLong(strArr[0]));
        user.setUsername(strArr[1]);
        user.setSno(Long.parseLong(strArr[2]));
        return user;
    }
}
