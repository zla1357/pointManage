package com.triple.point.service;

import com.triple.point.domain.User;
import com.triple.point.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Transactional
    public UUID registryUser(User user) {
        userRepository.registryUser(user);

        return user.getId();
    }

    @Override
    public User getUser(UUID userId) {
        return userRepository.getUser(userId);
    }
}
