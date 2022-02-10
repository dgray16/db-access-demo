package com.inventorsoft.querydsloverjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(proxyBeanMethods = false)
public class QueryDslOverJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(QueryDslOverJpaApplication.class, args);
    }

}
