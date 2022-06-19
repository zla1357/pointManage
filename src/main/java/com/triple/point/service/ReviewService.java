package com.triple.point.service;

import com.triple.point.domain.Review;

import java.util.UUID;

public interface ReviewService {
    public UUID registryReview(Review review);
    public Review getReview(UUID reviewId);
}
