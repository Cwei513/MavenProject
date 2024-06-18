package com.atguigu.mappers;

import com.atguigu.pojo.Account;

import java.util.List;

/**
 * @Author : chen wei
 * @Date : 2024/06/15 13:37
 * @Version: 1.0
 * @Description :
 */
public interface AccountMapper {
    List<Account> findAll();
}
