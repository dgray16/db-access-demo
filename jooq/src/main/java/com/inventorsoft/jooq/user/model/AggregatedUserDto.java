package com.inventorsoft.jooq.user.model;

import org.jooq.Record2;

public record AggregatedUserDto(String firstName, Integer count) {

    public static AggregatedUserDto of(Record2<String, Integer> record) {
        return new AggregatedUserDto(record.value1(), record.value2());
    }

}