package com.triple.point.domain.dto;

import com.triple.point.domain.ModelMapperUtils;
import com.triple.point.domain.User;
import lombok.*;

import java.util.UUID;

@Getter
@NoArgsConstructor
@Setter
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

    public static UserDTO from(User user) {
        return ModelMapperUtils.getModelMapper().map(user, UserDTO.class);
    }
}
