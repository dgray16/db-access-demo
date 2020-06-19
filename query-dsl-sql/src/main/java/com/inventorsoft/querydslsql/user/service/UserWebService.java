package com.inventorsoft.querydslsql.user.service;

import com.inventorsoft.querydslsql.db.entity.QUsers;
import com.inventorsoft.querydslsql.user.model.UserDto;
import com.querydsl.core.types.Projections;
import com.querydsl.sql.postgresql.PostgreSQLQueryFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserWebService {

    PostgreSQLQueryFactory postgreSqlQueryFactory;

    @SneakyThrows
    public List<UserDto> getAllUsers() {
        return postgreSqlQueryFactory
                .select(Projections.constructor(UserDto.class, QUsers.users.id, QUsers.users.firstName))
                .from(QUsers.users)
                .fetch();
    }

}
