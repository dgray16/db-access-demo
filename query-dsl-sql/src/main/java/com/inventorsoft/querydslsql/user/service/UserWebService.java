package com.inventorsoft.querydslsql.user.service;

import com.inventorsoft.querydslsql.db.entity.QUsers;
import com.inventorsoft.querydslsql.user.model.AggregatedUserDto;
import com.inventorsoft.querydslsql.user.model.UserDto;
import com.querydsl.core.types.Projections;
import com.querydsl.sql.postgresql.PostgreSQLQueryFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserWebService {

    PostgreSQLQueryFactory postgreSqlQueryFactory;

    @Transactional(readOnly = true)
    public List<UserDto> getAllUsers() {
        return postgreSqlQueryFactory
                .select(Projections.constructor(UserDto.class, QUsers.users.id, QUsers.users.firstName))
                .from(QUsers.users)
                .fetch();
    }

    @Transactional(readOnly = true)
    public List<AggregatedUserDto> getAllUsersWithAggregation() {
        return postgreSqlQueryFactory
                .select(Projections.constructor(AggregatedUserDto.class, QUsers.users.firstName, QUsers.users.firstName.count()))
                .from(QUsers.users)
                .groupBy(QUsers.users.firstName)
                .fetch();
    }

}
