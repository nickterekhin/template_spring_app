package com.terekhin.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by Nick on 28.10.17.
 */
@Configuration
public class DataSourceConfig {

    @Bean(destroyMethod = "close")
    public DataSource dataSource(@Value("${db.driver_class}") String driver, @Value("${db.url}") String dbUrl, @Value
            ("${db.username}") String username, @Value("${db.password}") String password){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
