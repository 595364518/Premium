package com.lhb.springboot.service.users.impl;

import com.lhb.springboot.dao.users.CodeDao;
import com.lhb.springboot.entity.users.Code;
import com.lhb.springboot.entity.users.Email;
import com.lhb.springboot.service.users.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: yaya
 * @create: 2020/3/31
 */
@Component
public class CodeServiceImpl implements CodeService {
    @Autowired
    CodeDao codeDao;

    @Override
    public Code addCode(Code code) {
        return null;
    }

    @Override
    public int delCodeById(Email email) {
        return 0;
    }

    @Override
    public Code findCodeById(Email email) {
        return null;
    }
}
