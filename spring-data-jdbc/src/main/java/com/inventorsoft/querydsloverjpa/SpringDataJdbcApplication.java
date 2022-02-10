package com.inventorsoft.querydsloverjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(proxyBeanMethods = false)
public class SpringDataJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJdbcApplication.class, args);
    }

}
