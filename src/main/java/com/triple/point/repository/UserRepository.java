package com.triple.point.repository;

import com.triple.point.domain.User;

import java.util.UUID;

public interface UserRepository {
    public void registryUser(User user);
    public User getUser(UUID userId);
}
