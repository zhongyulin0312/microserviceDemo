package com.user.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;


/**
 * User-server服务启动
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.user"})    //一定要加注解扫描，不然无法加载注解
//@EnableTransactionManagement //如果mybatis中service实现类中加入事务注解，需要此处添加该注解
@MapperScan("com.user.dao.mapper")  //扫描mapper包
@EnableHystrixDashboard
@EnableHystrix
public class UserServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServerApplication.class, args);
    }
}
