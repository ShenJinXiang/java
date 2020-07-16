package com.shenjinxiang.spb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/5/11 15:51
 */
@Controller
@RequestMapping("/users")
public class UserController {


    @GetMapping("")
    public String users() {
        if (true) {
            throw new RuntimeException("user Biz error");
        }
        return "user";
    }
}
