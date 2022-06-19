package com.triple.point.domain.dto;

import com.triple.point.domain.User;
import lombok.Getter;

import java.util.UUID;

@Getter
public class UserDTO {

    private UUID id;
    private int point;
    private String name;

    public UserDTO(String name) {
        this.name = name;
    }

    public User mapToEntity() {
        return User.createUser(this.name);
    }
}
