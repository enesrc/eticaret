package com.ee.eticaret.repositories;

import org.springframework.data.repository.CrudRepository;
import com.ee.eticaret.entities.User;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}