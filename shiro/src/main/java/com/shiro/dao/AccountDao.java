package com.shiro.dao;

import com.shiro.entity.Resource;
import com.shiro.entity.Role;
import com.shiro.entity.User;

import java.util.List;

public interface AccountDao {
    User findUserByUsername(String username);
    List<Role> findRoleByUserId(int id);
    List<Resource> findResourceByUserId(int id);
}
