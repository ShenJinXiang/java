package com.shenjinxiang.spb.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/6/21 19:47
 */
//@Component
public class Runner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("runner running...");
    }
}
