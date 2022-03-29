package com.shenblog.system.controller;

import com.shenblog.system.entity.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ShenChuanBiao
 * @title: LoginController
 * @projectName system
 * @description: TODO
 * @date 2022/3/25 17:52
 */
@Api(tags = "登录相关")
@RestController
@RequestMapping("/sys")
public class LoginController {

    private UserDetailsService userDetailsService;

    @ApiOperation(value = "登录")
    @GetMapping("login")
    public String login(@RequestBody SysUser sysUser){
        userDetailsService.loadUserByUsername(sysUser.getUsername());

        return "登录成功了";
    }

}
