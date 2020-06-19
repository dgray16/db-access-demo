package com.inventorsoft.springjdbc;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Initializer implements ApplicationListener<ApplicationReadyEvent> {

    JdbcTemplate jdbcTemplate;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        createVova();
        createOleksii();
    }

    private void createVova() {
        jdbcTemplate.update("INSERT INTO users(first_name) VALUES(?)", "Vova");
    }

    private void createOleksii() {
        jdbcTemplate.update("INSERT INTO users(first_name) VALUES(?)", "Oleksii");
    }

}
