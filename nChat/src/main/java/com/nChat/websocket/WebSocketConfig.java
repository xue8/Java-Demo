package com.nChat.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        //这个网址是用于websocket连接的建立 通信用的
        webSocketHandlerRegistry
                .addHandler(new WebSocketHandler(), "/ws/socketServer")
                .addInterceptors(new WebSocketInterceptor())
                .setAllowedOrigins("*");
    }

}
