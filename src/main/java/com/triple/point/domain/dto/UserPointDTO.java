package com.triple.point.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserPointDTO {
    String userId;
    int pointAmount;
}
