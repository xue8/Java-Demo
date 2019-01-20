package com.nChat.websocket;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Collection;
import java.util.Map;

public class WebSocketInterceptor extends HttpSessionHandshakeInterceptor {
    public WebSocketInterceptor() {
        super();
    }

    public WebSocketInterceptor(Collection<String> attributeNames) {
        super(attributeNames);
    }

    @Override
    public Collection<String> getAttributeNames() {
        return super.getAttributeNames();
    }

    @Override
    public void setCopyAllAttributes(boolean copyAllAttributes) {
        super.setCopyAllAttributes(copyAllAttributes);
    }

    @Override
    public boolean isCopyAllAttributes() {
        return super.isCopyAllAttributes();
    }

    @Override
    public void setCopyHttpSessionId(boolean copyHttpSessionId) {
        super.setCopyHttpSessionId(copyHttpSessionId);
    }

    @Override
    public boolean isCopyHttpSessionId() {
        return super.isCopyHttpSessionId();
    }

    @Override
    public void setCreateSession(boolean createSession) {
        super.setCreateSession(createSession);
    }

    @Override
    public boolean isCreateSession() {
        return super.isCreateSession();
    }

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        //在这里拦截请求 在捂手前将uid保存到WebSocketSession中 让处理器WebSocketHandler根据这个uid进行操作
        ServletServerHttpRequest servletServerHttpRequest = (ServletServerHttpRequest) request;
        int uid = Integer.parseInt(servletServerHttpRequest.getServletRequest().getParameter("uid"));
        System.out.println("coming " + uid);
        if (uid != 0) {
            attributes.put("WEBSOCKET_UID", uid);
        }
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
        System.out.println("out");
        super.afterHandshake(request, response, wsHandler, ex);
    }
}
