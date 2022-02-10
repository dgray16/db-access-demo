package com.inventorsoft.jooq.user.service;

import com.inventorsoft.jooq.db.entity.tables.JUsers;
import com.inventorsoft.jooq.user.model.AggregatedUserDto;
import com.inventorsoft.jooq.user.model.UserDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserWebService {

    DSLContext dslContext;

    @Transactional(readOnly = true)
    public List<UserDto> getAllUsers() {
        return dslContext
                .selectFrom(JUsers.USERS)
                .fetchStream()
                .map(UserDto::of)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<AggregatedUserDto> getAllUsersWithAggregation() {
        return dslContext
                .select(JUsers.USERS.FIRST_NAME, DSL.count(JUsers.USERS.FIRST_NAME))
                .from(JUsers.USERS)
                .groupBy(JUsers.USERS.FIRST_NAME)
                .fetchStream()
                .map(AggregatedUserDto::of)
                .toList();
    }

}
