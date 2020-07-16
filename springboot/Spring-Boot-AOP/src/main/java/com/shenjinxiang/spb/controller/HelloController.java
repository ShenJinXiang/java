package com.shenjinxiang.spb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/6 20:18
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello aop";
    }
}
