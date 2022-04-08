package com.shenblog.core.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis配置类
 * @author ShenChuanBiao
 * @title: MybatisConfig
 * @projectName system
 * @description: TODO
 * @date 2022/3/29 19:43
 */
@Configuration
@MapperScan(basePackages = "com.shenblog.**.mapper*")
public class MybatisConfig {
}
