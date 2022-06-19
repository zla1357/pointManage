package com.triple.point.controller;

import com.triple.point.domain.User;
import com.triple.point.domain.UserDTO;
import com.triple.point.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class UserControllerImpl implements UserController{

    private final UserService userService;

    @Override
    public String registryUser(@RequestBody String name) {

        UserDTO userDTO = new UserDTO(name);
        userService.registryUser(userDTO.mapToEntity());

        return "OK";
    }

    @Override
    public UserDTO getUser(UUID userId) {
        return null;
    }
}
