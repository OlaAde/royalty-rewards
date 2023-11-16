package org.example.royaltyrewards.services.impls;

import lombok.RequiredArgsConstructor;
import org.example.royaltyrewards.entities.User;
import org.example.royaltyrewards.repositories.UserRepository;
import org.example.royaltyrewards.services.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }


    @Override
    public String getCurrentUserEmail() {
        UsernamePasswordAuthenticationToken authentication = ((UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication());
        return authentication.getName();
    }

    @Override
    public User getCurrentUser() throws Exception {
        String email = getCurrentUserEmail();
        return userRepository.findByEmail(email).orElseThrow(() -> new Exception("Current user not found"));
    }
}
