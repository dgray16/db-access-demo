package com.inventorsoft.querydsloverjpa.db.repository;

import com.inventorsoft.querydsloverjpa.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u")
    Stream<User> getUsersStream();

}
