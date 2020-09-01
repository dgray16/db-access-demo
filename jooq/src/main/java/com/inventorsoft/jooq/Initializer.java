package com.inventorsoft.jooq;

import com.inventorsoft.jooq.db.entity.tables.JUsers;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jooq.DSLContext;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Initializer implements ApplicationListener<ApplicationReadyEvent> {

    DSLContext dslContext;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        createAnton();
        createAnatolii();
    }

    private void createAnton() {
        dslContext
                .insertInto(JUsers.USERS)
                .columns(JUsers.USERS.FIRST_NAME)
                .values("Anton")
                .execute();
    }

    private void createAnatolii() {
        dslContext
                .insertInto(JUsers.USERS)
                .columns(JUsers.USERS.FIRST_NAME)
                .values("Anatolii")
                .execute();
    }

}
