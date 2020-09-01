package com.inventorsoft.querydsloverjpa;

import com.inventorsoft.querydsloverjpa.db.entity.User;
import com.inventorsoft.querydsloverjpa.db.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Initializer implements ApplicationListener<ApplicationReadyEvent> {

    UserRepository userRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        createOleksandr();
        createAndriy();
    }

    private void createOleksandr() {
        User user = new User();
        user.setFirstName("Oleksandr");

        userRepository.save(user);
    }

    private void createAndriy() {
        User user = new User();
        user.setFirstName("Andriy");

        userRepository.save(user);
    }

}
