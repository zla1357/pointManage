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

    @Override
    @PostMapping("user")
    @ResponseBody
    public String registryUser(@RequestParam String name) {

        UserDTO userDTO = new UserDTO(name);
        UUID uuid = userService.registryUser(userDTO.mapToEntity());

        return "OK";
    }

    @Override
    @GetMapping("user")
    @ResponseBody
    public UserDTO getUser(@RequestParam String userId) {

        UUID userUUID = UUID.fromString (userId
                        .replaceFirst (
                                "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)",
                                "$1-$2-$3-$4-$5"
                        )
        );
        User user = userService.getUser(userUUID);

        return UserDTO.from(user);
    }
}
