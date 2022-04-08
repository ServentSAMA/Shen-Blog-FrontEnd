package com.shenblog.core.authentication;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author ShenChuanBiao
 * @title: AuthenticationProviderImpl
 * @projectName system
 * @description: TODO
 * @date 2022/3/25 18:13
 */
@Component
@RequiredArgsConstructor
public class BlogAuthenticationProvider implements AuthenticationProvider {

    final private PasswordEncoder passwordEncoder;
    final private UserDetailsServiceImpl userDetailsServiceImpl;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);

        if (passwordEncoder.matches(password,userDetails.getPassword())) {

            return new UsernamePasswordAuthenticationToken(username,password,userDetails.getAuthorities());
        }else {
            throw new BadCredentialsException("密码不正确，请输入正确密码!");
        }
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
