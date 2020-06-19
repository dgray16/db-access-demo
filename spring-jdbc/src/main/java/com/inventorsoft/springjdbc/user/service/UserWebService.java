package com.inventorsoft.springjdbc.user.service;

import com.inventorsoft.springjdbc.user.model.UserDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserWebService {

    JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    public List<UserDto> getAllUsers() {
        return jdbcTemplate.query(
                "SELECT * FROM users",
                (rs, rowNum) -> new UserDto(rs.getLong("id"), rs.getString("first_name"))
        );
    }

}
