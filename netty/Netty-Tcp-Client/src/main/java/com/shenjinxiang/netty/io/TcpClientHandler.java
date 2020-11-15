package com.shenjinxiang.netty.io;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/11/15 21:08
 */
@ChannelHandler.Sharable
public class TcpClientHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(TcpClientHandler.class);

    private ChannelHandlerContext context;
    protected boolean conn = false;

    public void sendMsg(String msg) {
        if (conn) {
            this.context.channel().writeAndFlush(msg + "\n");
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        this.context = ctx;
        this.conn = true;
        logger.info("建立链接，服务器：" + ctx.channel().remoteAddress());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf byteBuf = (ByteBuf) msg;
//        int readBytes = byteBuf.readableBytes();
//        byte[] bytes = new byte[readBytes];
//        byteBuf.readBytes(bytes);
        this.context = ctx;
        String content = msg.toString();
        logger.info("接收到内容：" + content);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("TCP链接，服务端出现错误", cause);
    }

    public void close() {
        if (conn) {
            this.context.close();
            logger.info("关闭TCP链接，地址[" + this.context.channel().remoteAddress() + "] ID: " + this.context.channel().id());
            conn = false;
        }
    }
}
