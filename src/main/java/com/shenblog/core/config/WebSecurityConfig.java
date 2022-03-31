package com.shenblog.core.config;

import com.shenblog.core.authentication.BlogAuthenticationProvider;
import com.shenblog.system.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import java.security.interfaces.RSAPublicKey;


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
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{


    @Autowired private BlogAuthenticationProvider blogAuthenticationProvider;

    @Value("${spring.security.oauth2.resourceserver.jwt.public-key-location}")
    RSAPublicKey key;

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
//        http.oauth2ResourceServer((oauth2ResourceServer) ->
//                oauth2ResourceServer
//                        .jwt((jwt) ->
//                                jwt.decoder(jwtDecoder())
//                        )
//        );
        http.authenticationProvider(blogAuthenticationProvider);
        http.formLogin();
    }

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(this.key).build();
    }

}
