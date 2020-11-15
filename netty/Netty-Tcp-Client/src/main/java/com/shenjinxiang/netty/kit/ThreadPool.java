package com.shenjinxiang.netty.kit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/11/15 20:59
 */
public class ThreadPool {

    private static ExecutorService threadPool;

    static {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("Nettp-Client-Thread-%d").build();
        int size = 20;
        threadPool = new ThreadPoolExecutor(size, size,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),
                namedThreadFactory);
    }

    private ThreadPool() {

    }

    public static ExecutorService getThread() {
        return threadPool;
    }
}
