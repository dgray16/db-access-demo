package com.inventorsoft.querydslsql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(proxyBeanMethods = false)
public class QueryDslSqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(QueryDslSqlApplication.class, args);
    }

}
