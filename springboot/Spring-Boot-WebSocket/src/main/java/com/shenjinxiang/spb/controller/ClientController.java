package com.shenjinxiang.spb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/7/23 22:01
 */
@Controller
public class ClientController {

    @GetMapping("/client")
    public String index() {
        return "client";
    }
}
