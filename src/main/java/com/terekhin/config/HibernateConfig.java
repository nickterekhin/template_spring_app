package com.terekhin.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Nick on 28.10.17.
 */

@Configuration
@PropertySource({ "classpath:database.properties" })
public class HibernateConfig {

    @Bean
    public Properties hibernateProps( @Value("${db.hibernate.dialect}") String dialect,
                                      @Value("${db.hibernate.show_sql}") boolean showSql,
                                      @Value("${db.hibernate.format_sql}") boolean formatSql,
                                      @Value("${db.hibernate.hdm2ddl.auto}") String hbm2ddl)
    {
        Properties properties = new Properties();
        properties.put("hibernate.dialect",dialect);
        properties.put("hibernate.show_sql",showSql);
        properties.put("hibernate.format_sql",formatSql);
        properties.put("hibernate.hdm2ddl.auto",hbm2ddl);

        return properties;
    }

    @Bean
    public SessionFactory sessionFactory(DataSource dataSource, @Value("${db.hibernate.packagesToScan}") String packagesToScan,@Qualifier
            ("hibernateProps") Properties props) throws IOException {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan(packagesToScan);
        sessionFactoryBean.setHibernateProperties(props);
        sessionFactoryBean.afterPropertiesSet();

        return sessionFactoryBean.getObject();
    }
}
