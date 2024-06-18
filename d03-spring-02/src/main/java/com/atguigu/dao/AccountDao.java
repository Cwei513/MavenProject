package com.atguigu.dao;

import com.atguigu.pojo.Account;

import java.util.List;

/**
 * 包名:com.atguigu.dao
 *
 * @author Leevi
 * 日期2023-05-04  10:41
 */
public interface AccountDao {
    List<Account> findAll();
    Account findById(Integer id);
    void save(Account account);
    void update(Account account);
    void deleteById(Integer id);
}
