package com.example.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by SunYi on 2016/2/1/0001.
 */
@Configuration
@ComponentScan(basePackages = "com.example.domain")
@MapperScan(basePackages = "com.example.dao")
public class DataBaseConfig {
    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
//        数据库连接配置
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/example");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    //    事务管理
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(getDataSource());
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(getDataSource());
        return sqlSessionFactory.getObject();
    }
}
