package com.triple.point.repository;

import com.triple.point.domain.Review;

import java.util.UUID;

public interface ReviewRepository {
    public void registryReview(Review review);
    public Review getReview(UUID reviewId);
}
