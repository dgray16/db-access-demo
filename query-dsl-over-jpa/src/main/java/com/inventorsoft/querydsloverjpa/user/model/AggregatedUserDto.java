package com.inventorsoft.querydsloverjpa.user.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AggregatedUserDto {

    String firstName;
    Long count;

}
