package com.inventorsoft.querydsloverjpa.db.repository;

import com.inventorsoft.querydsloverjpa.db.entity.User;
import com.inventorsoft.querydsloverjpa.user.model.AggregatedUserDto;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Stream;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT * FROM users")
    Stream<User> getUsersStream();

    @Query("SELECT u.first_name, count(u.first_name) FROM users u GROUP BY u.first_name")
    List<AggregatedUserDto> getUsersWithAggregation();

}
