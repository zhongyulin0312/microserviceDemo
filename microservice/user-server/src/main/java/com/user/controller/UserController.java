package com.user.controller;

import com.common.bean.BaseBean;
import com.common.bean.MsgCode;
import com.user.model.User;
import com.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 用户操作
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    private static Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    @Qualifier("userService")
    public UserService userService;

    @ApiOperation(value = "注册用户",notes ="username 和 password 必要参数")
    @RequestMapping(value = "registry",method = RequestMethod.POST)
    public String registry(String username, String password){
        BaseBean baseBean=new BaseBean();
       if(StringUtils.isBlank(username)){
           baseBean.setCode(MsgCode.PRARAM_ERROR);
           baseBean.setMsg("username 参数不能为空");
           return baseBean.toGsonBuilder();
       }else if(StringUtils.isBlank(password)){
           baseBean.setCode(MsgCode.PRARAM_ERROR);
           baseBean.setMsg("password 参数不能为空");
           return baseBean.toGsonBuilder();
       }
        try {
            User user=new User();
            user.setUsername(username);
            user.setPassword(password);
            int code=userService.intsertUser(user);
            if(code>0){
                baseBean.setCode(MsgCode.SUCCESS);
                baseBean.setMsg(MsgCode.SUCCESS_MSG);
            }else{
                baseBean.setCode(MsgCode.SERVICE_ERROR);
                baseBean.setMsg("用户添加失败");
            }
        }catch (Exception e){
            baseBean.setCode(MsgCode.SYSTEM_ERROR);
            baseBean.setMsg(MsgCode.SYSTEM_ERROR_MSG);
        }
       return baseBean.toGsonBuilder();
    }

    @ApiOperation(value = "登录",notes ="username 和 password 必要参数")
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(String username, String password){
        BaseBean baseBean=new BaseBean();
        if(StringUtils.isBlank(username)){
            baseBean.setCode(MsgCode.PRARAM_ERROR);
            baseBean.setMsg("username 参数不能为空");
            return baseBean.toGsonBuilder();
        }else if(StringUtils.isBlank(password)){
            baseBean.setCode(MsgCode.PRARAM_ERROR);
            baseBean.setMsg("password 参数不能为空");
            return baseBean.toGsonBuilder();
        }
        try {
            User user=userService.queryLogin(username,password);
            if(user==null){
                baseBean.setCode(MsgCode.SERVICE_ERROR);
                baseBean.setMsg("用户名或密码错误");
            }
            logger.info("执行完成");
        }catch (Exception e){
            baseBean.setCode(MsgCode.SYSTEM_ERROR);
            baseBean.setMsg(MsgCode.SYSTEM_ERROR_MSG);
        }
        return baseBean.toGsonBuilder();
    }

    @ApiOperation(value = "查询用户详情",notes ="id 必要参数")
    @RequestMapping(value = "queryUser",method = RequestMethod.GET)
    public String queryUser(Integer id){
        BaseBean baseBean=new BaseBean();
        try {
            if(id==null || id==0){
                baseBean.setCode(MsgCode.PRARAM_ERROR);
                baseBean.setMsg("id 参数不能为空");
                return baseBean.toGsonBuilder();
            }
            User user=userService.queryuser(id);
            baseBean.setCode(MsgCode.SUCCESS);
            baseBean.setMsg(MsgCode.SUCCESS_MSG);
            baseBean.setData(user);
            return baseBean.toGsonBuilder();
        }catch (Exception e){
            baseBean.setCode(MsgCode.SYSTEM_ERROR);
            baseBean.setMsg(MsgCode.SYSTEM_ERROR_MSG);
        }
        return baseBean.toGsonBuilder();
    }
}
