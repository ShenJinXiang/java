package com.shenjinxiang.netty.io;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TcpServerHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(TcpServerHandler.class);

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelRegistered, ctx: " + ctx +
                "\n\tchannel: " + ctx.channel() +
                "\n\tremoteAddress: " + ctx.channel().remoteAddress() +
                "\n\tid: " + ctx.channel().id()
        );
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelUnregistered, ctx: " + ctx +
                "\n\tchannel: " + ctx.channel() +
                "\n\tremoteAddress: " + ctx.channel().remoteAddress() +
                "\n\tid: " + ctx.channel().id()
        );
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelActive, ctx: " + ctx +
                "\n\tchannel: " + ctx.channel() +
                "\n\tremoteAddress: " + ctx.channel().remoteAddress() +
                "\n\tid: " + ctx.channel().id()
        );
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("channelRead, ctx: " + ctx +
                "\n\tchannel: " + ctx.channel() +
                "\n\tremoteAddress: " + ctx.channel().remoteAddress() +
                "\n\tid: " + ctx.channel().id() +
                "\n\tcontent: " + msg.toString()
        );
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.info("exceptionCaught, ctx: " + ctx +
                "\n\tchannel: " + ctx.channel() +
                "\n\tremoteAddress: " + ctx.channel().remoteAddress() +
                "\n\tid: " + ctx.channel().id() +
                "\n\tcause: " + cause.getMessage()
        );
    }
}
