package com.inventorsoft.querydslsql.config;

import com.querydsl.sql.postgresql.PostgreSQLQueryFactory;
import com.querydsl.sql.spring.SpringConnectionProvider;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfig {

    @Bean
    DataSource dataSource() {
        JdbcDatabaseContainer container = new PostgreSQLContainer("postgres:12-alpine")
                .withDatabaseName("query-dsl-sql-database")
                .withUsername("postgres")
                .withPassword("postgres")
                .withInitScript("init.sql");

        container.start();

        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setJdbcUrl(container.getJdbcUrl());
        hikariConfig.setUsername(container.getUsername());
        hikariConfig.setPassword(container.getPassword());
        hikariConfig.setPoolName("query-dsl-sql-hikari");

        return new HikariDataSource(hikariConfig);
    }

    @Bean
    PostgreSQLQueryFactory postgreSQLQueryFactory() {
        return new PostgreSQLQueryFactory(new SpringConnectionProvider(dataSource()));
    }

}
