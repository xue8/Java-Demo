package cn.ddnd.www.Service;

import cn.ddnd.www.Dao.UserDao;
import cn.ddnd.www.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Uservice {

    @Autowired
    UserDao userDao;

    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }
}
