package com.triple.point.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Point {
    @Id
    @GeneratedValue
    private Long id;

    private String userId;
    private String placeId;
    private String images;
    private int point;
    private LocalDateTime inputDate;

    public Point (String userId, String placeId, String images) {

        this.userId = userId;
        this.placeId = placeId;
        this.images = images;
    }
}
