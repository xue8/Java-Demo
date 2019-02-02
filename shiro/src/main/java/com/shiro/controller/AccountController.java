package com.shiro.controller;

import com.shiro.entity.User;
import com.shiro.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: shiro
 * @description:
 * @author: Xue 8
 * @create: 2019-02-01 13:14
 **/
@Controller
public class AccountController {
    @Resource
    AccountService accountService;
    @Resource
    HttpServletRequest servletRequest;

    @RequestMapping(value = "/home")
    public String  home(){
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String  getLogin(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if (accountService.login(user)) {
            return "/home";
        }
        return "/login";
    }
}
