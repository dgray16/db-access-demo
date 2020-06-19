package com.inventorsoft.springjdbc.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.sql.DataSource;

@Configuration(proxyBeanMethods = false)
public class PersistenceConfig {

    @Bean
    DataSource dataSource() {
        JdbcDatabaseContainer container = new PostgreSQLContainer("postgres:12-alpine")
                .withDatabaseName("spring-jdbc-database")
                .withUsername("postgres")
                .withPassword("postgres")
                .withInitScript("init.sql");

        container.start();

        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setJdbcUrl(container.getJdbcUrl());
        hikariConfig.setUsername(container.getUsername());
        hikariConfig.setPassword(container.getPassword());
        hikariConfig.setPoolName("spring-jdbc-hikari");

        return new HikariDataSource(hikariConfig);
    }

}
