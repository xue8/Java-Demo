package cn.ddnd.www.Dao;

import cn.ddnd.www.Entity.User;

public interface UserDao {
    public User getUserByEmail(String email);
}
