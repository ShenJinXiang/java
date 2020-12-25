package com.shenjinxiang.netty.io;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UdpClient implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(UdpClient.class);

    private int port;

    public UdpClient(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        Bootstrap client = new Bootstrap();
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            client.group(group)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(new UdpHandler());
            Channel channel = client.bind(this.port).sync().channel();
            logger.info("启动UDP监听，端口：" + this.port);
            channel.closeFuture().await();
        } catch (Exception e) {
            logger.info("启动UDP监听出错，监听端口：" + this.port);
        } finally {
            group.shutdownGracefully();
        }
    }
}
