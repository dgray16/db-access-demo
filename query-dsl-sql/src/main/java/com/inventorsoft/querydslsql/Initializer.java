package com.inventorsoft.querydslsql;

import com.inventorsoft.querydslsql.db.entity.QUsers;
import com.querydsl.sql.postgresql.PostgreSQLQueryFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Initializer implements ApplicationListener<ApplicationReadyEvent> {

    PostgreSQLQueryFactory postgreSQLQueryFactory;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        createVova();
        createOleksii();
    }

    private void createVova() {
        postgreSQLQueryFactory
                .insert(QUsers.users)
                .columns(QUsers.users.firstName)
                .values("Oleg")
                .execute();
    }

    private void createOleksii() {
        postgreSQLQueryFactory
                .insert(QUsers.users)
                .columns(QUsers.users.firstName)
                .values("Igor")
                .execute();
    }

}
