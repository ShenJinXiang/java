package com.shenjinxiang.spb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/5/16 10:21
 */
@Service
public class TestService {

    private static final Logger logger = LoggerFactory.getLogger(TestService.class);

    @Async("asyncThreadPoolTaskExecutor")
    public void asyncMethod() {
        logger.info("异步方法开始...");
        sleep();
        logger.info("异步方法结束...");
    }

    public void ayncMethod() {
        logger.info("同步方法开始...");
        sleep();
        logger.info("同步方法结束...");
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async("asyncThreadPoolTaskExecutor")
    public Future<String> asyncblockMethod() {
        logger.info("异步阻塞方法开始...");
        sleep();
        logger.info("异步阻塞方法结束...");
        return new AsyncResult<>("hello asyncblockMethod");
    }
}
