package org.example.royaltyrewards.services.impls;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.example.royaltyrewards.services.UserService;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuditorAwareImpl implements AuditorAware {

    private final UserService userService;

    @NotNull
    @Override
    public Optional<String> getCurrentAuditor() {
        String email = userService.getCurrentUserEmail();
        return Optional.of(email);
    }
}