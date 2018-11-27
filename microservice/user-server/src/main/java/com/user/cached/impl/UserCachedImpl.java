package com.user.cached.impl;

import com.common.util.GsonUtil;
import com.user.cached.IUserCached;
import com.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;


import java.util.concurrent.TimeUnit;

@Repository
public class UserCachedImpl implements IUserCached<User> {

    @Autowired
    private StringRedisTemplate template;

    public ValueOperations<String, String> getopsForValue(){
        ValueOperations<String, String> ops = template.opsForValue();
        return ops;
    }

    @Override
    public void put(String key, User doamin, long expire) {
        String value= GsonUtil.toJson(doamin);
        getopsForValue().set(key,value, expire);
    }

    @Override
    public void remove(String key) {
        template.delete(key);
    }

    @Override
    public void setexpire(String key, Integer expire) {
        template.expire(key,expire, TimeUnit.SECONDS);
    }

    @Override
    public User get(String key) {
        String str=getopsForValue().get(key);
        return GsonUtil.fromJson(str,User.class);
    }


    @Override
    public void set(String key, String value) {
        getopsForValue().set(key,value);
    }

    @Override
    public boolean isKeyExists(String key) {
        return template.hasKey(key);
    }


}
