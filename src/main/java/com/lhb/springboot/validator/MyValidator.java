package com.lhb.springboot.validator;

import com.lhb.springboot.entity.tests.User;
import com.lhb.springboot.entity.users.Users;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 04:11 2020/3/11
 */
public class MyValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(Users.class);
    }

    @Override
    public void validate(Object o, Errors errors) {

        if (o==null){
            errors.rejectValue("",null,"用户不能为空");
            return;
        }
        Users user = (Users)o;
        if(StringUtils.isEmpty(user.getUserName())){
            errors.rejectValue("username",null,"用户名不能为空");
        }
    }
}
