package com.shenjinxiang.netty.io;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TcpServerHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(TcpServerHandler.class);

    private Map<String, ChannelHandlerContext> CLIENT_MAP = new HashMap<>();

    public void logClients() {
        StringBuilder stringBuilder = new StringBuilder("客户端列表：");
        Iterator<Map.Entry<String, ChannelHandlerContext>> iterator = CLIENT_MAP.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ChannelHandlerContext> entry = iterator.next();
            stringBuilder.append("\n").append("ID: ").append(entry.getKey());
        }
        logger.info(stringBuilder.toString());
    }

    public void sendMsg(String msg) {
        Iterator<Map.Entry<String, ChannelHandlerContext>> iterator = CLIENT_MAP.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ChannelHandlerContext> entry = iterator.next();
            ChannelHandlerContext ctx = entry.getValue();
            ctx.channel().writeAndFlush(msg + "\n");
        }
    }

    public void sendMsg(String id, String msg) {
        if (CLIENT_MAP.containsKey(id)) {
            ChannelHandlerContext ctx = CLIENT_MAP.get(id);
            ctx.channel().writeAndFlush(msg + "\n");
        }
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelRegistered" +
                "\n\tctx: " + ctx +
                "\n\tchannel: " + ctx.channel() +
                "\n\tremoteAddress: " + ctx.channel().remoteAddress() +
                "\n\tid: " + ctx.channel().id()
        );
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        logger.info("客户端断开连接，地址: " + ctx.channel().remoteAddress() + " id: " + ctx.channel().id());
        CLIENT_MAP.remove(ctx.channel().id().toString());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("客户端建立连接，地址: " + ctx.channel().remoteAddress() + " id: " + ctx.channel().id());
        CLIENT_MAP.put(ctx.channel().id().toString(), ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info("客户端断开连接，地址: " + ctx.channel().remoteAddress() + " id: " + ctx.channel().id());
        CLIENT_MAP.remove(ctx.channel().id().toString());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String content = msg.toString();
        logger.info("接收到数据：" +
                "\n\t 客户端地址：" + ctx.channel().remoteAddress() +
                "\n\t ID: " + ctx.channel().id() +
                "\n\t 内容: " + content
        );
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("客户端通讯出错，地址: " + ctx.channel().remoteAddress() + " id: " + ctx.channel().id(), cause);
    }
}
