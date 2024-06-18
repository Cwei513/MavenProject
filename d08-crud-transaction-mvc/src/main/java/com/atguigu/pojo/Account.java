package com.atguigu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 包名:com.atguigu.pojo
 *
 * @author Leevi
 * 日期2023-05-04  10:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private  Integer accountId;
    private  String accountName;
    private Double money;
}
