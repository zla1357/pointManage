package com.triple.point.service;

import com.triple.point.domain.User;

import java.util.UUID;

public interface UserService {
    public UUID registryUser(User user);
    public User getUser(UUID userId);
}
