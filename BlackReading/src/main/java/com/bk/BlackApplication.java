package com.bk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bk.*.mapper")
public class BlackApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlackApplication.class, args);
    }

}
