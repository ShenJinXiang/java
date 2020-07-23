package com.shenjinxiang.spb.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/7/23 21:38
 */
@Component
public class StringWebSocketHandler extends TextWebSocketHandler {

    private Logger logger = LoggerFactory.getLogger(StringWebSocketHandler.class);

    /**
     * 和客户端链接成功的时候触发该方法
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        logger.info("和客户端建立链接！");
    }

    /**
     * 和客户端建立连接后，处理客户端发送的文本消息请求
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String receiveMessage = message.getPayload();
        logger.info("接收到客户端信息：" + receiveMessage);
        session.sendMessage(new TextMessage("接收到消息了，内容：" + receiveMessage));
    }

    /**
     * 和客户端连接失败的时候触发该方法
     * @param session
     * @param exception
     * @throws Exception
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        logger.error("发生异常", exception);
        session.close(CloseStatus.NORMAL);
    }

    /**
     * 和客户端断开连接的时候触发该方法
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        logger.info("和客户端断开链接！");
    }
}
