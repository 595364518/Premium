package com.lhb.springboot;

import com.lhb.springboot.utils.CodeUtil;
import com.lhb.springboot.utils.MailUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(CodeUtil.generateCode());
    }

}
