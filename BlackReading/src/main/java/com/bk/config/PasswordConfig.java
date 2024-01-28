package com.bk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Description: 使用 PasswordEncoder 对密码加密需要添加 PasswordEncoder 的 bean
 * @author: BlackWarm
 * @date: 2024年 01月 23日  22:36
 */
@Configuration
public class PasswordConfig {
//
    /**
     * 创建密码编码器的 Bean
     * @return 密码编码器
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
