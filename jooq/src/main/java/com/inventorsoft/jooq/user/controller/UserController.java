package com.inventorsoft.jooq.user.controller;

import com.inventorsoft.jooq.user.model.AggregatedUserDto;
import com.inventorsoft.jooq.user.model.UserDto;
import com.inventorsoft.jooq.user.service.UserWebService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserWebService userWebService;

    @GetMapping(value = "users")
    List<UserDto> getUsers() {
        return userWebService.getAllUsers();
    }

    @GetMapping(value = "users-aggregation")
    List<AggregatedUserDto> getUsersWithAggregation() {
        return userWebService.getAllUsersWithAggregation();
    }

}
