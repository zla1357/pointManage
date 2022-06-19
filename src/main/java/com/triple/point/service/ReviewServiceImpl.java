package com.triple.point.service;

import com.triple.point.domain.Review;
import com.triple.point.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Transactional
    @Override
    public UUID registryReview(Review review) {
        reviewRepository.registryReview(review);

        return review.getId();
    }

    @Override
    public Review getReview(UUID reviewId) {
        return reviewRepository.getReview(reviewId);
    }
}
