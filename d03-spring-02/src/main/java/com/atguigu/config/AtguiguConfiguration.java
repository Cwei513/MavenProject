package com.atguigu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @Author : chen wei
 * @Date : 2024/06/14 17:05
 * @Version: 1.0
 * @Description :
 */
@Configuration
@ComponentScan("com.atguigu")
@PropertySource("classpath:application.properties")
public class AtguiguConfiguration {

    @Value("${datasource.driverClassName}")
    private String driverClassName;
    @Value("${datasource.url}")
    private String url;
    @Value("${datasource.username}")
    private String username;
    @Value("${datasource.password}")
    private String password;
    @Bean
    public DataSource druidDataSource(){
        // 创建DruidDataSource对象
        DruidDataSource druidDataSource = new DruidDataSource();
        // 设置数据库连接信息
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }

    @Bean
    public QueryRunner queryRunner(@Autowired DataSource dataSource){
        //1. 创建QueryRunner对象
        QueryRunner queryRunner = new QueryRunner(dataSource);
        return queryRunner;
    }
}
