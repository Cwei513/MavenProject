package com.atguigu.service;

import com.atguigu.pojo.Account;

import java.util.List;

/**
 * 包名:com.atguigu.service
 *
 * @author Leevi
 * 日期2023-05-04  10:47
 */
public interface AccountService {
    List<Account> findAll();
    Account findById(Integer id);
    void save(Account account) throws ClassNotFoundException;
    void update(Account account);
    void deleteById(Integer id);
}
