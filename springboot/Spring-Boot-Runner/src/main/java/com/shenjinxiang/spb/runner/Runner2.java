package com.shenjinxiang.spb.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/6/21 19:47
 */
@Component
@Order(2)
public class Runner2 implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Runner2.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("runner2 running...");
    }
}
