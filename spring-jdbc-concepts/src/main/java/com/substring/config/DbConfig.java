package com.substring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.substring")
public class DbConfig
{

    @Bean
    public DataSource dataSource() {
        var dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/ecom");
        dataSource.setUsername("root");
        dataSource.setPassword("root123");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate( DataSource source ){
        return new JdbcTemplate(source);
    }
}
