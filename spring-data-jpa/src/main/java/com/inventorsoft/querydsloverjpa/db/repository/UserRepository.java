package com.inventorsoft.querydsloverjpa.db.repository;

import com.inventorsoft.querydsloverjpa.db.entity.User;
import com.inventorsoft.querydsloverjpa.user.model.AggregatedUserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.stream.Stream;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u")
    Stream<User> getUsersStream();

    @Query("""
        select new com.inventorsoft.querydsloverjpa.user.model.AggregatedUserDto(u.firstName, count(u.firstName)) 
        from User u 
        group by u.firstName
    """)
    List<AggregatedUserDto> getUsersWithAggregation();

}
