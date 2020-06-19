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
        createVova();
        createOleksii();
    }

    private void createVova() {
        User user = new User();
        user.setFirstName("Natalka");

        userRepository.save(user);
    }

    private void createOleksii() {
        User user = new User();
        user.setFirstName("Anna");

        userRepository.save(user);
    }

}
