package com.atguigu.service.impl;

import com.atguigu.aspect.AtguiguCache;
import com.atguigu.dao.AccountDao;
import com.atguigu.pojo.Account;
import com.atguigu.service.AccountService;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 包名:com.atguigu.service.impl
 *
 * @author Leevi
 * 日期2023-05-04  10:48
 */
@Service
public class AccountServiceImpl implements AccountService {
    private Map<String,Object> cache = new HashMap<>();
    @Autowired
    private AccountDao accountDao;

    //注入继承了UserService接口的对象
    @Autowired
    private UserService userService;

    @AtguiguCache
    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @AtguiguCache
    @Override
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }


    // 事务的注解
    //这个是RuntimeException异常不回滚 noRollbackFor = {RuntimeException.class}
    //这个是Exception异常回滚 rollbackFor = {Exception.class},
    //propagation：设置当前事务的传播性，没有设置默认为REQUIRED

    //rollbackFor = {Exception.class},运行时和编译时都回滚，
    //noRollbackFor = {RuntimeException.class}，运行时不回滚
    @Transactional(readOnly = false,
                    timeout = 3,
                    rollbackFor = {Exception.class},
                    noRollbackFor = {ClassNotFoundException.class},
                    isolation = Isolation.REPEATABLE_READ,
                    propagation = Propagation.SUPPORTS)
    @Override
    public void save(Account account) throws ClassNotFoundException {//这是外层方法

//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        accountDao.save(account);

//        userService.addUser(new User(null,"zhangsan",23,"广东省-广州市-白云区"));//这是外层方法

        //运行时异常
//        int i = 10/0;
        //编译时异常：
        // Class.forName("dauiwdh");//类未找到异常，不是运行时异常，设置了rollbackFor属性 不会触发事务的回滚，
        //注意这里不要手动抛出异常
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    public void deleteById(Integer id) {
        accountDao.deleteById(id);
    }



}
