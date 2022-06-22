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

    private String userId;
    private int pointAmount;

    @CreationTimestamp
    private LocalDateTime inputDate;

    public Point (String userId, int pointAmount) {
        this.userId = userId;
        this.pointAmount = pointAmount;
    }

    public void accumulatePoint(int amount) {
        this.pointAmount += amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return getPointAmount() == point.getPointAmount() && Objects.equals(getId(), point.getId()) && Objects.equals(getUserId(), point.getUserId()) && Objects.equals(getInputDate(), point.getInputDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserId(), getPointAmount(), getInputDate());
    }
}
