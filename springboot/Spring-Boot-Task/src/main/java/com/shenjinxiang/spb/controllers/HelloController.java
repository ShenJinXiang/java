package com.shenjinxiang.spb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/6/22 06:25
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("")
    public String index() {
        return "Hello Spring-Boot-Task!";
    }
}
