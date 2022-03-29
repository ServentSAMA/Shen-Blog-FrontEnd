package com.shenblog.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ShenChuanBiao  文章
 * @title: IndexController
 * @projectName system
 * @description: TODO
 * @date 2022/3/25 16:44
 */
@Api(tags = "首页接口")
@Controller
public class IndexController {

    @ApiOperation(value = "首页接口")
    @GetMapping("/index")
    public String index() {

        return "index";
    }
}
