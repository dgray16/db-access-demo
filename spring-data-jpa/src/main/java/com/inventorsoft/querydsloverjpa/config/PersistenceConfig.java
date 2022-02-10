package com.inventorsoft.querydsloverjpa.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.sql.DataSource;

@Configuration(proxyBeanMethods = false)
public class PersistenceConfig {

    @Bean
    DataSource dataSource() {
        PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:14-alpine")
                .withDatabaseName("spring-data-jpa-database")
                .withUsername("postgres")
                .withPassword("postgres");

        container.start();

        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setJdbcUrl(container.getJdbcUrl());
        hikariConfig.setUsername(container.getUsername());
        hikariConfig.setPassword(container.getPassword());
        hikariConfig.setPoolName("spring-data-jpa-hikari");

        return new HikariDataSource(hikariConfig);
    }

}
