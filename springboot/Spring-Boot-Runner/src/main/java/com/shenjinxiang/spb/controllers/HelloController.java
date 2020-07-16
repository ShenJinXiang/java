package com.shenjinxiang.spb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/6/21 19:39
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Shenjinxiang!";
    }
}
