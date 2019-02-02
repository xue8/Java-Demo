package com.shiro.service;

import com.shiro.entity.Resource;
import com.shiro.entity.Role;
import com.shiro.entity.User;

import java.util.List;

public interface AccountService {
    User findUserByUsername(String username);
    List<Role> findRoleByUserId(int id);
    List<Resource> findResourceByUserId(int id);
    boolean login(User user);
}
