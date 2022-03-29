package com.shenblog.system.controller;

import com.shenblog.system.entity.SysUser;
import com.shenblog.system.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ShenChuanBiao
 * @title: UserController
 * @projectName system
 * @description: TODO
 * @date 2022/3/25 16:10
 */
@Api(tags = "用户相关")
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    private ISysUserService sysUserService;

    @ApiOperation(value = "创建用户")
    @PostMapping("/createUser")
    public String createUser(@RequestBody SysUser sysUser){
        sysUserService.save(sysUser);
        return "创建成功";
    }
    @ApiOperation(value = "创建用户")
    @PostMapping("/getUser")
    public String getUser(String id){
        SysUser byId = sysUserService.getById(id);
        return byId.getUsername();
    }

}
