package com.inventorsoft.querydsloverjpa.user.controller;

import com.inventorsoft.querydsloverjpa.db.entity.User;
import com.inventorsoft.querydsloverjpa.user.service.UserWebService;
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
    List<User> getUsers() {
        return userWebService.getAllUsers();
    }

}
