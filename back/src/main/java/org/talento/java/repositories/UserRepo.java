package org.talento.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.talento.java.models.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndPassword(String username, String password);
}
