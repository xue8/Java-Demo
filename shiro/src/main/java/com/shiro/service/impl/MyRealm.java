package com.shiro.service.impl;

import com.shiro.entity.Role;
import com.shiro.entity.User;
import com.shiro.service.AccountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: shiro
 * @description:
 * @author: Xue 8
 * @create: 2019-02-01 15:16
 **/

public class MyRealm extends AuthorizingRealm {
    @Resource
    AccountService accountService;

    /**
      * 身份认证的方法 认证成功获取身份验证信息
     * 这里最主要的是user.login(token);这里有一个参数token，这个token就是用户输入的用户密码，
     * 我们平时可能会用一个对象user来封装用户名和密码，shiro用的是token，这个是控制层的代码，还没到shiro，
     * 当调用user.login(token)后，就交给shiro去处理了，接下shiro应该是去token中取出用户名，然后根据用户去查数据库，
     * 把数据库中的密码查出来。这部分代码一般都是要求我们自定义实现，自定义一个realm，重写doGetAuthenticationInfo方法
    **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        获取用户输入的用户名和密码
//        实际上这个token是从UserResource面currentUser.login(token)传过来的
//        两个token的引用都是一样的
        String username = (String) authenticationToken.getPrincipal();
//        密码要用字符数组来接受 因为UsernamePasswordToken(username, password) 储存密码的时候是将字符串类型转成字符数组的 查看源码可以看出
        String password = new String((char[]) authenticationToken.getCredentials());
//        调用service 根据用户名查询用户信息
        User user = accountService.findUserByUsername(username);
//        String password = user.getPassword();
//        判断用户是否存在 不存在则抛出异常
        if (user != null) {
//            判断用户密码是否匹配 匹配则不匹配则抛出异常
            if (user.getPassword().equals(password)) {
//                登录成功 把用户信息储存在Session中
                Session session = SecurityUtils.getSubject().getSession();
                session.setAttribute("userSession", user);
                session.setAttribute("userSessionId", user.getId());
//                认证成功 返回一个AuthenticationInfo的实现
                return new SimpleAuthenticationInfo(username, password, getName());
            } else {
                System.out.println("密码不正确");
                throw new IncorrectCredentialsException();
            }
        } else {
            System.out.println("账号不存在");
            throw new UnknownAccountException();
        }
    }

    /**
      * 授权的方法
     * 1、subject.hasRole(“admin”) 或 subject.isPermitted(“admin”)：自己去调用这个是否有什么角色或者是否有什么权限的时候；
     *
     * 2、@RequiresRoles("admin") ：在方法上加注解的时候；
     *
     * 3、[@shiro.hasPermission name = "admin"][/@shiro.hasPermission]：在页面上加shiro标签的时候，即进这个页面的时候扫描到有这个标签的时候。
     * 4、xml配置权限的时候也会走
    **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");
//        从principalCollection获取用户信息
//        如果doGetAuthenticationInfo(user,password,getName()); 传入的是user类型的数据 那这里getPrimaryPrincipal获取到的也是user类型的数据
        String username = (String) principalCollection.getPrimaryPrincipal();
        User user = accountService.findUserByUsername(username);
//        获取该用户的所有角色
        List<Role> roleList = accountService.findRoleByUserId(user.getId());
//        将角色的id放到一个String列表中 因为authorizationInfo.addRoles()方法只支持角色的String列表或者单个角色String
        List<String> roleIdList = new ArrayList<String>();
        for (Role role:roleList) {
            roleIdList.add(role.getName());
        }
//        获取该用户的所有权限
        List<com.shiro.entity.Resource> resourceList = accountService.findResourceByUserId(user.getId());
        List<String> resourceIdList = new ArrayList<String>();
//        将权限id放到一个String列表中 因为authorizationInfo.addRoles()方法只支持角色的String列表或者单个角色String
        for (com.shiro.entity.Resource resource:resourceList) {
            resourceIdList.add(resource.getName());
        }
        System.out.println("授权11");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        添加用户的角色
        authorizationInfo.addRoles(roleIdList);
//        添加用户的权限
        authorizationInfo.addStringPermissions(resourceIdList);
        return authorizationInfo;
    }
}
