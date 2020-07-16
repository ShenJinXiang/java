package com.shenjinxiang.spb.controller;

import com.shenjinxiang.spb.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/15 15:30
 */
@RestController
@RequestMapping("/redis")
public class RedisController {


    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/set")
    public boolean redisSet(String key, String value) {
        return redisUtil.set(key, value);
    }

    @RequestMapping("/get")
    public Object redisGet(String key) {
        return redisUtil.get(key);
    }
}
