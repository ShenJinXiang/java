package com.shenjinxiang.netty.io;

import com.shenjinxiang.netty.kit.ThreadPool;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/11/15 21:27
 */
public class IoKit {

    private static final TcpClientHandler HANDLER = new TcpClientHandler();

    public static void runTcpClient(String serverIp, int serverPort) {
        TcpClient tcpClient = new TcpClient(serverIp, serverPort, HANDLER);
        ThreadPool.getThread().execute(tcpClient);
    }

    public static void close() {
        HANDLER.close();
    }

    public static void send(String msg) {
        HANDLER.sendMsg(msg);
    }
}
