package com.atguigu.dao;

import com.atguigu.pojo.User;

/**
 * @author : chen wei
 * @date : 2023/5/12 20:49
 * @Version: 1.0
 * @Description : 用户持久层接口
 */
public interface UserDao {
    boolean adduser(User user);
}
