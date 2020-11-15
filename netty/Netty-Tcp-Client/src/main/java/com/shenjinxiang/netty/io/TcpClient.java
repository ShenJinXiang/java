package com.shenjinxiang.netty.io;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/11/15 21:05
 */
public class TcpClient implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(TcpClient.class);

    private String serverIp;
    private int serverPort;
    private TcpClientHandler handler;

    public TcpClient(String serverIp, int serverPort, TcpClientHandler handler) {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        this.handler = handler;
    }

    @Override
    public void run() {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap client = new Bootstrap();
        try {
            client.group(group);
            client.channel(NioSocketChannel.class);
            client.handler(new ChannelInitializer() {
                @Override
                protected void initChannel(Channel channel) throws Exception {
                    channel.pipeline().addLast(new LineBasedFrameDecoder(1024 * 50));
                    channel.pipeline().addLast(new StringDecoder(CharsetUtil.UTF_8));
                    channel.pipeline().addLast(handler);
                    channel.pipeline().addLast(new StringEncoder(CharsetUtil.UTF_8));
                }
            });
            ChannelFuture channelFuture = client.connect(this.serverIp, this.serverPort).sync();
            logger.info("TCP客户端启动，目标服务器: [" + this.serverIp + ":" + this.serverPort + "]");
            channelFuture.channel().closeFuture().sync();

        } catch (Exception e) {
            logger.info("启动TCP客户端，目标服务器: [" + this.serverIp + ":" + this.serverPort + "] 出错", e);
        } finally {
            group.shutdownGracefully();
        }

    }
}
