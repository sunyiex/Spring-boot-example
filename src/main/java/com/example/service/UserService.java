package com.example.service;

import com.example.dao.UserDao;
import com.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by SunYi on 2016/2/1/0001.
 */
@Service
public class UserService {
    //自动注入一个userDao
    @Autowired
    private UserDao userDao;

    //用户注册逻辑
    public String  register(User user) {
        //判断用户是否存在
        if (userDao.getOneUser(user.getUsername()) == null) {
            userDao.setOneUser(user);
            return "注册成功";
        }
        else {
            return "该用户名已被使用";
        }
    }
    //用户登陆逻辑
    public String login(User user) {
        //通过用户名获取用户
        User dbUser = userDao.getOneUser(user.getUsername());
        //若获取失败
        if (dbUser == null) {
            return "该用户不存在";
        }
        //获取成功后，将获取用户的密码和传入密码对比
        else if (!dbUser.getPassword().equals(user.getPassword())){
            return "密码错误";
        }
        else {
            //若密码也相同则登陆成功
            //让传入用户的属性和数据库保持一致
            user.setId(dbUser.getId());
            user.setCreateTime(dbUser.getCreateTime());
            return "登陆成功";
        }
    }
}
