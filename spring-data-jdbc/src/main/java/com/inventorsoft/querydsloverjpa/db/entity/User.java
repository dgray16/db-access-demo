package com.inventorsoft.querydsloverjpa.db.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("users")
@ToString(of = "id")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    Long id;

    String firstName;

}
