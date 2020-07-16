package com.shenjinxiang.spb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/28 15:26
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Spring Boot Jsoup XSS";
    }
}
