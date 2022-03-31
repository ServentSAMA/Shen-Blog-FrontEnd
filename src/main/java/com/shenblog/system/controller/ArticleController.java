package com.shenblog.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ShenChuanBiao
 * @title: ArticleController
 * @projectName system
 * @description: TODO
 * @date 2022/3/28 13:18
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("/details")
    public String details(){

        return null;
    }


}
