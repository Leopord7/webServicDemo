package com.leopord.hmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.leopord.hmall.dao"})
public class HmallServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HmallServiceApplication.class, args);
    }
}
