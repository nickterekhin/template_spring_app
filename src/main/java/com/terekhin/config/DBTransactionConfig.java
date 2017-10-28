package com.terekhin.config;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Nick on 28.10.17.
 */
@Configuration
@EnableTransactionManagement
public class DBTransactionConfig {

    @Bean(name="hibernateTX")
    @Autowired
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory)
    {
        return new HibernateTransactionManager(sessionFactory);
    }
}
