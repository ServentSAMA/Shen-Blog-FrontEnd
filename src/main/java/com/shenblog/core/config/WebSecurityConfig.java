package com.shenblog.core.config;

import com.shenblog.core.authentication.BlogAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * 安全配置类
 *
 * @author ShenChuanBiao
 * @title: WebSecurityConfig
 * @projectName system
 * @description: TODO
 * @date 2022/3/25 16:42
 */
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    final private BlogAuthenticationProvider blogAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //排除不需要认证的
                .antMatchers("/swagger**/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/v2/**").permitAll()
                .antMatchers("/oauth/**").permitAll()
                //其他所有请求都需要认证
                .anyRequest().authenticated();
        http.authenticationProvider(blogAuthenticationProvider);
        http.formLogin();
    }

}
