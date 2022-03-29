package com.shenblog;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 博客启动类
 *
 * @author 申传彪
 * @date 2022/3/25
 */
@Slf4j
@SpringBootApplication(scanBasePackages = "com.shenblog")
public class BlogApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(BlogApplication.class, args);
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
