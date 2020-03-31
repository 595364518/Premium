package com.lhb.springboot.service.users.impl;

import com.lhb.springboot.dao.users.EmailDao;
import com.lhb.springboot.entity.users.Email;
import com.lhb.springboot.service.users.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: yaya
 * @create: 2020/3/31
 */
@Component
public class EmailServiceImpl implements EmailService {
    @Autowired
    EmailDao emailDao;

    @Override
    public Email addEmail(Email e) {
        return null;
    }

    @Override
    public int delEmail(Email e) {
        return 0;
    }

    @Override
    public int updateEmail(Email e) {
        return 0;
    }

    @Override
    public List<Email> findAllEmails() {
        return null;
    }

    @Override
    public Email findEmailByEName(Email e) {
        return null;
    }
}
