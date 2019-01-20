package com.nChat.controller;

import com.nChat.websocket.WebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    WebSocketHandler webSocketHandler;

    @RequestMapping("/send")
    public String send(HttpServletRequest request,
                        HttpServletResponse response){
        return "send";
    }

    @RequestMapping("/doSend")
    public String doSend(HttpServletRequest request,
                       HttpServletResponse response,
                       @RequestParam(value = "uid") int uid,
                       @RequestParam(value = "messages") String messages){

        HttpSession session = request.getSession(true);
        session.setAttribute("SESSION_USERNAME", uid);
        webSocketHandler.sendMessageToUser(uid,new TextMessage(messages));
        return "send";
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request,
                        HttpServletResponse response){

        return "register";
    }

}
