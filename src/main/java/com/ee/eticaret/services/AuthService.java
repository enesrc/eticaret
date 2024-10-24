package com.ee.eticaret.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ee.eticaret.entities.User;
import com.ee.eticaret.repositories.UserRepository;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public boolean signup(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return false;
        } else {
            userRepository.save(user);
            return true;
        }
    }

    public boolean signin(User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        return existingUser.isPresent() && existingUser.get().getPassword().equals(user.getPassword());
    }
}