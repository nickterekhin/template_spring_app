package com.terekhin.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Nick on 15.11.17.
 */
@Configuration
@PropertySource({ "classpath:database.properties" })
@ComponentScan(basePackages = {"com.terekhin.database","com.terekhin.domain"})
@EnableTransactionManagement
public class DBContextConfig {

    private static final String DATABASE_PROPERTIES_FILE = "database.properties";
    @Bean
    public static PropertySourcesPlaceholderConfigurer devProperties(){
        PropertySourcesPlaceholderConfigurer p = new PropertySourcesPlaceholderConfigurer();
        Resource[] resourceLocations = new Resource[] {
                new ClassPathResource(DATABASE_PROPERTIES_FILE)
        };
        p.setLocations(resourceLocations);
        return p;
    }

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
    @Bean(name="hibernate_TX")
    @Autowired
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory)
    {
        return new HibernateTransactionManager(sessionFactory);
    }
}
