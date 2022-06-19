package com.triple.point.service;

import com.triple.point.domain.User;
import com.triple.point.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UUID registryUser(User user) {
        userRepository.registryUser(user);

        return user.getId();
    }
}
