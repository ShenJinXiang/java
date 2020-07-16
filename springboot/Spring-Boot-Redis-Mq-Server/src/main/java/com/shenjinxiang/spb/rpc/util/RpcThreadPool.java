package com.shenjinxiang.spb.rpc.util;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/5/9 18:11
 */
@Component
public class RpcThreadPool {

    private ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public ExecutorService getThread() {
        return threadPool;
    }
}
