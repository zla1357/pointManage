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
public class BonusPointHist {

    @Id
    @GeneratedValue
    private Long id;

    private String placeId;
    private String reviewId;
    private int placePoint;

    @CreationTimestamp
    private LocalDateTime inputDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusPointHist that = (BonusPointHist) o;
        return getPlacePoint() == that.getPlacePoint() && Objects.equals(getId(), that.getId()) && Objects.equals(getPlaceId(), that.getPlaceId()) && Objects.equals(getReviewId(), that.getReviewId()) && Objects.equals(getInputDate(), that.getInputDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPlaceId(), getReviewId(), getPlacePoint(), getInputDate());
    }
}
