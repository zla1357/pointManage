package com.triple.point.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PointHist {

    @Id
    @GeneratedValue
    private Long id;

    private String userId;
    private String reviewId;
    private int contentPoint;
    private int imagePoint;

    @CreationTimestamp
    private LocalDateTime inputDate;

    public static PointHist createPointHist(String userId, String reviewId, int contentPoint, int imagePoint) {
        PointHist pointHist = new PointHist();
        pointHist.userId = userId;
        pointHist.reviewId = reviewId;
        pointHist.contentPoint = contentPoint;
        pointHist.imagePoint = imagePoint;

        return pointHist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointHist pointHist = (PointHist) o;
        return getContentPoint() == pointHist.getContentPoint() && getImagePoint() == pointHist.getImagePoint() && Objects.equals(getId(), pointHist.getId()) && Objects.equals(getUserId(), pointHist.getUserId()) && Objects.equals(getReviewId(), pointHist.getReviewId()) && Objects.equals(getInputDate(), pointHist.getInputDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserId(), getReviewId(), getContentPoint(), getImagePoint(), getInputDate());
    }
}
