package com.triple.point.controller;

import com.triple.point.domain.dto.UserDTO;

public interface UserController {
    public String registryUser(String name);
    public UserDTO getUser(String userId);
}
