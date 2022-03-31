package com.shenblog.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页控制类
 * @author ShenChuanBiao
 * @title: IndexController
 * @projectName system
 * @description: TODO
 * @date 2022/3/25 16:44
 */
@Api(tags = "首页接口")
@RestController
public class IndexController {

    @ApiOperation(value = "首页接口")
    @GetMapping("/index")
    public String index(@AuthenticationPrincipal Jwt jwt) {

        return "hello" + jwt.getSubject();
    }
}
