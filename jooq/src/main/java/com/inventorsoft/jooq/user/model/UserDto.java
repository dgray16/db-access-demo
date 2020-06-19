package com.inventorsoft.jooq.user.model;

import com.inventorsoft.jooq.db.entity.tables.records.UsersRecord;

public record UserDto(Long id, String firstName) {

    public static UserDto of(UsersRecord jooqRecord) {
        return new UserDto(jooqRecord.getId(), jooqRecord.getFirstName());
    }

}
