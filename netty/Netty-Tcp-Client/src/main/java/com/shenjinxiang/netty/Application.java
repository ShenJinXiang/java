package com.shenjinxiang.netty;

import com.shenjinxiang.netty.io.CommandReader;
import com.shenjinxiang.netty.kit.ThreadPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/11/15 20:53
 */
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("Netty-Tcp-Client start...");
        ThreadPool.getThread().execute(new CommandReader());
    }

}
