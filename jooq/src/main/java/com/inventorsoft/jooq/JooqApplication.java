package com.inventorsoft.jooq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(proxyBeanMethods = false)
public class JooqApplication {

    public static void main(String[] args) {
        SpringApplication.run(JooqApplication.class, args);
    }

}
