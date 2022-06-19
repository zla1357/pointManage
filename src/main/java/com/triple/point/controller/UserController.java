package com.triple.point.controller;

import com.triple.point.domain.UserDTO;

import java.util.UUID;

public interface UserController {
    public String registryUser(String name);
    public UserDTO getUser(UUID userId);
}
