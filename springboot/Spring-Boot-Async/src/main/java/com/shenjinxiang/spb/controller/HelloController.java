package com.shenjinxiang.spb.controller;

import com.shenjinxiang.spb.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/5/16 10:17
 */
@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private TestService testService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/async")
    public String async() {
        long time1 = System.currentTimeMillis();
        logger.info("异步controller方法开始...");
        testService.asyncMethod();
        logger.info("异步controller方法结束...");
        long time2 = System.currentTimeMillis();
        logger.info("异步耗时：" + (time2 - time1));
        return "async OK " + (time2 - time1);
    }

    @GetMapping("/asyncblock")
    public String asyncblock() throws ExecutionException, InterruptedException {
        long time1 = System.currentTimeMillis();
        logger.info("异步阻塞controller方法开始...");
        Future<String> future = testService.asyncblockMethod();
        String result = future.get();
        logger.info("异步阻塞controller方法结束...");
        long time2 = System.currentTimeMillis();
        logger.info("异步阻塞耗时：" + (time2 - time1));
        return "async OK " + (time2 - time1) + " " + result;
    }

    @GetMapping("/aync")
    public String aync() {
        long time1 = System.currentTimeMillis();
        logger.info("同步controller方法开始...");
        testService.ayncMethod();
        logger.info("同步controller方法结束...");
        long time2 = System.currentTimeMillis();
        logger.info("同步耗时：" + (time2 - time1));
        return "aync OK " + (time2 - time1);
    }
}
