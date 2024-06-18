package com.atguigu;

import com.atguigu.config.AtguiguConfiguration;
import com.atguigu.controller.AccountController;
import com.atguigu.pojo.Account;
import com.atguigu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 包名:com.atguigu
 *
 * @author Leevi
 * 日期2023-05-04  09:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:spring.xml")
@ContextConfiguration(classes = AtguiguConfiguration.class)
public class SpringTest {
    @Autowired
    private AccountController accountController;

    @Autowired
    private UserService userService;

    /**
     * 查找所有的数据
     */
    @Test
    public void test01(){
//        System.out.println(accountController.findAll());
    }

    /**
     * 添加数据
     *
     * 测试事务的传播性
     */
    @Test
    public void test02() throws ClassNotFoundException {
        Account account = new Account(20001,"张三",99.99);
        accountController.save(account);
    }
//    @Test
//    public void test03(){
//        User user = new User(null,"lisi",22,"广东省-广州市-白云区");
//        userService.addUser(user);
//    }
}
