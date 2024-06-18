package com.atguigu.controller;

import com.atguigu.pojo.Account;
import com.atguigu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * 包名:com.atguigu.controller
 *
 * @author Leevi
 * 日期2023-05-04  10:49
 */
@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    public List<Account> findAll(){
        return accountService.findAll();
    }
    public Account findById(Integer id){
        return accountService.findById(id);
    }
    public void save(Account account){
        accountService.save(account);
    }

    void update(Account account){
        accountService.update(account);
    }
    void deleteById(Integer id){
        accountService.deleteById(id);
    }
}
