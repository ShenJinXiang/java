package com.shenjinxiang.netty;

import com.shenjinxiang.netty.io.TcpServer;
import com.shenjinxiang.netty.kit.ThreadPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("Netty-Tcp-Server Start...");
        ThreadPool.getThread().execute(new TcpServer(7777));
    }
}
