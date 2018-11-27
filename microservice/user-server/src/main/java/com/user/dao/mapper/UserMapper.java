package com.user.dao.mapper;

import com.user.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    /**
     *  登录查询
     * @param username  用户名
     * @param password  密码
     * @return
     */
    public User queryLogin(@Param("username") String username,@Param("password") String password);

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
    public User queryuser(@Param("id") Integer id);
}
