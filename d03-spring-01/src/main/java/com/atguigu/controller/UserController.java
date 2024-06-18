package com.atguigu.controller;

import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 包名:com.atguigu.controller
 *
 * @author Leevi
 * 日期2023-05-04  09:27
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public UserController() {
//        System.out.println("UserController被创建了...");
    }

    public void sayUsername(){
        System.out.println(userService.getUsername());
    }

    //@PostConstruct
    public void init(){
        System.out.println("UserController被初始化了...");
    }

   // @PreDestroy
    public void destroy(){
        System.out.println("UserController被销毁了...");
    }
}
