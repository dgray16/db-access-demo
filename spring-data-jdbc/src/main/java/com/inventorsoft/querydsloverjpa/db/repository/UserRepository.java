package com.inventorsoft.querydsloverjpa.db.repository;

import com.inventorsoft.querydsloverjpa.db.entity.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.stream.Stream;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT * FROM users")
    Stream<User> getUsersStream();

}
