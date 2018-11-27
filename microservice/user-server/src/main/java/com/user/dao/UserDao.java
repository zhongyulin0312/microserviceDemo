package com.user.dao;

import com.user.model.User;

public interface UserDao {

    /**
     *  登录查询
     * @param username  用户名
     * @param password  密码
     * @return
     */
    public User queryLogin(String username,String password);

    /**
     * 新增用户信息
     * @param user
     * @return
     */
    public int intsertUser(User user);

    /***
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    public User queryuser(Integer id);
}
