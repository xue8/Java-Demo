//package com.nChat.websocket;
//
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.http.server.ServletServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
//
//import javax.servlet.http.HttpSession;
//import java.util.Map;
//
//@Component
//public class WebSocketInterceptor111111 extends HttpSessionHandshakeInterceptor {
//    @Override
//    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
//                                   Map<String, Object> attributes) throws Exception {
//        // TODO Auto-generated method stub
//        if (request instanceof ServletServerHttpRequest) {
//            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
//            HttpSession session = servletRequest.getServletRequest().getSession(false);
//            if (session != null) {
//                //使用userName区分WebSocketHandler，以便定向发送消息
//                String userName = (String) session.getAttribute("SESSION_USERNAME");
//                if (userName==null) {
//                    userName="default-system";
//                }
//                attributes.put("WEBSOCKET_USERNAME",userName);
//            }
//        }
//        System.out.println("握手开始" +attributes);
//        return super.beforeHandshake(request, response, wsHandler, attributes);
//
//    }
//
//    @Override
//    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
//                               Exception ex) {
//        // TODO Auto-generated method stub
//        System.out.println("握手完成");
//        super.afterHandshake(request, response, wsHandler, ex);
//    }
//}
