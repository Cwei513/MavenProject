package com.atguigu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : chen wei
 * @date : 2023/5/12 20:46
 * @Version: 1.0
 * @Description : 用户类
 */
@Data
@AllArgsConstructor//全参构造
@NoArgsConstructor//无参构造
public class User {
    private Integer id;
    private String username;
    private Integer age;
    private String address;

}
