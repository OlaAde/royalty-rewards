package org.example.royaltyrewards.services;

import org.example.royaltyrewards.entities.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByEmail(String email);

    User save(User user);

    String getCurrentUserEmail();

    User getCurrentUser() throws Exception;
}
