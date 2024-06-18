package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 包名:com.atguigu.service.impl
 *
 * @author Leevi
 * 日期2023-05-04  10:00
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public String getUsername() {
        return userDao.getUsername();
    }
}
