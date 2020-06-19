package com.inventorsoft.querydslsql.user.controller;

import com.inventorsoft.querydslsql.user.model.UserDto;
import com.inventorsoft.querydslsql.user.service.UserWebService;
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

}
