package com.user.cached;


import java.util.List;
import java.util.Set;

/**
 * 缓存
 */
public interface IUserCached<T> {

    /**
     * 添加
     *
     * @param key    key
     * @param doamin 对象
     * @param expire 过期时间(单位:秒),传入 -1 时表示不设置过期时间
     */
    public void put(String key, T doamin, long expire);

    /**
     * 添加设置值
     * @param key  key
     * @param value value
     */
    public void set(String key,String value);

    /**
     * 删除
     *
     * @param key 传入key的名称
     */
    public void remove(String key);


    /**
     * 查询
     *
     * @param key 查询的key
     * @return
     */
    public T get(String key);


    /**
     * 判断key是否存在redis中
     *
     * @param key 传入key的名称
     * @return
     */
    public boolean isKeyExists(String key);


    /**
     * 设置key失效时间 单位(秒)
     * @param key
     * @param expire
     */
    public void setexpire(String key,Integer expire);

}
