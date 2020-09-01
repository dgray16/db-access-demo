package com.inventorsoft.jooq.user.service;

import com.inventorsoft.jooq.db.entity.tables.JUsers;
import com.inventorsoft.jooq.user.model.UserDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
                .collect(Collectors.toUnmodifiableList());
    }

}
