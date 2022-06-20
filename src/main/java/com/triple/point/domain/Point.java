package com.triple.point.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

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

    private String reviewId;
    private String userId;
    private String placeId;
    private String images;
    private int point;

    @CreationTimestamp
    private LocalDateTime inputDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point1 = (Point) o;
        return getPoint() == point1.getPoint()
                && Objects.equals(getId(), point1.getId())
                && Objects.equals(getReviewId(), point1.getReviewId())
                && Objects.equals(getUserId(), point1.getUserId())
                && Objects.equals(getPlaceId(), point1.getPlaceId())
                && Objects.equals(getImages(), point1.getImages())
                && Objects.equals(getInputDate(), point1.getInputDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getReviewId(), getUserId(), getPlaceId(), getImages(), getPoint(), getInputDate());
    }

    public Point (String reviewId, String userId, String placeId, String images) {

        this.reviewId = reviewId;
        this.userId = userId;
        this.placeId = placeId;
        this.images = images;
    }
}
