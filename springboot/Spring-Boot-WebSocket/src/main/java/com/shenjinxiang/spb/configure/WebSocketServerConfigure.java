package com.shenjinxiang.spb.configure;

import com.shenjinxiang.spb.handler.StringWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/7/23 21:48
 */
@Configuration
@EnableWebSocket
public class WebSocketServerConfigure implements WebSocketConfigurer {

    @Autowired
    private StringWebSocketHandler webSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        // 当客户端通过/connect url和服务端连接通信时，使用 StringWebSocketHandler 处理会话
        webSocketHandlerRegistry.addHandler(webSocketHandler, "/connect").withSockJS();
    }
}
