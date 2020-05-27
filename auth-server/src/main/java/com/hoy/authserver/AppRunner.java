package com.hoy.authserver;

import com.hoy.authserver.user.User;
import com.hoy.authserver.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class AppRunner implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        log.info(String.valueOf(AppRunner.class), "Data Initializing");
        User user = User
                .builder()
                .date(LocalDateTime.now())
                .userType(0)
                .username("hong")
                .password(new BCryptPasswordEncoder().encode("1234"))
                .build();

        userRepository.save(user);

    }
}
