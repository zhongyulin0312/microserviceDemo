package com.user.dao.impl;

import com.user.dao.UserDao;
import com.user.dao.mapper.UserMapper;
import com.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    public UserMapper userMapper;

    @Override
    public User queryLogin(String username, String password) {
        return userMapper.queryLogin(username,password);
    }

    @Override
    public int intsertUser(User user) {
        return userMapper.intsertUser(user);
    }

    @Override
    public User queryuser(Integer id) {
        return userMapper.queryuser(id);
    }
}
