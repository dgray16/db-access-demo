package com.inventorsoft.querydsloverjpa.db.repository;

import com.inventorsoft.querydsloverjpa.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
