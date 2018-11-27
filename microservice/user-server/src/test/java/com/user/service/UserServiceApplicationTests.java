package com.user.service;

import com.user.cached.IUserCached;
import com.user.main.UserServerApplication;
import com.user.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 单元测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserServerApplication.class)
@WebAppConfiguration
public class UserServiceApplicationTests {

    @Autowired
    @Qualifier("userService")
    public  UserService userService;

    @Autowired
    public IUserCached iUserCached;

    @Test
    public void contextLoads() {

    }

    @Test
    public  void testqueryLogin(){
        User user=userService.queryLogin("admin","$2a$10$DN2pLVR4Go.r/eas1uuHWuzZ1qQyV/G.mMwkj58e7jXcGUN39h1ny");
        System.out.print("user:"+user.getUsername());
    }

    @Test
    public void testset(){
        iUserCached.set("key","1234567");
    }

}
