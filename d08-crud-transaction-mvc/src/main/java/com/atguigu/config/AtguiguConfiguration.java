package com.atguigu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 包名:com.atguigu.config
 *
 * @author Leevi
 * 日期2023-05-05  10:34
 *  Spring 纯注解开发
 *      Spring配置类
 */
//@Configuration
@ComponentScan("com.atguigu")
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import(MybatisConfiguration.class)
@EnableTransactionManagement
public class AtguiguConfiguration {
    @Value("${datasource.username}")
    private String username;

    @Value("${datasource.password}")
    private String password;

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.driverClassName}")
    private String driverClassName;

    @Bean
    public DataSource druidDataSource(){
        //1. 创建DruidDataSource对象
        DruidDataSource dataSource = new DruidDataSource();
        //2. 设置连接数据库的必要信息
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    /**
     *   TODO：纯注解开发方式开启声明式事务的注解驱动
     * @param dataSource
     * @return
     */
    @Bean
    public TransactionManager DataSourceTransactionManager(@Autowired DataSource dataSource){
        //@Autowired DataSource dataSource 这段是注入 DataSource 对象
        return new DataSourceTransactionManager(dataSource);
    }
}
