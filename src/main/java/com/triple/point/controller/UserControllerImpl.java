package com.triple.point.controller;

import com.triple.point.domain.User;
import com.triple.point.domain.dto.UserDTO;
import com.triple.point.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class UserControllerImpl implements UserController{

    private final UserService userService;

    @PostMapping("user")
    @ResponseBody
    @Override
    public String registryUser(@RequestParam String name) {

        UserDTO userDTO = new UserDTO(name);
        UUID uuid = userService.registryUser(userDTO.mapToEntity());

        return "OK";
    }

    @GetMapping("user")
    @ResponseBody
    @Override
    public UserDTO getUser(@RequestParam String userId) {

        UUID userUUID = UUIDConverter.convertFromString(userId);
        User user = userService.getUser(userUUID);

        return UserDTO.from(user);
    }
}
