package com.atguigu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : chen wei
 * @Date : 2024/06/15 13:36
 * @Version: 1.0
 * @Description :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Integer accountId;
    private String accountName;
    private Double money;
}
