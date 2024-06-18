package com.atguigu.dao.impl;

import com.atguigu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

/**
 * 包名:com.atguigu.dao.impl
 *
 * @author Leevi
 * 日期2023-05-04  10:00
 */
@Repository(value = "userDaoImpl")
@PropertySource("classpath:application.properties")
public class UserDaoImpl implements UserDao {

    @Value("${info.username}")
    private String username;

    public UserDaoImpl() {
    }

    @Override
    public String getUsername() {
        return username;
    }
}
