package com.inventorsoft.querydsloverjpa.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration(proxyBeanMethods = false)
public class PersistenceConfig {

    @Bean
    DataSource dataSource() {
        PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:14-alpine")
                .withDatabaseName("query-dsl-over-jpa-database")
                .withUsername("postgres")
                .withPassword("postgres");

        container.start();

        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setJdbcUrl(container.getJdbcUrl());
        hikariConfig.setUsername(container.getUsername());
        hikariConfig.setPassword(container.getPassword());
        hikariConfig.setPoolName("query-dsl-over-jpa-hikari");

        return new HikariDataSource(hikariConfig);
    }

    @Bean
    JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }

}
