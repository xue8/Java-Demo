//package com.nChat.websocket;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//加上@Configuration注解，将这个类作为Spring的XML配置文件中的<beans>，配置Spring容器应用上下文。
//@Configuration
//@EnableWebMvc
//@EnableWebSocket
//public class WebSocketConfig111 implements WebSocketConfigurer {
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        System.out.println("ws入口");
//        //第一步：配置只在项目启动后 进入该配置 这个配置只在项目启动的时候启动一次
//        //注册handle、访问的URL、拦截器等，之后请求这个URL都会被拦截器拦截。
//        //第二步执行拦截器：拦截器只会在握手时候执行（握手前和握手后）建立起连接后都不会再执行拦截器了。
//        //第三步执行handle：handle是在连接符合某种操作后就会执行相应的方法。
//
//        //addHandler注册处理器 addInterceptors注册拦截器
//        registry.addHandler(webSocketHandler(),"/websocket/socketServer.do").addInterceptors(new WebSocketInterceptor111111());
//        registry.addHandler(webSocketHandler(), "/sockjs/socketServer.do").addInterceptors(new WebSocketInterceptor111111()).withSockJS();
//    }
//
//    //加上@Bean注解，让项目启动的时候将这个方法注册到Spring 托管给Spring，所以registry.addHandler(webSocketHandler())才能直接调用
//    @Bean
//    public TextWebSocketHandler webSocketHandler(){
//        System.out.println("ws入口1");
//        return new NChatWebSocketHandler11111111();
//    }
//}
