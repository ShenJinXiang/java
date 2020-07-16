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
@Order(1)
public class Runner1 implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Runner1.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("runner1 running...");
    }
}
