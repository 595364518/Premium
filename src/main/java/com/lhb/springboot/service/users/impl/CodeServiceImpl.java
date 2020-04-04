package com.lhb.springboot.service.users.impl;

import com.lhb.springboot.dao.users.CodeDao;
import com.lhb.springboot.entity.users.Code;
import com.lhb.springboot.entity.users.Email;
import com.lhb.springboot.service.users.CodeService;
import com.lhb.springboot.utils.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * @author: yaya
 * @create: 2020/3/31
 */
@Component
public class CodeServiceImpl implements CodeService {
    @Autowired
    CodeDao codeDao;

    /**
     * 生成验证码
     * @param code 验证码
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_COMMITTED)
    public Code addCode(Code code) {

        int flag;
        String validateCode = null;
        validateCode = CodeUtil.generateCode();
        code.setCodeName(validateCode);
        flag = codeDao.addCode(code);
        if(flag == 1){
            return code;
        }
        return null;
    }

    @Override
    public int delCodeById(Email email) {
        return codeDao.delCodeById(email);
    }

    @Override
    public Code findCodeById(Email email) {
        return codeDao.findCodeById(email);
    }
}
