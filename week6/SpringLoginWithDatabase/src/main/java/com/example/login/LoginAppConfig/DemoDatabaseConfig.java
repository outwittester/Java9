package com.example.login.LoginAppConfig;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.example.login")
@PropertySource("classpath:application.properties")
public class DemoDatabaseConfig {

    //set up variable to hold the properties
    @Autowired
    private Environment env;


    //define a bean for our security datasource
    @Bean
    DataSource securityDataSource() {
        //create connection pool
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

        //set the jdbc driver class
        try {
            securityDataSource.setDriverClass(env.getProperty("spring.datasource.driver-class-name"));
        } catch (PropertyVetoException exc) {
            throw new RuntimeException(exc);
        }

        //set database connection props
        securityDataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
        securityDataSource.setUser(env.getProperty("spring.datasource.username"));
        securityDataSource.setPassword(env.getProperty("spring.datasource.password"));

        return securityDataSource;
    }
}
