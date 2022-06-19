package com.triple.point.repository;

import com.triple.point.domain.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepository{

    private final EntityManager em;

    @Override
    public void registryReview(Review review) {
        em.persist(review);
    }

    @Override
    public Review getReview(UUID reviewId) {
        return em.find(Review.class, reviewId);
    }
}
