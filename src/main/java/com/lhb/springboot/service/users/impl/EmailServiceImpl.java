package com.lhb.springboot.service.users.impl;

import com.lhb.springboot.dao.users.EmailDao;
import com.lhb.springboot.entity.users.Email;
import com.lhb.springboot.service.users.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRES_NEW)
    public Email addEmail(Email e) {
        int flag = emailDao.addEmail(e);
        if(flag == 1){
            return e;
        }
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
        return emailDao.findAllEmails();
    }

    @Override
    public Email findEmailByEName(Email e) {
        return emailDao.findEmailByEName(e);
    }
}
