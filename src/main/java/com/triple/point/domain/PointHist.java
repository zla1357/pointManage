package com.triple.point.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

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
}
