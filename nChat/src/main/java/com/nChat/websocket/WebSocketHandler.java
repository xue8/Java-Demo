package com.nChat.websocket;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Service
public class WebSocketHandler extends TextWebSocketHandler {

    public static final Map<Integer,WebSocketSession> USER_SOCKET_SESSION_MAP;
    static{
            USER_SOCKET_SESSION_MAP = new HashMap<Integer, WebSocketSession>();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        int uid = Integer.parseInt(session.getAttributes().get("WEBSOCKET_UID").toString());
        //如果是新的用户连接 则将session保存在USER_SOCKET_SESSION_MAP中
        if (USER_SOCKET_SESSION_MAP.get(uid) == null || !USER_SOCKET_SESSION_MAP.get(uid).isOpen()) {
            USER_SOCKET_SESSION_MAP.put(uid, session);
        }
        super.afterConnectionEstablished(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        super.handleMessage(session, message);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
    }

    @Override
    protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
        super.handlePongMessage(session, message);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        super.handleTransportError(session, exception);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
    }

    @Override
    public boolean supportsPartialMessages() {
        return super.supportsPartialMessages();
    }

    /**
     * @description: 给指定用户发送信息
     * @param: [uid, message]
     * @return: void
     * @author: Xue 8
     * @date: 2019/1/19
     */
    public void sendMessageToUser(int uid, TextMessage message){
        WebSocketSession session = USER_SOCKET_SESSION_MAP.get(uid);
        if (session != null && session.isOpen()) {
            try {
                session.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
