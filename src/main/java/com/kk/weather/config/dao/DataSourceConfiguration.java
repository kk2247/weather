package com.kk.weather.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

//为数据库连接提供服务
//告诉spring容器需要来到这个类下面检索相关的bean
@Configuration
//配置Mybatis mapper的扫描路径
@MapperScan("com.kk.weather.dao")
public class DataSourceConfiguration {
//    将对应的变量从配置文件中引入进来
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    //    在ioc中注册一个叫dataSource的bean
    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
//        连接池的配置
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
//        关闭连接后不自动进行提交
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}

