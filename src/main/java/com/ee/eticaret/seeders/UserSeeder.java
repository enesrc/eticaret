package com.ee.eticaret.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ee.eticaret.entities.User;
import com.ee.eticaret.repositories.UserRepository;

import java.util.Arrays;

@Component
public class UserSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) {
        
        userRepository.deleteAll();
        
        User user1 = new User();
        user1.setName("elif");
        user1.setEmail("elif@gmail.com");
        user1.setUsername("eliff");
        user1.setPassword("123");

        User user2 = new User();
        user2.setName("enes");
        user2.setEmail("enes@gmail.com");
        user2.setUsername("eness");
        user2.setPassword("123");

        userRepository.saveAll(Arrays.asList(user1, user2));
    }
}