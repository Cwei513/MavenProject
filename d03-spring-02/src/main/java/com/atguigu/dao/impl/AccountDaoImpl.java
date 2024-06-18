package com.atguigu.dao.impl;

import com.atguigu.dao.AccountDao;
import com.atguigu.pojo.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * 包名:com.atguigu.dao.impl
 *
 * @author Leevi
 * 日期2023-05-04  10:42
 */
@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private QueryRunner queryRunner;

    @Override
    public List<Account> findAll() {
        try {
            String sql = "SELECT account_id accountId,account_name accountName,money FROM t_account";
            return queryRunner.query(sql,new BeanListHandler<>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findById(Integer id) {
        try {
            String sql = "SELECT account_id accountId,account_name accountName,money FROM t_account WHERE account_id=?";
            return queryRunner.query(sql,new BeanHandler<>(Account.class),id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Account account) {
        try {
            String sql = "INSERT INTO t_account(account_name,money) VALUES(?,?)";
            queryRunner.update(sql,account.getAccountName(),account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Account account) {
        String sql = "UPDATE t_account SET account_name=?,money=? WHERE account_id=?";
        try {
            queryRunner.update(sql,account.getAccountName(),account.getMoney(),account.getAccountId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM t_account WHERE account_id=?";
        try {
            queryRunner.update(sql,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
