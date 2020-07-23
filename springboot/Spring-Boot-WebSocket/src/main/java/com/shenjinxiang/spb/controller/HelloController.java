package com.shenjinxiang.spb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/7/23 21:35
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String index() {
        return "Spring Boot WebSocket!";
    }
}
