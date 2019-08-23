package com.dt.Test;


import com.dt.dao.Impl.UserDaoImpl;
import com.dt.dao.UserDao;
import com.dt.entity.User;
import com.dt.service.UserService;
import com.dt.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @ Author     ：mmzs.
 * @ Date       ：Created in 11:48 2019/8/9
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class LoginTest {

    UserDao userDao = new UserDaoImpl();
    UserService userService = new UserServiceImpl();

    @Test
    public void loginTest() {
        User user = userDao.findUserByUsernameAndPassword("zhangsan", "123");
        System.out.println(user);
    }

    @Test
    public void service() {
        User user = userService.login(userDao.findUserByUsernameAndPassword("zhangsan", "123"));
        System.out.println(user);
    }

    @Test
    public void selectAll() {
        List<User> users = userService.findAll();
        System.out.println(users);
    }
}
