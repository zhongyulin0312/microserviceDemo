package com.user.service.impl;

import com.user.dao.UserDao;
import com.user.model.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;

    @Override
    public User queryLogin(String username, String password) {
        return userDao.queryLogin(username,password);
    }

    @Override
    public int intsertUser(User user) {
        return userDao.intsertUser(user);
    }

    @Override
    public User queryuser(Integer id) {
        return userDao.queryuser(id);
    }
}
