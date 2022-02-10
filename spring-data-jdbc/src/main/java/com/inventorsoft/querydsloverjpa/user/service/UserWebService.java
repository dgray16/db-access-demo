package com.inventorsoft.querydsloverjpa.user.service;

import com.inventorsoft.querydsloverjpa.db.entity.User;
import com.inventorsoft.querydsloverjpa.db.repository.UserRepository;
import com.inventorsoft.querydsloverjpa.user.model.AggregatedUserDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserWebService {

    UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.getUsersStream().toList();
    }

    @Transactional(readOnly = true)
    public List<AggregatedUserDto> getAllUsersWithAggregation() {
        return userRepository.getUsersWithAggregation();
    }

}
