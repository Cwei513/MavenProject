package com.atguigu.controller;

import com.atguigu.pojo.Account;
import com.atguigu.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 包名:com.atguigu.controller
 *
 * @author Leevi
 * 日期2023-05-04  10:49
 */

@Controller
@RequestMapping("/account")
public class AccountController {
    @Resource
    //@Qualifier("accountServiceImplAnother")
    private AccountService accountService;


    @GetMapping
    public String findAll(Model model){
        //调用业务层的方法查询账户
        List<Account> accountList = accountService.findAll();
        // 将查询到的数据存到请求域
        model.addAttribute("accountList",accountList);
        // 解析视图(返回逻辑视图)
        return "list";
    }
    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Integer id,Model model){
        Account account = accountService.findById(id);
        model.addAttribute("account",account);
        return "account";
    }
    @PostMapping
    public String save(Account account) throws ClassNotFoundException {
        accountService.save(account);
        // 重定向查询所有数据
        return "redirect:/account";
    }
    @PutMapping
    public String update(Account account){
        accountService.update(account);
        // 重定向查询所有数据
        return  "redirect:/account";
    }
    @DeleteMapping("/{id}")
    public String deleteById(Integer id){
        accountService.deleteById(id);
        // 重定向查询所有数据
        return "redirect:/account";
    }
}
