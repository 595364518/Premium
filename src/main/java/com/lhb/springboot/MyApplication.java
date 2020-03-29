package com.lhb.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import redis.clients.jedis.Jedis;

@EnableCaching
@EnableScheduling
@MapperScan(basePackages = "com.lhb.springboot.dao")
@SpringBootApplication
public class MyApplication {


    public static void main(String[] args) {

        SpringApplication.run(MyApplication.class, args);
    }

}
