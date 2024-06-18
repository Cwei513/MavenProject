package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author : chen wei
 * @Date : 2024/06/15 20:18
 * @Version: 1.0
 * @Description :
 */
@Controller
public class IndexController {
    @GetMapping({"/index.html","/"})
    public String index(){
        return "index";
    }
}
