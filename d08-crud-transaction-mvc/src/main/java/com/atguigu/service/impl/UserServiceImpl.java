package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : chen wei
 * @date : 2023/5/12 20:51
 * @Version: 1.0
 * @Description : 用户业务层接口
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Transactional(propagation = Propagation.REQUIRED)
    //添加事务,传播性为默认的REQUIRED，有事务则加入当前事务，如果当前没有事务则新建事务
    @Override
    public void addUser(User user) {
        userDao.adduser(user);
    }

}
