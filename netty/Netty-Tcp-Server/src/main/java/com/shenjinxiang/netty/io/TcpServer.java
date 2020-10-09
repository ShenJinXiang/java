package com.shenjinxiang.netty.io;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

import java.nio.charset.StandardCharsets;

public class TcpServer implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(TcpServer.class);

    private int port;

    public TcpServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        EventLoopGroup boosGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap server = new ServerBootstrap();
        try {
            server.group(boosGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024 * 50));
                            socketChannel.pipeline().addLast(new StringDecoder(StandardCharsets.UTF_8));
                            socketChannel.pipeline().addLast(new TcpServerHandler());
                            socketChannel.pipeline().addLast(new StringEncoder(StandardCharsets.UTF_8));
                        }
                    });
            ChannelFuture channelFuture = server.bind(this.port).sync();
            logger.info("TCP服务启动，监听端口：" + port);
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            logger.error("启动TCP服务，端口[" + this.port + "]发生错误", e);
        }
    }
}
